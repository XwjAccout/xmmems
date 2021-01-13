package com.xmmems.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.*;
import com.xmmems.domain.NetWork;
import com.xmmems.domain.base.BaseSite;
import com.xmmems.domain.base.BaseSiteExample;
import com.xmmems.domain.env.EnvQualityConf;
import com.xmmems.dto.BaseSiteDTO;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static com.xmmems.common.utils.DateFormat.yyyy_MM_dd_HH;

@Service
@Transactional
@Slf4j
public class MonitorService {
    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;
    @Autowired
    private BaseSiteMapper baseSiteMapper;
    @Autowired
    private EnvHourDataMapper envHourDataMapper;
    @Autowired
    private EnvRealtimeDataMapper envRealtimeDataMapper;
    @Autowired
    private BaseService baseService;
    @Autowired
    private RealtimeDataService rds;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;
    @Autowired
    private NetWorkService netWorkService;

    private static final TypeReference<List<Map<String, String>>> type = new TypeReference<List<Map<String, String>>>() {
    };

    public List<BaseSiteitemDTO> getColumns(Integer siteId) {
        return commonService.getBaseSiteItemBySiteId(siteId);
    }

    public List<BaseSiteitemDTO> getColumnsAll() {
        //查询站点id
        BaseSiteExample example = new BaseSiteExample();
        example.setOrderByClause("id desc");
        BaseSiteExample.Criteria criteria = example.createCriteria();
        criteria.andIsvalidEqualTo("1");

        List<BaseSite> baseSites = baseSiteMapper.selectByExample(example);
        String[] sList = new String[baseSites.size()];
        for (int i = 0; i < baseSites.size(); i++) {
            sList[i] = baseSites.get(i).getId().toString();
        }
        String s = StringUtils.join(sList, ",");
        //根据所有站点id查询监测项目
        List<BaseSiteitemDTO> list = baseSiteitemMapper.getColumnsAll(s);

        if (list.size() == 0) {
            throw new XMException(ExceptionEnum.MONITORREPORT_NOT_FOUND);
        }
        return list;
    }

    public List<BaseSiteDTO> getSites() {
        List<BaseSiteDTO> list = baseSiteMapper.getSites(UserHolder.loginId());
        if (list.size() == 0) {
            throw new XMException(ExceptionEnum.BASESITE_NOT_FOUND);
        }
        return list;
    }

    public List<Map<String, String>> week(Integer siteId, Integer year, Integer week, List<Integer> statistics, Boolean limit) {
        //获取year年第year周的开始日期与结束日期
        String start = WeekToDateUtil.getStartDay(year, week) + " 00:00:00";
        String end = WeekToDateUtil.getEndDay(year, week) + " 23:59:59";
        return month(siteId, start, end, statistics, limit);
    }

    public List<Map<String, String>> month(Integer siteId, String startTime, String endTime, List<Integer> statistics, Boolean limit) {
        ReportThreadLocal.setTL("month", 0, limit);
        if (startTime.length() == 10) {
            startTime += " 00:00:00";
        }
        if (endTime.length() == 10) {
            endTime += " 23:59:59";
        }
        String eH = endTime.split(" ")[1].substring(0, 2);
        String s = startTime.split(" ")[1];
        if (s.equals("00:00:00")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                startTime = simpleDateFormat.format(simpleDateFormat.parse(startTime).getTime() - 10000);
                s = startTime.split(" ")[1];
            } catch (ParseException e) {
                throw new XMException(500, "com.xmmems.service.MonitorService 821行，日期格式化出错");
            }
        }
        String sH = s.substring(0, 2);

        List<Map<String, String>> returnMonthData = new ArrayList<>();
        Res res = getHourDataAndDayNum(siteId, startTime, endTime);
        int dayNum = res.dayNum;
        ReportThreadLocal.getTL().setAll(dayNum - 1);
        //获取站点siteId对应的有效的监测指标
        Map<String, Integer> itemNameAndNumbersMap = getitemNameAndNumbersMap(siteId);
        handlerMonthDataList(siteId, returnMonthData, dayNum, itemNameAndNumbersMap, res.listMap, null, statistics, eH, sH);
        return returnMonthData;
    }

    /**
     * 处理月份集合
     */
    private void handlerMonthDataList(Integer siteId, List<Map<String, String>> returnMonthData, int dayNum, Map<String, Integer> itemNameAndNumbersMap,
                                      List<Map<String, Object>> listMap, List<Map<String, String>> returnYearData, List<Integer> statistics, String eH, String sH) {
        if (listMap.size() > 0) {
            //按照日期分组
            Map<String, List<Map<String, Object>>> moniterTimeList = handleOneHourDataIntoOneDayDataList(listMap);
            List<Map<String, String>> MonthData = new ArrayList<>();
            List<Map<String, String>> MonthDataOfDayAvg = new ArrayList<>();
            //按照一天的平均值计算当天的值
            for (Map.Entry<String, List<Map<String, Object>>> entry0 : moniterTimeList.entrySet()) {
                //同一天的数据
                String dateStr = entry0.getKey();
                List<Map<String, Object>> dataList = entry0.getValue();
                List<Map<String, String>> returnData = new ArrayList<>();

                handlerDayDataList(siteId, returnData, dayNum, itemNameAndNumbersMap, dataList, MonthData, returnYearData, statistics, eH, sH);

                //获取最后一个值（平均值）
                Map<String, String> avgmap = returnData.get(returnData.size() - 1);
                if (!avgmap.get("moniterTime").equals("平均值")) {
                    throw new XMException(500, "月报表时每天的数据不是平均值");
                }
                avgmap.put("moniterTime", dateStr);
                returnMonthData.add(avgmap);
                MonthDataOfDayAvg.add(avgmap);
            }

            Map<String, List<String>> itemNameAndValuesListOfDay = getitemNameAndValuesList(MonthData);
            Map<String, List<String>> itemNameAndValuesList = getitemNameAndValuesList(MonthDataOfDayAvg);
            boolean isAvg = returnYearData != null;
            //月报表时时段累计流量需要用日累计流量累加，年报表需要月累计流量累加, 月 MM 年 YY
            handleOtherIntoReturnData(returnMonthData, itemNameAndValuesList, siteId, dayNum, itemNameAndNumbersMap, isAvg, statistics, "MM", itemNameAndValuesListOfDay, eH, sH);

        }
    }

    private static Map<String, List<Map<String, Object>>> handleOneHourDataIntoOneDayDataList(List<Map<String, Object>> listMap) {
        //LinkedHashMap 为了 按照日期排序
        Map<String, List<Map<String, Object>>> moniterTimeList = new LinkedHashMap<>();

        for (Map<String, Object> map : listMap) {
            String moniterTime = map.get("moniterTime").toString().substring(0, 10);
            List<Map<String, Object>> temp = moniterTimeList.computeIfAbsent(moniterTime, k -> new ArrayList<>());
            temp.add(map);
        }
        return moniterTimeList;
    }

    public static int getMonthNum(String str1, String str2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        try {
            bef.setTime(sdf.parse(str1));
            aft.setTime(sdf.parse(str2));
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            return Math.abs(month + result) + 1;
        } catch (ParseException ignore) {
            throw new XMException(500, "时间解析出错");
        }
    }

    public List<Map<String, String>> year(Integer siteId, String startTime, String endTime, List<Integer> statistics, Boolean limit) {
        ReportThreadLocal.setTL("year", 0, limit);
        if (startTime.length() == 10) {
            startTime += " 00:00:00";
        }
        if (endTime.length() == 10) {
            endTime += " 23:59:59";
        }
        //计算间隔几个月
        int monthNum = getMonthNum(startTime, endTime);
        ReportThreadLocal.setAll(monthNum);

        String eH = endTime.split(" ")[1].substring(0, 2);
        String s = startTime.split(" ")[1];
        if (s.equals("00:00:00")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                startTime = simpleDateFormat.format(simpleDateFormat.parse(startTime).getTime() - 10000);
                s = startTime.split(" ")[1];
            } catch (ParseException e) {
                throw new XMException(500, "com.xmmems.service.MonitorService 224行，日期格式化出错");
            }
        }
        String sH = s.substring(0, 2);

        List<Map<String, String>> returnYearData = new ArrayList<>();
        Res res = getHourDataAndDayNum(siteId, startTime, endTime);
        int dayNum = res.dayNum;
        List<Map<String, Object>> listMap = res.listMap;

        //获取站点siteId对应的有效的监测指标
        Map<String, Integer> itemNameAndNumbersMap = getitemNameAndNumbersMap(siteId);
        if (listMap.size() > 0) {
            //按照月份分組
            Map<String, List<Map<String, Object>>> moniterTimeList = handleOneHourDataIntoOneMonthDataList(listMap);
            List<Map<String, String>> yearDataList = new ArrayList<>();
            List<Map<String, String>> yearDataListOfMonth = new ArrayList<>();
            //按照一月的平均值计算当天的值
            for (Map.Entry<String, List<Map<String, Object>>> entry0 : moniterTimeList.entrySet()) {
                //同一个月的数据
                String monthStr = entry0.getKey();
                List<Map<String, Object>> monthList = entry0.getValue();

                List<Map<String, String>> returnData = new ArrayList<>();
                handlerMonthDataList(siteId, returnData, dayNum, itemNameAndNumbersMap, monthList, yearDataList, statistics, eH, sH);
                //获取月份平均值，存进年报表的
                Map<String, String> avgmap = returnData.get(returnData.size() - 1);
                if (!avgmap.get("moniterTime").equals("平均值")) {
                    throw new XMException(500, "年报表时每月的数据不是平均值");
                }
                avgmap.put("moniterTime", monthStr);
                returnYearData.add(avgmap);
                yearDataListOfMonth.add(avgmap);
            }
            Map<String, List<String>> itemNameAndValuesListOfMonth = getitemNameAndValuesList(yearDataList);
            Map<String, List<String>> itemNameAndValuesList = getitemNameAndValuesList(yearDataListOfMonth);

            handleOtherIntoReturnData(returnYearData, itemNameAndValuesList, siteId, dayNum, itemNameAndNumbersMap, false, statistics, "yy", itemNameAndValuesListOfMonth, eH, sH);

        }
        return returnYearData;
    }

    private Map<String, List<Map<String, Object>>> handleOneHourDataIntoOneMonthDataList(List<Map<String, Object>> listMap) {
        //LinkedHashMap 为了 按照日期排序
        Map<String, List<Map<String, Object>>> moniterTimeList = new LinkedHashMap<>();

        for (Map<String, Object> map : listMap) {
            String moniterTime = map.get("moniterTime").toString().substring(0, 7);
            List<Map<String, Object>> temp = moniterTimeList.computeIfAbsent(moniterTime, k -> new ArrayList<>());
            temp.add(map);
        }
        return moniterTimeList;
    }

    //计算俩个日期的天数差
    public static int getDaysBetween(Date beginDate, Date endDate) {
        //Calendar日历类
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime() + 86400000;

        int betweenDays = (int) ((endTime - beginTime) / 86400000);//先算出两时间的毫秒数之差大于一天的天数

        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays - 1);//使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        //endCalendar.add(Calendar.DAY_OF_MONTH, -1);//再使endCalendar减去1天
        if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH))//比较两日期的DAY_OF_MONTH是否相等
        {
            return betweenDays + 1;    //相等说明确实跨天了
        } else {
            return betweenDays;    //不相等说明确实未跨天
        }
    }

    /**
     * 实时监测数据
     */
    public List<Map<String, Object>> getRealTimeData() {
        List<Map<String, Object>> list = envRealtimeDataMapper.getRealTimeData(UserHolder.loginId());

        if (list.size() > 0) {
            for (Map<String, Object> site : list) {
                String siteId = site.get("siteId") + "";
                List<Map<String, String>> limit = baseSiteitemMapper.getDetectionLimit(Integer.valueOf(siteId));
                Map<String, String> limitMap = new HashMap<>();
                if (limit.size() > 0) {
                    limit.forEach(temp -> limitMap.put(temp.get("itemId"), temp.get("limitNum")));
                }

                List<BaseSiteitemDTO> columns = getColumns(Integer.valueOf(siteId));
                List<String> collect = columns.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());

                List<Map<String, String>> monitorItemList = JsonUtils.nativeRead(site.get("content").toString(), type);
                site.remove("content");
                site.put("moniterTime", site.get("moniterTime").toString().replace(".0", ""));
                //分项类别水质
                Map<String, String> subCategoryMap = new HashMap<>();
                for (Map<String, String> monitorItem : monitorItemList) {
                    String itemName = monitorItem.get("itemName");
                    if (collect.contains(itemName)) {

                        String value = monitorItem.get("value");
                        //获取监测值格式化与设置是否正常标志$$
                        String value1 = handlerValue(monitorItem, limitMap);
                        subCategoryMap.put(itemName, itemSubCategory(itemName, value, Integer.parseInt(siteId)));
                        String s = subCategoryMap.get(itemName);
                        if (s.contains(("$$"))) {
                            value1 = value1 + "$$";
                        }
                        site.put(itemName, value1);

                    }
                }
                //总类别水质
                String level = itemWaterQualityCategory(Integer.parseInt(site.get("siteId") + ""), subCategoryMap);
                site.put("level", level);
                site.put("levelStandard", WaterLevelTransformUtil.levelIntToLevelString(Integer.parseInt(site.get("levelStandard") + "")));
            }
        }
        return list;
    }

    private String handlerValue(Map<String, String> contentItem, Map<String, String> limit) {

        String itemName = contentItem.get("itemName");
        String troubleCode = contentItem.get("troubleCode");
        String value = contentItem.get("value");
        String itemId = contentItem.get("itemId");
        //检出限键值对  总磷=0.01
        String b = limit.get(itemId.replace(".0", ""));
        //检出限
        String scale = rds.scale(itemName, value);
        if (value.length() > 0) {

            if (StringUtils.isNotBlank(troubleCode) && !"N".equals(troubleCode) && !" N".equals(troubleCode)) {
                value = scale + "$$" + troubleCode;
            } else if (b != null && Double.parseDouble(value) <= Double.parseDouble(b)) {
                //value = "$$≤" + b;
            }
        }
        if (value.contains("$$")) {
            //在这里value 可能为 12  ，12$$T  ,12$$M  等情况
            return value;
        } else {
            return scale;
        }
    }

    /**
     * 查询历史数据
     */
    public PageResult<Map<String, Object>> getHistoryData(Integer limit, Integer page, Integer siteId, String startTime, String endTime, String order, Boolean original) {

        //封装分页信息
        PageHelper.startPage(page, limit);
        //封装查询条件
        List<Map<String, Object>> records = envHourDataMapper.selectHistoryData(siteId, startTime, endTime, order);
        if (CollectionUtils.isEmpty(records)) {
            throw new XMException(ExceptionEnum.ENVHOURDATA_NOT_FOUND);
        }
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(records);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Map<String, Object> record : records) {
            List<Map<String, String>> monitorItemList = JsonUtils.nativeRead(record.get("content").toString(), type);
            //record.remove("content"); //不可去除，数据审批需要用
            for (Map<String, String> monitorItem : monitorItemList) {

                String v = monitorItem.get("value");
                String value = rds.formatValue(monitorItem.get("itemName"), v);
                if (original) record.put(monitorItem.get("itemName"), value + "^" + v);
                else record.put(monitorItem.get("itemName"), value);
            }
            record.put("genTime", sdf.format(record.get("genTime")));
        }

        //因为中间经过处理，所以分页插件总数需要重新设置
        int pageSize = mapPageInfo.getSize();
        //因为中间经过处理，所以分页插件总数需要重新设置
        int pages = mapPageInfo.getPages();
        //因为中间经过处理，所以分页插件总数需要重新设置
        long total = mapPageInfo.getTotal();
        return new PageResult<>(pageSize, page, total, pages, records);
    }

    private void handlerMonthDataCurve(List<Map<String, String>> returnMonthData, List<Map<String, Object>> listMap, Boolean isYear) {
        if (listMap.size() > 0) {
            //按照日期分组
            Map<String, List<Map<String, Object>>> moniterTimeList = handleOneHourDataIntoOneDayDataList(listMap);
            List<Map<String, String>> MonthData = new ArrayList<>();
            //按照一天的平均值计算当天的值
            for (Map.Entry<String, List<Map<String, Object>>> entry0 : moniterTimeList.entrySet()) {
                //同一天的数据
                String dateStr = entry0.getKey();
                List<Map<String, Object>> dataList = entry0.getValue();
                List<Map<String, String>> returnData = new ArrayList<>();

                handlerDayDataCurve(returnData, dataList, MonthData);

                if (!isYear) {

                    //获取最后一个值（平均值）
                    Map<String, String> avgmap = returnData.get(returnData.size() - 1);
                    if (!avgmap.get("moniterTime").equals("平均值")) {
                        throw new XMException(500, "月曲线的数据不是平均值");
                    }
                    avgmap.put("moniterTime", dateStr);
                    returnMonthData.add(avgmap);
                }
            }

            Map<String, List<String>> itemNameAndValuesList = getitemNameAndValuesList(MonthData);
            if (isYear) {
                handleOtherIntoReturnDataCurve(returnMonthData, itemNameAndValuesList);
            }
        }
    }

    private Map<String, List<String>> getitemNameAndValuesList(List<Map<String, String>> maps) {
        Map<String, List<String>> itemNameAndValuesList = new HashMap<>();
        for (Map<String, String> map : maps) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().length() > 0) {
                    itemNameAndValuesList.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(entry.getValue());
                }
            }
        }
        return itemNameAndValuesList;
    }

    private void handlerDayDataCurve(List<Map<String, String>> returnData, List<Map<String, Object>> listMap, List<Map<String, String>> MonthData) {
        if (listMap.size() > 0) {
            for (Map<String, Object> map : listMap) {
                handleOneHourDataIntoReturnDataCurve(returnData, map, MonthData);
            }
            Map<String, List<String>> itemNameAndValuesList = getitemNameAndValuesList(returnData);
            handleOtherIntoReturnDataCurve(returnData, itemNameAndValuesList);
        }
    }

    private void handleOtherIntoReturnDataCurve(List<Map<String, String>> returnData, Map<String, List<String>> itemNameAndValuesList) {
        Map<String, String> avgMap = new HashMap<>();    //平均值
        for (Map.Entry<String, List<String>> entry : itemNameAndValuesList.entrySet()) {
            String itemName = entry.getKey();
            if ("moniterTime".equals(itemName)) {
                avgMap.put("moniterTime", "平均值");
                returnData.add(avgMap);
            } else if ("累计流量".equals(itemName)) {
                //平均值显示通量的值
                List<String> values = entry.getValue();
                //平均值显示通量的值
                String val = values.get(values.size() - 1).replaceAll("[\\u4e00-\\u9fa5]", "");
                String val1 = values.get(0).replaceAll("[\\u4e00-\\u9fa5]", "");
                String subtract = new BigDecimal(val).subtract(new BigDecimal(val1)).toPlainString();
                avgMap.put(itemName, subtract + "时段累计流量");
            } else {
                List<String> values = entry.getValue();
                //平均值
                String avg = itemAvg(values, itemName);
                avgMap.put(itemName, avg);
            }
        }
    }

    private void handleOneHourDataIntoReturnDataCurve(List<Map<String, String>> returnData, Map<String, Object> map,
                                                      List<Map<String, String>> monthData) {
        List<Map<String, String>> contentLists = JsonUtils.nativeRead(map.get("content").toString(), type);
        Map<String, String> tempMap = new HashMap<>();
        String moniterTime = map.get("moniterTime").toString();
        tempMap.put("moniterTime", moniterTime);
        for (Map<String, String> contentItem : contentLists) {
            String itemName = contentItem.get("itemName");
            String troubleCode = contentItem.get("troubleCode");
            String value = contentItem.get("value");
            value = rds.scale(itemName, value);

            if (value.length() > 0 && (StringUtils.isBlank(troubleCode) || "N".equals(troubleCode) || " N".equals(troubleCode))) {
                tempMap.put(itemName, value);
            }
        }
        returnData.add(tempMap);
        if (monthData != null) {
            monthData.add(tempMap);
        }
        // if (yearData != null) yearData.add(tempMap);
    }

    public Map<String, Object> getRealTimeDataBySiteId(String siteId) {
        List<Map<String, Object>> list = getRealTimeData();
        for (Map<String, Object> l : list) {
            if ((l.get("siteId") + "").equals(siteId)) {
                return l;
            }
        }
        return null;
    }

    public List<Map<String, Object>> trend(String itemName, String trend) {
        if (StringUtils.isNotBlank(itemName) && StringUtils.isNotBlank(trend)) {
            //这里调用只是为了让其有值TREND_MAP
            trend(null, null);
            List<Map<String, Object>> temp = TREND_MAP.get(itemName);
            List<Map<String, Object>> list = new ArrayList<>();
            for (Map<String, Object> map : temp) {
                String trend1 = map.get("trend") + "";
                if (trend1.equals(trend)) {
                    list.add(map);
                }
            }
            return list;
        } else if (StringUtils.isNotBlank(itemName)) {
            //这里调用只是为了让其有值TREND_MAP
            trend(null, null);
            return TREND_MAP.get(itemName);
        } else if (StringUtils.isNotBlank(trend)) {
            //这里调用只是为了让其有值TREND_MAP
            trend(null, null);
            return TREND_MAP.get(trend);
        } else {
            if (System.currentTimeMillis() - TREND_TIME > 5 * 60000) {
                TREND_TIME = System.currentTimeMillis();
            } else {
                String mm = new SimpleDateFormat("mm").format(System.currentTimeMillis());
                int i = Integer.parseInt(mm);
                if (i > 10 && TREND_LIST.size() > 0) {

                    TREND_TIME = System.currentTimeMillis();
                    return TREND_LIST;
                }
            }
            //都为空
            final Integer integer = UserHolder.loginId();// UserHolder.loginId() 放外面是因为需要获取**当前**线程的用户id，如果放到下面的线程里面获取，将为空
            Future<Map<Integer, List<Integer>>> siteItemsFuture = PoolExecutor.submit(new Callable<Map<Integer, List<Integer>>>() {
                @Override
                public Map<Integer, List<Integer>> call() throws Exception {
                    List<Map<String, Integer>> siteItems = simpleHourDataMapper.selectValidSiteIdAndItems(integer);
                    //key 为 站点id，value 为站点对应的监测项目集合
                    Map<Integer, List<Integer>> siteIdanditemIds = new HashMap<>();
                    for (Map<String, Integer> siteItem : siteItems) {
                        Integer siteId = siteItem.get("siteId");
                        siteIdanditemIds.computeIfAbsent(siteId, k -> new ArrayList<>()).add(siteItem.get("itemId"));
                    }
                    return siteIdanditemIds;
                }
            });

            String time = DateFormat.format(yyyy_MM_dd_HH, new Date(System.currentTimeMillis() - 3 * 60 * 60 * 1000)) + ":00:00";
            Future<List<Map<String, Object>>> mapListFuture = PoolExecutor.submit(new Callable<List<Map<String, Object>>>() {
                @Override
                public List<Map<String, Object>> call() throws Exception {
                    return simpleHourDataMapper.selectBySiteIdsLength(time);
                }
            });

            //保存过滤后数据
            List<Map<String, Object>> mapList = new ArrayList<>();

            try {
                //key 为 站点id，value 为站点对应的监测项目集合
                Map<Integer, List<Integer>> siteIdanditemIds = siteItemsFuture.get();
                List<Map<String, Object>> mapListStart = mapListFuture.get();
                Set<String> set = new HashSet<>();
                for (Map<String, Object> map : mapListStart) {
                    int siteId = Integer.parseInt(map.get("siteId") + "");
                    int itemId = Integer.parseInt(map.get("itemId") + "");
                    List<Integer> list = siteIdanditemIds.get(siteId);
                    if (list != null && list.contains(itemId)) {
                        String setStr = siteId + "-" + itemId;
                        if (!set.contains(setStr)) {
                            map.remove("itemId");
                            map.remove("siteId");
                            String value = map.get("value") + "";
                            if (value.length() > 7) {
                                map.put("value", value.substring(0, 7));
                            }
                            mapList.add(map);
                            set.add(setStr);
                        }
                    }
                }

                TREND_LIST = mapList;
                //key 为 itemName或siteName或trend ，  value 为其对应key条件的集合
                Map<String, List<Map<String, Object>>> mapTemp = new HashMap<>();
                for (Map<String, Object> map : mapList) {
                    String itemNameTemp = map.get("itemName") + "";
                    String siteNameTemp = map.get("siteName") + "";
                    String trendTemp = map.get("trend") + "";

                    mapTemp.computeIfAbsent(itemNameTemp, k -> new ArrayList<>()).add(map);
                    mapTemp.computeIfAbsent(siteNameTemp, k -> new ArrayList<>()).add(map);
                    mapTemp.computeIfAbsent(trendTemp, k -> new ArrayList<>()).add(map);
                }
                TREND_MAP = mapTemp;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return mapList;
        }
    }


    private static List<Map<String, Object>> TREND_LIST = new ArrayList<>();
    //key 为 itemName或siteName或trend ，  value 为其对应key条件的集合
    private static Map<String, List<Map<String, Object>>> TREND_MAP = new HashMap<>();
    private static long TREND_TIME = 0;

    //key 为站点名称  value 为对应的每天测试数集合
    private static Map<Integer, Map<String, Integer>> name_number_map = new HashMap<>();
    private static long name_number_map_time = 0;

    private Map<String, Integer> getitemNameAndNumbersMap(Integer siteId) {
        Map<String, Integer> itemNameAndNumbersMap = name_number_map.get(siteId);
        if (itemNameAndNumbersMap == null || System.currentTimeMillis() - name_number_map_time > 30_000) {
            //获取站点siteId对应的有效的监测指标
            List<Map<String, String>> itemNameAndNumbers = baseSiteitemMapper.selectBySiteId(siteId);
            itemNameAndNumbersMap = new HashMap<>();
            for (Map<String, String> en : itemNameAndNumbers) {
                itemNameAndNumbersMap.put(en.get("itemName"), Integer.valueOf((Object) en.get("number") + ""));
            }
            name_number_map.put(siteId, itemNameAndNumbersMap);
            name_number_map_time = System.currentTimeMillis();
        }
        return itemNameAndNumbersMap;
    }

    private Res getHourDataAndDayNum(Integer siteId, String startTime, String endTime) {
        //两个日期天数差
        Date beginDate = DateFormat.parseSome(startTime.split(" ")[0]);
        Date endDate = DateFormat.parseSome(endTime.split(" ")[0]);
        int dayNum = getDaysBetween(beginDate, endDate);

        List<Map<String, Object>> listMap = envHourDataMapper.monitorReportDayGetData(siteId, startTime, endTime);
        if (listMap.size() <= 0) {
            throw new XMException(500, "没有数据");
        }
        return new Res(dayNum, listMap);
    }

    //isDayAvg true 返回日均值 false 返回月均值
    public List<Map<String, String>> seasons(Integer siteId, Integer seasons, Integer year, List<Integer> statistics, Boolean limit, Boolean isDayAvg) {
        String startTime = year + "-";
        String endTime = year + "-";
        switch (seasons) {
            case 1:
                startTime = startTime + "01-01 00:00:00";
                endTime = endTime + "03-31 23:59:59";
                break;
            case 2:
                startTime = startTime + "04-01 00:00:00";
                endTime = endTime + "06-30 23:59:59";
                break;
            case 3:
                startTime = startTime + "07-01 00:00:00";
                endTime = endTime + "09-30 23:59:59";
                break;
            case 4:
                startTime = startTime + "10-01 00:00:00";
                endTime = endTime + "12-31 23:59:59";
                break;
            default:
                throw new XMException(500, "季节选择出错，只可以选择1,2,3,4");
        }

        if (isDayAvg) {
            return month(siteId, startTime, endTime, statistics, limit);
        } else {
            return year(siteId, startTime, endTime, statistics, limit);
        }
    }

    public List<Map<String, String>> waterAnalysis() {
        List<Map<String, String>> list = new ArrayList<>();
        String today = DateFormat.formatSome(System.currentTimeMillis());
        List<BaseSite> baseSiteList = commonService.getBaseSiteList();
        ArrayList<Integer> statistics = new ArrayList<Integer>() {{
            for (int i = 0; i < 11; i++) {
                add(i);
            }
        }};

        for (BaseSite baseSite : baseSiteList) {
            List<Map<String, String>> day = day(baseSite.getId(), today, today, statistics, true);
            if (day.size() > 0) {
                Map<String, String> temp = new LinkedHashMap<>();
                temp.put("siteName", baseSite.getSiteName());
                temp.put("standardLevel", WaterLevelTransformUtil.levelIntToLevelString(Integer.parseInt(baseSite.getLevelStandard())));
                for (int i = day.size() - 12; i < day.size(); i++) {
                    //平均值后面的数据，这里只获取平均数据，所以需要去除
                    Map<String, String> map = day.get(i);
                    String moniterTime = map.get("moniterTime");

                    if ("水质类别".equals(moniterTime)) {
                        map.remove("moniterTime");
                        String next = map.keySet().iterator().next();
                        String level = map.get(next);

                        switch (level) {
                            case "I":
                                temp.put("realLevel", level);
                                temp.put("assess", "优秀");
                                break;
                            case "II":
                                temp.put("realLevel", level);
                                temp.put("assess", "良好");
                                break;
                            case "III":
                                temp.put("realLevel", level);
                                temp.put("assess", "合格");
                                break;
                            case "IV":
                                temp.put("realLevel", level + "$$");
                                temp.put("assess", "稍差$$");
                                break;
                            default:
                                temp.put("realLevel", level + "$$");
                                temp.put("assess", "劣质$$");
                                break;
                        }

                    } else if ("主要污染物".equals(moniterTime)) {
                        map.remove("moniterTime");
                        String next = map.keySet().iterator().next();
                        temp.put("main", map.get(next));
                    } else if ("平均数据捕捉率(%)".equals(moniterTime)) {
                        map.remove("moniterTime");
                        String next = map.keySet().iterator().next();
                        temp.put("rate1", map.get(next));
                    } else if ("平均有效数据获取率(%)".equals(moniterTime)) {
                        map.remove("moniterTime");
                        String next = map.keySet().iterator().next();
                        temp.put("rate2", map.get(next));
                    } else if ("平均故障率(%)".equals(moniterTime)) {
                        map.remove("moniterTime");
                        String next = map.keySet().iterator().next();
                        temp.put("rate3", map.get(next));
                    }
                }
                list.add(temp);
            }
        }
        return list;
    }

    //type 1 日  2 周   3 月  4 年
    public List<Map<String, String>> singleComparison(String startTime, String endTime, Integer type) {
        //用来存储各个站点名称以及其平均值   站点名称  平均值map
        Map<String, Map<String, String>> siteAvgMap = new HashMap<>();
        List<Map<String, Object>> site = baseService.findBaseSiteByAccountId();
        for (Map<String, Object> map : site) {
            Integer siteId = Integer.valueOf(map.get("id") + "");
            String siteName = map.get("siteName") + "";
            List<Map<String, String>> datas = null;
            switch (type) {
                case 1:
                    datas = day(siteId, startTime, endTime, null, true);
                    break;
                case 2:
                    datas = week(siteId, Integer.parseInt(startTime), Integer.parseInt(endTime), null, true);
                    break;
                case 3:
                    datas = month(siteId, startTime, endTime, null, true);
                    break;
                case 4:
                    datas = year(siteId, startTime, endTime, null, true);
                    break;
                default:
                    datas = new ArrayList<>();
            }
            if (datas.size() > 0) {
                Map<String, String> avgMap = datas.get(datas.size() - 1);
                if (avgMap.get("moniterTime").contains("平均值")) {
                    avgMap.remove("moniterTime");
                    siteAvgMap.put(siteName, avgMap);
                }
            }
        }
        //String  itemname 。 String 站点名称，String 监测值
        Map<String, Map<String, String>> returnMap = new HashMap<>();
        for (Map.Entry<String, Map<String, String>> entry : siteAvgMap.entrySet()) {
            String siteName = entry.getKey();
            Map<String, String> avgMap = entry.getValue();
            for (Map.Entry<String, String> stringEntry : avgMap.entrySet()) {
                String itemName = stringEntry.getKey();
                String value = stringEntry.getValue();
                Map<String, String> map = returnMap.computeIfAbsent(itemName, k -> new HashMap<>());
                if (!"".equals(value)) {
                    map.put(siteName, value);
                }
            }
        }
        //改变格式
        List<Map<String, String>> list = new ArrayList<>();
        if (returnMap.size() > 0) {
            for (Map.Entry<String, Map<String, String>> entry : returnMap.entrySet()) {
                String itemName = entry.getKey();
                Map<String, String> siteNameValue = entry.getValue();
                siteNameValue.put("itemName", itemName);
                list.add(siteNameValue);
            }
        }
        return list;
    }

    public List<Map<String, String>> realMonth(Integer siteId, Integer year, Integer month, List<Integer> statistics, Boolean limit) {
        StringBuilder endSb = getStringBuilder(year, month);

        String end = endSb.append(" 23:59:59").toString();
        String start = endSb.replace(8, 19, "01 00:00:00").toString();

        return month(siteId, start, end, statistics, limit);
    }

    public List<Map<String, String>> realYear(Integer siteId, Integer year, List<Integer> statistics, Boolean limit) {
        return year(siteId, year + "-01-01 00:00:00", year + "-12-31 23:59:59", statistics, limit);
    }

    public List<Map<String, String>> realDay(Integer siteId, String day, List<Integer> statistics, Boolean limit) {
        return day(siteId, day + " 00:00:00", day + " 23:59:59", statistics, limit);
    }

    //水质专题
    public Object tmowq(Integer siteId, String day, String yearMonth) {
        ArrayList<Integer> statistics = new ArrayList<>();
        statistics.add(2);  //分项水质类别
        statistics.add(3);  //总水质类别
        statistics.add(6); //平均捕捉率
        statistics.add(8);  //平均有效率
        List<Map<String, String>> mapList;
        if (StringUtils.isNotBlank(day)) {
            mapList = realDay(siteId, day, statistics, false);
        } else if (StringUtils.isNotBlank(yearMonth)) {
            String[] split = yearMonth.split("-");
            mapList = realMonth(siteId, Integer.parseInt(split[0]), Integer.parseInt(split[1]), statistics, false);
        } else {
            throw new XMException(500, "参数传递有误，不能为空");
        }
        int size = mapList.size();
        Map<String, String> map1 = mapList.get(size - 1); //平均有效率
        String next1 = map1.values().iterator().next();
        Map<String, String> map2 = mapList.get(size - 2); //平均捕捉率
        String next2 = map2.values().iterator().next();
        Map<String, String> map3 = mapList.get(size - 3); //总水质类别
        String next3 = map3.values().iterator().next();
        Map<String, String> map4 = mapList.get(size - 4); //分项水质类别
        Map<String, Integer> map4_1 = new HashMap<>();
        Map<String, String> map4_2 = new HashMap<>();
        for (Map.Entry<String, String> entry : map4.entrySet()) {
            String value = entry.getValue();
            if (value.equals("") || value.equals("分项类别")) {
                continue;
            }
            map4_1.merge(value, 1, Integer::sum);
            map4_2.put(entry.getKey(), value);
        }

        List<HashMap<String, Object>> list4 = map4_1.entrySet().stream().map(ee -> {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("value", ee.getValue());
            hashMap.put("name", ee.getKey());
            return hashMap;
        }).collect(Collectors.toList());


        List<Map<String, Object>> res = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        Map<String, Object> m2 = new HashMap<>();
        Map<String, Object> m3 = new HashMap<>();
        Map<String, Object> m4 = new HashMap<>();
        Map<String, Object> m5 = new HashMap<>();
        Map<String, Object> m6 = new HashMap<>();

        if (StringUtils.isNotBlank(day)) {

            List<NetWork> netWorks = netWorkService.findNetWorks(null, day, day, siteId + "");
            if (netWorks.size() > 0) {
                NetWork netWork = netWorks.get(0);
                Integer onLine = netWork.getOnLine();
                double v = onLine / 1440d;
                String string = new BigDecimal(v * 100).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
                m1.put("系统在线率", string);
            } else {
                m1.put("系统在线率", "0");
            }
        } else if (StringUtils.isNotBlank(yearMonth)) {
            String[] split = yearMonth.split("-");
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);

            StringBuilder endSb = getStringBuilder(year, month);

            List<NetWork> netWorks = netWorkService.findNetWorks(null, yearMonth + "-01", endSb.toString(), siteId + "");
            if (netWorks.size() > 0) {
                double all = 0;
                for (NetWork netWork : netWorks) {
                    all += netWork.getOnLine();
                }

                double v = all / netWorks.size() / 1440;
                String string = new BigDecimal(v * 100).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
                m1.put("系统在线率", string);
            }
        }
        m3.put("水质因子评价", map4_2);
        m2.put("水质类别评价", list4);
        m4.put("数据捕捉率", next2);
        m5.put("数据有效率", next1);
        m6.put("总水质类别", next3);

        res.add(m1);
        res.add(m2);
        res.add(m3);
        res.add(m4);
        res.add(m5);
        res.add(m6);

        return res;
    }

    private static StringBuilder getStringBuilder(int year, int month) {
        StringBuilder endSb = new StringBuilder().append(year).append("-");
        if (month == 2) {
            //二月有閏年29 非閏年28，四年一闰，百年不闰，四百年再闰
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                //1、闰年29
                endSb.append(0).append(month).append("-29");
            } else {
                //2、不是闰年
                endSb.append(0).append(month).append("-28");
            }
        } else if (month == 4 || month == 6 || month == 9) {
            endSb.append(0).append(month).append("-30");
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8) {
            endSb.append(0).append(month).append("-31");
        } else if (month == 11) {
            endSb.append(month).append("-30");
        } else if (month == 10 || month == 12) {
            endSb.append(month).append("-31");
        }
        return endSb;
    }

    private class Res {
        public Integer dayNum;
        public List<Map<String, Object>> listMap;

        public Res(Integer dayNum, List<Map<String, Object>> listMap) {
            this.dayNum = dayNum;
            this.listMap = listMap;
        }
    }

    //statistics集合 0最小值，1最大值，2分项类别,3水质类别,4主要污染物,5代表数据捕捉率，6平均数据捕捉率,7有效数据获取率,8平均有效数据获取率,9单项故障率,10平均故障率 参数传递格式为1,2,3,4
    public List<Map<String, String>> day(Integer siteId, String startTime, String endTime, List<Integer> statistics, Boolean limit) {
        ReportThreadLocal.setTL("day", 0, limit);
        if (startTime.length() == 10) {
            startTime += " 00:00:00";
        }
        if (endTime.length() == 10) {
            endTime += " 23:59:59";
        }
        String s = startTime.split(" ")[1];
        if (s.equals("00:00:00")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                startTime = simpleDateFormat.format(simpleDateFormat.parse(startTime).getTime() - 10000);
                s = startTime.split(" ")[1];
            } catch (ParseException e) {
                throw new XMException(500, "com.xmmems.service.MonitorService 1067行，日期格式化出错");
            }
        }
        String sH = s.substring(0, 2);
        String eH = endTime.split(" ")[1].substring(0, 2); //用来去除还超过时间的测试次数  如一天测试6次，那么如果只是到13点，实际只测试了3次，那么捕捉率 应该为3除以3 100%

        List<Map<String, String>> returnData = new ArrayList<>();
        Res res = getHourDataAndDayNum(siteId, startTime, endTime);
        int dayNum = res.dayNum;
        //获取站点siteId对应的有效的监测指标
        Map<String, Integer> itemNameAndNumbersMap = getitemNameAndNumbersMap(siteId);
        handlerDayDataList(siteId, returnData, dayNum, itemNameAndNumbersMap, res.listMap, null, null, statistics, eH, sH);
        return returnData;
    }

    private void handlerDayDataList(Integer siteId, List<Map<String, String>> returnData, int dayNum, Map<String, Integer> itemNameAndNumbersMap,
                                    List<Map<String, Object>> listMap, List<Map<String, String>> MonthData, List<Map<String, String>> yearData,
                                    List<Integer> statistics, String eH, String sH) {
        if (listMap.size() > 0) {

            //获取所有检出限
            Map<String, String> limitMap = getLimitMap(siteId);
            for (Map<String, Object> map : listMap) {
                handleOneHourDataIntoReturnData(returnData, map, itemNameAndNumbersMap, MonthData, yearData, limitMap);
            }
            Map<String, List<String>> itemNameAndValuesList = getitemNameAndValuesList(returnData);
            boolean isAvg = MonthData != null;
            handleOtherIntoReturnData(returnData, itemNameAndValuesList, siteId, dayNum, itemNameAndNumbersMap, isAvg, statistics, "dd", itemNameAndValuesList, eH, sH);
        }
    }

    //获取所有检出限
    private Map<String, String> getLimitMap(Integer siteId) {
        if (ReportThreadLocal.getLimit()) {
            Map<String, String> limitMap = new HashMap<>();
            List<Map<String, String>> limit = baseSiteitemMapper.getDetectionLimit(siteId);
            if (limit.size() > 0) {
                limit.forEach(temp -> limitMap.put(temp.get("itemId"), temp.get("limitNum")));
            }
            return limitMap;
        }
        return null;
    }

    /**
     * 处理统计数据
     *
     * @param returnData            存储最终数据的字段
     * @param itemNameAndValuesList 存储指标名与其对应数据聚合的字段
     * @param siteId                站点id
     * @param dayNum                相差天数  1号-1号等于1天
     * @param itemNameAndNumbersMap 存储指标名与其对应的一天应册多少次
     * @param isAvg                 是否只处理平均值
     */
    private void handleOtherIntoReturnData(List<Map<String, String>> returnData, Map<String, List<String>> itemNameAndValuesList,
                                           Integer siteId, int dayNum, Map<String, Integer> itemNameAndNumbersMap, boolean isAvg,
                                           List<Integer> statistics, String flag, Map<String, List<String>> itemNameAndNumbersMapOfDay,
                                           String eH, String sH) {
        Map<String, String> minMap = new HashMap<>();    //最小值
        Map<String, String> maxMap = new HashMap<>();    //最大值
        Map<String, String> avgMap = new HashMap<>();    //平均值
        Map<String, String> subCategoryMap = new HashMap<>();    //分项类别
        Map<String, String> waterQualityCategoryMap = new HashMap<>();    //水质类别
        Map<String, String> mainPollutantsMap = new HashMap<>();    //主要污染物
        Map<String, String> sinIntegrityMap = new HashMap<>();    //数据捕捉率
        Map<String, String> avgIntegrityMap = new HashMap<>();    //平均数据捕捉率
        Map<String, String> sinEfficiencyMap = new HashMap<>();    //有效数据获取率
        Map<String, String> avgEfficiencyMap = new HashMap<>();    //平均有效数据获取率
        Map<String, String> sinFailureMap = new HashMap<>();    //单项故障率
        Map<String, String> avgFailureMap = new HashMap<>();    //平均故障率

        List<BaseSiteitemDTO> list = getColumns(siteId);
        List<String> itemNames = list.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());

        for (Map.Entry<String, List<String>> entry : itemNameAndValuesList.entrySet()) {
            String itemName = entry.getKey();

            if ("moniterTime".equals(itemName)) {
                avgMap.put("moniterTime", "平均值");
                returnData.add(avgMap);
                if (!isAvg) {
                    minMap.put("moniterTime", "最小值");
                    maxMap.put("moniterTime", "最大值");
                    subCategoryMap.put("moniterTime", "分项类别");
                    waterQualityCategoryMap.put("moniterTime", "水质类别");
                    mainPollutantsMap.put("moniterTime", "主要污染物");
                    sinIntegrityMap.put("moniterTime", "数据捕捉率(%)");
                    avgIntegrityMap.put("moniterTime", "平均数据捕捉率(%)");
                    sinEfficiencyMap.put("moniterTime", "有效数据获取率(%)");
                    avgEfficiencyMap.put("moniterTime", "平均有效数据获取率(%)");
                    sinFailureMap.put("moniterTime", "单项故障率(%)");
                    avgFailureMap.put("moniterTime", "平均故障率(%)");

                    if (statistics != null) {

                        if (statistics.contains(0)) {
                            returnData.add(minMap);
                        }
                        if (statistics.contains(1)) {
                            returnData.add(maxMap);
                        }
                        if (statistics.contains(2)) {
                            returnData.add(subCategoryMap);
                        }
                        if (statistics.contains(3)) {
                            returnData.add(waterQualityCategoryMap);
                        }
                        if (statistics.contains(4)) {
                            returnData.add(mainPollutantsMap);
                        }
                        if (statistics.contains(5)) {
                            returnData.add(sinIntegrityMap);
                        }
                        if (statistics.contains(6)) {
                            returnData.add(avgIntegrityMap);
                        }
                        if (statistics.contains(7)) {
                            returnData.add(sinEfficiencyMap);
                        }
                        if (statistics.contains(8)) {
                            returnData.add(avgEfficiencyMap);
                        }
                        if (statistics.contains(9)) {
                            returnData.add(sinFailureMap);
                        }
                        if (statistics.contains(10)) {
                            returnData.add(avgFailureMap);
                        }
                    }

                }

            } else {

                if (itemNames.contains(itemName)) {

                    if (itemNameAndNumbersMap.get(itemName) != null) {

                        List<String> values = entry.getValue();
                        String avg = "0";
                        //累计流量 的平均值显示通量
                        if ("累计流量".equals(itemName)) {
                            //平均值显示通量的值
                            String regex = "[^\\d]+"; //匹配非数字0至n个
                            if (flag.contains("dd")) {
                                String val = values.get(values.size() - 1).replaceAll(regex, "");
                                String val1 = values.get(0).replaceAll(regex, "");
                                avg = new BigDecimal(val).subtract(new BigDecimal(val1)).toPlainString();
                                avgMap.put(itemName, avg + "时段累计流量");
                            } else if (flag.contains("MM") || flag.contains("yy")) {
                                List<String> temp = itemNameAndNumbersMapOfDay.get("累计流量");
                                String val = temp.get(temp.size() - 1).replaceAll(regex, "");
                                String val1 = temp.get(0).replaceAll(regex, "");
                                avg = new BigDecimal(val).subtract(new BigDecimal(val1)).toPlainString();
                                avgMap.put(itemName, avg + "时段累计流量");
                            }

                        } else {
                            //平均值
                            avg = itemAvg(values, itemName);
                            avgMap.put(itemName, avg);
                        }
                        if (!isAvg) {

                            //最小值
                            String min = itemMin(values);
                            //最大值
                            String max = itemMax(values);
                            //分项类别
                            String subCategory = itemSubCategory(itemName, avg, siteId);
                            //数据捕捉率
                            //完整测 总次数
                            double all = 1000000;

                            String type = ReportThreadLocal.getType();
                            switch (type) {
                                case "day":
                                    Integer allnum = itemNameAndNumbersMap.get(itemName);
                                    if (allnum == null) {
                                        throw new XMException(500, itemName + "的一天监测次数没有设置");
                                    }
                                    int h = 24 / allnum;  //时间间隔  24/6=4
                                    int sh = Integer.parseInt(sH);
                                    int eh = Integer.parseInt(eH);

                                    //开始时间  11点 ，那么实际测试的有 12  16  20  3次  ,11/4+1=3  6-3=3
                                    int si = allnum - (sh / h + 1);
                                    int ei = eh / h + 1;  // 结束时间 13 点  那么实际测试的有 0  4   8   12   4次  ，13/4+1=4
                                    //完整测 总次数
                                    all = si + ei + (dayNum - 2) * allnum;  //同一天 11-13  最终1次 12点数据 ，si=6-(11/4+1)=3,ei=13/4+1=4,all=3+4+(1-2)*6=1
                                    break;
                                case "month":
                                case "year":
                                case "week":
                                    all = ReportThreadLocal.getAll();
                                    break;
                            }

                            String sinIntegrity = itemSinIntegrity(values, all);
                            //有效数据获取率
                            String sinEfficiency = itemSinEfficiency(values);
                            //单项故障率
                            String sinFailure = itemSinFailure(sinEfficiency);

                            minMap.put(itemName, min);
                            maxMap.put(itemName, max);
                            //列包括才添加进分项类别
                            subCategoryMap.put(itemName, subCategory);
                            sinIntegrityMap.put(itemName, sinIntegrity);
                            sinEfficiencyMap.put(itemName, sinEfficiency);
                            sinFailureMap.put(itemName, sinFailure);

                        }
                    }
                }
            }
        }

        if (!isAvg) {

            //水质类别
            String waterQualityCategory = itemWaterQualityCategory(siteId, subCategoryMap);
            //主要污染物
            String mainPollutants = itemMainPollutants(subCategoryMap, siteId);
            //平均数据捕捉率
            //String avgIntegrity = itemAvgEfficiency(sinEfficiencyMap, itemNames);
            String avgIntegrity = itemAvgIntegrity(sinIntegrityMap);
            //平均有效数据获取率
            String avgEfficiency = itemAvgEfficiency(sinEfficiencyMap);
            //平均故障率
            String avgFailure = itemavgFailure(avgEfficiency);

            for (String key : itemNameAndValuesList.keySet()) {
                if ("moniterTime".equals(key)) {
                    continue;
                }
                waterQualityCategoryMap.put(key, waterQualityCategory);
                mainPollutantsMap.put(key, mainPollutants);
                avgIntegrityMap.put(key, avgIntegrity);
                avgEfficiencyMap.put(key, avgEfficiency);
                avgFailureMap.put(key, avgFailure);

            }
        }
    }

    private static String itemavgFailure(String avgEfficiency) {
        double d = 100d - Double.valueOf(avgEfficiency);
        return scale(d, 2);
    }

    private static String itemSinFailure(String sinEfficiency) {
        double d = 100d - Double.valueOf(sinEfficiency);
        return scale(d, 2);
    }

    /**
     * @param sinEfficiencyMap 所有数据
     *                         有效项目名（用来去除无效列对比用）
     * @return
     */
    private static String itemAvgEfficiency(Map<String, String> sinEfficiencyMap) {
        List<String> values = new ArrayList<>();  //只保留有效项目名的值
        Set<String> keys = sinEfficiencyMap.keySet();
        for (String key : keys) {
            if (!"moniterTime".equals(key)) {
                values.add(sinEfficiencyMap.get(key));
            }
        }

        double d = 0d;
        for (String value : values) {
            d += Double.parseDouble(value);
        }
        d = d / (values.size());
        return scale(d, 2);
    }

    private static String itemSinEfficiency(List<String> values) {
        //有效值个数
        double num = 0;
        for (String value : values) {
            if (!value.contains("$$") || value.contains("＜")) {
                num++;
            }
        }
        //总个数
        int all = values.size();
        double v = num / all * 100;
        return scale(v, 2);
    }

    private static String itemAvgIntegrity(Map<String, String> sinIntegrityMap) {
        List<String> values = new ArrayList<>();  //只保留有效项目名的值
        Set<String> keys = sinIntegrityMap.keySet();
        for (String key : keys) {
            if (!"moniterTime".equals(key)) {

                values.add(sinIntegrityMap.get(key));
            }
        }

        double d = 0d;
        for (String value : values) {
            d += Double.parseDouble(value);
        }
        d = d / (values.size());
        return scale(d, 2);
    }

    //type 数据的类型
    private static String itemSinIntegrity(List<String> values, double all) {

        //实际次数
        int realnum = (int) values.stream().filter(v -> !v.trim().equals("")).count();
        //int realnum = values.size();
        double rate = realnum / all * 100;
        if (rate > 100) {
            rate = 100;
        }

        return scale(rate, 2);
    }

    private String itemMainPollutants(Map<String, String> subCategoryMap, Integer siteId) {
        Integer standard = getSlevel(siteId + "");

        int max = -1;
        for (String level : subCategoryMap.values()) {
            int of = level.indexOf("$$");
            if (level.length() > 3 && of != -1) {
                level = level.substring(0, of);
            }
            int i = WaterLevelTransformUtil.levelStringToLevelInt(level);
            max = max > i ? max : i;
        }

        StringBuilder main = new StringBuilder();
        if (max > standard) {

            for (Map.Entry<String, String> entry : subCategoryMap.entrySet()) {
                String itemName = entry.getKey();
                String level = entry.getValue();

                int of = level.indexOf("$$");
                if (level.length() > 3 && of != -1) {
                    level = level.substring(0, of);
                }
                int i = WaterLevelTransformUtil.levelStringToLevelInt(level);

                if (i == max) {
                    if (!"".equals(main.toString())) {
                        main.append(",");
                    }
                    main.append(itemName);
                }
            }
        }
        return main.toString();
    }

    //获取标准水质
    public Integer getSlevel(String key) {
        Map<String, BaseSite> allSiteMap = commonService.getAllSiteMap();
        BaseSite site = allSiteMap.get(key);
        if (site == null) {
            return 3;
        }

        String levelStandard = site.getLevelStandard();
        //获取标准水质
        return levelStandard == null ? 3 : Integer.parseInt(levelStandard);
    }

    public String itemWaterQualityCategory(Integer siteId, Map<String, String> subCategoryMap) {
        Future<Integer> submit = PoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return getSlevel(siteId + "");
            }
        });


        int max = -1;
        for (String level : subCategoryMap.values()) {
            int of = level.indexOf("$$");
            if (of != -1) {
                level = level.substring(0, of);
            }
            int i = WaterLevelTransformUtil.levelStringToLevelInt(level);
            max = max > i ? max : i;
        }


        //从分项水质类别中取出最大的级别
        String maxLevel = WaterLevelTransformUtil.levelIntToLevelString(max);
        Integer standard = 3;
        try {
            standard = submit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (max > standard) {
            //比标准水质大，就是有问题的水质，需要加$$标识
            return maxLevel + "$$";
        } else {
            //正常水质级别
            return maxLevel;
        }
    }

    public String itemSubCategory(String itemName, String avg, Integer siteId) {

        EnvQualityConf envQualityConf = waterQualityCategory(itemName, avg);
        if (envQualityConf != null) {
            Integer standard = getSlevel(siteId + "");
            String level = envQualityConf.getLevel();
            if (WaterLevelTransformUtil.levelStringToLevelInt(level) > standard) {
                return level + "$$";
            } else {
                return level;
            }
        }
        return "";
    }

    public EnvQualityConf waterQualityCategory(@NonNull String itemName, @NonNull String avg) {

        //方法3 查到一个质量类别直接进行比较，比方法为减少循环次数
        if (avg != null && !"".equals(avg)) {
            for (EnvQualityConf envQualityConf : commonService.getEnvQualityConfList()) {
                String kpiName = envQualityConf.getKpiName();
                if (itemName.equals(kpiName)) {
                    if (Double.parseDouble(envQualityConf.getMinVal()) <= Double.parseDouble(avg) && Double.parseDouble(envQualityConf.getMaxVal()) >= Double.parseDouble(avg)) {
                        return envQualityConf;
                    }
                }
            }
        }
        return null;
    }

    private String itemAvg(List<String> values, String itemName) {
        double d = 0d;
        int num = 0;
        for (String value : values) {
            try {
                if (!value.contains("$$") && !"".equals(value)) {
                    double aLong = Double.parseDouble(value);
                    d += aLong;
                    num++;
                }
            } catch (NumberFormatException e) {
                //log.error("数字转换错误1406行代码");
            }
        }

        if (num == 0) return "";
        double v = d / num;
        return rds.scale(itemName, v + "");

    }

    private static String itemMax(List<String> values) {
        Double d = null;
        for (String value : values) {
            try {
                if (!value.contains("$$")) {
                    value = value.replaceAll("[\\u4e00-\\u9fa5]", "");
                    Double aLong = Double.valueOf(value);
                    if (d == null || aLong > d) {
                        d = aLong;
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        try {
            return new BigDecimal(d + "").toPlainString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String itemMin(List<String> values) {

        Double d = null;
        for (String value : values) {
            try {
                if (!value.contains("$$")) {
                    value = value.replaceAll("[\\u4e00-\\u9fa5]", "");
                    Double aLong = Double.valueOf(value);
                    if (d == null || aLong < d) {
                        d = aLong;
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        try {
            return new BigDecimal(d + "").toPlainString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 银行家算法
     *
     * @param value 原始值
     * @param digit 保留小数位
     * @return 保留后的值
     */
    public static String scale(@NonNull Object value, @NonNull Integer digit) {
        try {
            return new BigDecimal(value + "").setScale(digit, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
        } catch (NumberFormatException e) {
            System.out.println("数据解析异常1605--->" + value);
            return "";
        }
    }

    public void handleOneHourDataIntoReturnData(List<Map<String, String>> returnData, Map<String, Object> map, Map<String, Integer> itemNameAndNumbersMap,
                                                List<Map<String, String>> MonthData, List<Map<String, String>> yearData, Map<String, String> limit) {
        List<Map<String, String>> contentLists = JsonUtils.nativeRead(map.get("content").toString(), type);
        Map<String, String> tempMap = new HashMap<>();
        String moniterTime = map.get("moniterTime").toString();
        tempMap.put("moniterTime", moniterTime);
        for (Map<String, String> contentItem : contentLists) {
            String itemName = contentItem.get("itemName");
            if (itemNameAndNumbersMap.get(itemName) != null) {

                String troubleCode = contentItem.get("troubleCode");
                String value = contentItem.get("value").replace(",", "").trim();
                String itemId = contentItem.get("itemId");


                if (value.length() > 0) {
                    String scale = rds.scale(itemName, value);
                    if (StringUtils.isNotBlank(troubleCode) && !"N".equals(troubleCode) && !" N".equals(troubleCode)) {
                        value = scale + "$$" + troubleCode;

                    } else if (ReportThreadLocal.getLimit()) {
                        //检出限
                        String b = limit.get(itemId.replace(".0", ""));
                        if (b != null && Double.parseDouble(value) < Double.parseDouble(b)) {
                            value = "$$＜" + b;
                        }
                    }
                    if (value.contains("$$")) {

                        tempMap.put(itemName, value);
                    } else {
                        tempMap.put(itemName, scale);
                    }
                }

            }
        }
        returnData.add(tempMap);
        if (MonthData != null) MonthData.add(tempMap);
        if (yearData != null) yearData.add(tempMap);
    }

    public List<Map<String, Object>> initData(Integer siteId, String startTime, String endTime) {
        Res res = getHourDataAndDayNum(siteId, startTime, endTime);
        List<Map<String, Object>> list = res.listMap;
        if (list.size() > 0) {
            for (Map<String, Object> hourData : list) {
                List<Map<String, String>> monitorItemList = JsonUtils.nativeRead(hourData.get("content").toString(), type);
                hourData.remove("content");
                for (Map<String, String> monitorItem : monitorItemList) {
                    String value = rds.formatValue(monitorItem.get("itemName"), monitorItem.get("value"));
                    hourData.put(monitorItem.get("itemName"), value);
                }
            }
        }
        return list;
    }

    //一个月的水质统计
    public Map<String, Object> monthQuality(Integer siteId, Integer year, Integer month, Boolean isPercent) {
        //返回子集1---水质分类
        List<String> types = new ArrayList<>();
        //返回子集2---日期
        //List<String> dates = new ArrayList<String>();
        //返回子集3---数据
        List<Map<String, String>> datas = new ArrayList<>();

        //数据处理主过程
        List<Map<String, String>> monthList = realMonth(siteId, year, month, null, false);
        //去掉平均值一项数据
        monthList.remove(monthList.size() - 1);
        //标准水质
        Integer standard = getSlevel(siteId + "");
        //质量类别转换为键值对形式
        Map<String, List<EnvQualityConf>> eqMap = new HashMap<>();
        for (EnvQualityConf envQualityConf : commonService.getEnvQualityConfList()) {
            String kpiName = envQualityConf.getKpiName();
            eqMap.computeIfAbsent(kpiName, k -> new ArrayList<>()).add(envQualityConf);
        }

        List<Future<Boolean>> tt = new ArrayList<>();
        for (Map<String, String> dayList : monthList) {
            Future<Boolean> submit = PoolExecutor.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    //等级统计
                    Map<String, String> tempMap = new LinkedHashMap<>();
                    tempMap.put("D", "0");
                    tempMap.put("N", "0");
                    tempMap.put("UN", "0");

                    for (Map.Entry<String, String> entry : dayList.entrySet()) {

                        String key = entry.getKey();
                        String value = entry.getValue();

                        if ("moniterTime".equals(key)) {
                            //value是日期
                            //dates.add(value);
                            tempMap.put("time", value);
                        } else {
                            //key是监测指标名称，value是值，level是等级，这里只查询
                            String level = "";
                            if (value != null && !"".equals(value)) {
                                List<EnvQualityConf> envQualityConfs = eqMap.get(key);
                                if (envQualityConfs != null) {

                                    for (EnvQualityConf temp : envQualityConfs) {
                                        if (Double.parseDouble(temp.getMinVal()) <= Double.parseDouble(value) && Double.parseDouble(temp.getMaxVal()) >= Double.parseDouble(value)) {
                                            level = temp.getLevel();
                                            if (WaterLevelTransformUtil.levelStringToLevelInt(level) > standard) {
                                                level = level + "$$";
                                            }
                                            break;
                                        }
                                    }
                                }
                            }

                            if (level.contains("$")) {
                                tempMap.put("UN", Integer.parseInt(tempMap.get("UN")) + 1 + "");
                            } else if (level.equals("")) {
                                tempMap.put("D", Integer.parseInt(tempMap.get("D")) + 1 + "");
                            } else {
                                tempMap.put("N", Integer.parseInt(tempMap.get("N")) + 1 + "");
                            }
                        }
                    }

                    if (isPercent) {
                        int id = Integer.parseInt(tempMap.get("D"));
                        int in = Integer.parseInt(tempMap.get("N"));
                        int iun = Integer.parseInt(tempMap.get("UN"));
                        double sum = in + iun + id;
                        String d = scale(id * 100 / sum, 2);
                        String n = scale(in * 100 / sum, 2);
                        String un = scale(iun * 100 / sum, 2);
                        tempMap.put("D", d);
                        tempMap.put("N", n);
                        tempMap.put("UN", un);
                    }

                    datas.add(tempMap);
                    return true;
                }
            });
            tt.add(submit);
        }
        Map<String, Object> map = new LinkedHashMap<>();//返回对象
        //将三个子集添加进去返回对象中
        map.put("types", types);
        //map.put("dates", dates);
        map.put("datas", datas);

        types.add("不统计项");
        types.add("标准");
        types.add("未达标");
        //等待多线程执行完毕
        for (Future<Boolean> future : tt) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        sortByTime(datas);
       /* dates.sort((o1, o2) -> {
            long t1 = DateFormat.parseSome(o1).getTime();
            long t2 = DateFormat.parseSome(o2).getTime();

            return (int) (t1 - t2);
        });*/
        return map;
    }

    public Map<String, Object> monthOnline(Integer siteId, Integer year, Integer month, Boolean isPercent) {
        //返回子集1---联网分类
        List<String> types = new ArrayList<>();
        //返回子集2---日期
        //List<String> dates = new ArrayList<String>();
        //返回子集3---数据
        List<Map<String, String>> datas = new ArrayList<>();

        //将月份转换为开始时间与结束时间
        StringBuilder endSb = getStringBuilder(year, month);
        String end = endSb.toString();
        String start = endSb.replace(8, 10, "01").toString();

        //查询数据
        List<NetWork> netWorks = netWorkService.findNetWorksBySiteId(start, end, siteId);

        List<Future<Boolean>> tt = new ArrayList<>();
        //分日处理数据
        for (NetWork netWork : netWorks) {
            Future<Boolean> submit = PoolExecutor.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    Integer onLine = netWork.getOnLine();
                    //一天24小时 乘以 60 分钟每小时 = 1440分钟
                    if (onLine >= 1435) {
                        //大于1435就算是整天在线了
                        onLine = 1440;
                    } else if (onLine <= 5) {
                        onLine = 0;
                    }
                    //其他状态都是离线状态，用一天总分钟数减去在线时间
                    int offLine = 1440 - onLine;
                    String date = DateFormat.formatSome(netWork.getDate());
                    //dates.add(date);

                    Map<String, String> tempMap = new LinkedHashMap<>();
                    tempMap.put("on", onLine + "");
                    tempMap.put("off", offLine + "");
                    tempMap.put("time", date);

                    if (isPercent) {
                        int in = Integer.parseInt(tempMap.get("on"));
                        int iun = Integer.parseInt(tempMap.get("off"));
                        double sum = in + iun;
                        String n = scale(in * 100 / sum, 2);
                        String un = scale(100 - Double.parseDouble(n), 2);
                        tempMap.put("on", n);
                        tempMap.put("off", un);
                    }

                    datas.add(tempMap);
                    return true;
                }
            });
            tt.add(submit);
        }

        Map<String, Object> map = new LinkedHashMap<>();//返回对象
        //将三个子集添加进去返回对象中
        map.put("types", types);
        //map.put("dates", dates);
        map.put("datas", datas);

        types.add("在线");
        types.add("离线");
        //等待多线程执行完毕
        for (Future<Boolean> future : tt) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        sortByTime(datas);
        /*dates.sort((o1, o2) -> {
            long t1 = DateFormat.parseSome(o1).getTime();
            long t2 = DateFormat.parseSome(o2).getTime();

            return (int) (t1 - t2);
        });*/
        //datas.forEach(d->d.remove("time"));
        //System.out.println(map);
        return map;
    }

    public Map<String, Object> monthEfficiency(Integer siteId, Integer year, Integer month, Boolean isPercent) {
        //返回子集1---有效无效分类分类
        List<String> types = new ArrayList<>();
        //返回子集2---日期
        //List<String> dates = new ArrayList<String>();
        //返回子集3---数据
        List<Map<String, String>> datas = new ArrayList<>();

        //数据处理主过程
        List<Map<String, String>> monthList = realMonth(siteId, year, month, null, false);
        //去掉平均值一项数据
        monthList.remove(monthList.size() - 1);
        //标准水质
        Integer standard = getSlevel(siteId + "");
        //质量类别转换为键值对形式
        Map<String, List<EnvQualityConf>> eqMap = new HashMap<>();
        for (EnvQualityConf envQualityConf : commonService.getEnvQualityConfList()) {
            String kpiName = envQualityConf.getKpiName();
            eqMap.computeIfAbsent(kpiName, k -> new ArrayList<>()).add(envQualityConf);
        }

        List<Future<Boolean>> tt = new ArrayList<>();
        for (Map<String, String> dayList : monthList) {
            Future<Boolean> submit = PoolExecutor.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    //等级统计
                    Map<String, String> tempMap = new LinkedHashMap<>();
                    tempMap.put("N", "0");
                    tempMap.put("UN", "0");

                    for (Map.Entry<String, String> entry : dayList.entrySet()) {

                        String key = entry.getKey();
                        String value = entry.getValue();

                        if ("moniterTime".equals(key)) {
                            //value是日期
                            //dates.add(value);
                            tempMap.put("time", value);
                        } else {
                            //key是监测指标名称，value是值，level是等级，这里只查询
                            String level = "";
                            if (value != null && !"".equals(value)) {
                                List<EnvQualityConf> envQualityConfs = eqMap.get(key);
                                if (envQualityConfs != null) {

                                    for (EnvQualityConf temp : envQualityConfs) {
                                        if (Double.parseDouble(temp.getMinVal()) <= Double.parseDouble(value) && Double.parseDouble(temp.getMaxVal()) >= Double.parseDouble(value)) {
                                            level = temp.getLevel();
                                            if (WaterLevelTransformUtil.levelStringToLevelInt(level) > standard) {
                                                level = level + "$$";
                                            }
                                            break;
                                        }
                                    }
                                }
                            }

                            if (level.contains("$")) {
                                tempMap.put("UN", Integer.parseInt(tempMap.get("UN")) + 1 + "");
                            } else {
                                tempMap.put("N", Integer.parseInt(tempMap.get("N")) + 1 + "");
                            }
                        }
                    }

                    if (isPercent) {
                        int in = Integer.parseInt(tempMap.get("N"));
                        int iun = Integer.parseInt(tempMap.get("UN"));
                        double sum = in + iun;
                        String n = scale(in * 100 / sum, 2);
                        String un = scale(100 - Double.parseDouble(n), 2);
                        tempMap.put("N", n);
                        tempMap.put("UN", un);
                    }
                    datas.add(tempMap);
                    return true;
                }
            });
            tt.add(submit);
        }
        Map<String, Object> map = new LinkedHashMap<>();//返回对象
        //将三个子集添加进去返回对象中
        map.put("types", types);
        //map.put("dates", dates);
        map.put("datas", datas);

        types.add("有效");
        types.add("无效");
        //等待多线程执行完毕
        for (Future<Boolean> future : tt) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        sortByTime(datas);
       /* dates.sort((o1, o2) -> {
            long t1 = DateFormat.parseSome(o1).getTime();
            long t2 = DateFormat.parseSome(o2).getTime();

            return (int) (t1 - t2);
        });*/
        return map;
    }

    public Map<String, Object> monthCaptureRate(Integer siteId, Integer year, Integer month, Boolean isPercent) {
        //返回子集1---有效无效分类分类
        List<String> types = new ArrayList<>();
        //返回子集3---数据
        List<Map<String, String>> datas = new ArrayList<>();

        List<Integer> statistics = new ArrayList<>();
        statistics.add(6);//平均捕捉率
        //获取月份最后一天
        StringBuilder endSb = getStringBuilder(year, month);
        String endYearMonth = endSb.substring(0, 8); //2020-08-
        int endDay = Integer.parseInt(endSb.substring(8, 10));  //01
        for (int i = 1; i <= endDay; i++) {
            String day = (i < 10 ? ("0" + i) : i + "");

            day = endYearMonth + day;
            List<Map<String, String>> dayList = realDay(siteId, day, statistics, false);
            if (dayList.size() > 0) {

                Map<String, String> tempMap = new LinkedHashMap<>();
                Map<String, String> map = dayList.get(dayList.size() - 1);
                map.remove("moniterTime");
                String next = map.values().iterator().next();

                tempMap.put("N", next);
                tempMap.put("UN", scale(100d - Double.parseDouble(next), 2));
                tempMap.put("time", day);

                datas.add(tempMap);
            }
        }
        types.add("捕捉率");
        types.add("其它");
        Map<String, Object> map = new LinkedHashMap<>();//返回对象
        //将三个子集添加进去返回对象中
        map.put("types", types);
        map.put("datas", datas);

        return map;
    }

    //月饼图专用排序方法，按照日期升序
    private static void sortByTime(List<Map<String, String>> datas) {
        datas.sort((o1, o2) -> {
            String time1 = o1.get("time");
            String time2 = o2.get("time");
            long t1 = DateFormat.parseSome(time1).getTime();
            long t2 = DateFormat.parseSome(time2).getTime();

            return (int) (t1 - t2);
        });
    }
}
