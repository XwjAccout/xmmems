package com.xmmems.analyze.service;

import com.xmmems.common.utils.DateFormat;
import com.xmmems.mapper.SimpleHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @描述 通量分析
 * @创建人 ithxw
 * @创建时间 2020.09.22 13:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FluxService {
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    /**
     * 通量分析
     *
     * @param siteId
     * @param itemId
     * @param start
     * @param end
     * @param type   1001，最低单位计算（分钟）；1002，小时；1003，日；1004，月；1005；年；1006，周  ；1007，季度
     *               2001，最低单位计算（分钟）；2002，小时；2003，日；2004，月；2005；年；2006，周  ；2007，季度
     * @return 当type=100*，返回K线图需要的格式，当type=200*，返回表格需要的格式
     */
    public Object fluxKdiagram(Integer siteId, Integer itemId, String start, String end, Integer type) {
        List<Map<String, String>> totalFlow = simpleHourDataMapper.selectValue(siteId, 34, start, end);
        Map<String, String> flowMap = new HashMap<>(16);
        if (totalFlow.size() > 0) {

            //按天分组
            Map<String, List<Double>> totalFlowGroupByDay = new LinkedHashMap<>();

            for (Map<String, String> map : totalFlow) {
                String timeStr = getHandlerTimeStr(type, map);
                double value = new BigDecimal(map.get("value")).doubleValue();
                //获取这个小时的值
                List<Double> ds = totalFlowGroupByDay.computeIfAbsent(timeStr, k -> new ArrayList<>());
                ds.add(value);
            }

            for (Map.Entry<String, List<Double>> entry : totalFlowGroupByDay.entrySet()) {
                String key = entry.getKey();
                List<Double> value = entry.getValue();
                double flow = value.get(value.size() - 1) - value.get(0);
                //流量=最后累计流量减去最初累计流量
                flowMap.put(key, new BigDecimal(flow + "").toPlainString());
            }
        }

        List<Map<String, String>> list = simpleHourDataMapper.selectValue(siteId, itemId, start, end);
        if (list.size() <= 0) {
            return null;
        }

        //按天分组
        Map<String, List<Double>> mapGroupByDay = new LinkedHashMap<>();

        for (Map<String, String> map : list) {
            String timeStr = getHandlerTimeStr(type, map);
            double value = new BigDecimal(map.get("value")).doubleValue();
            //获取这个小时的值
            List<Double> ds = mapGroupByDay.computeIfAbsent(timeStr, k -> new ArrayList<>());
            ds.add(value);
        }

        //封装值 1，最大值，2最小值，平均值，初始值，结束值
        //100*需要临时引用的集合
        List<List<Object>> finalListdatas = new ArrayList<>();
        //100*需要临时引用的集合
        List<String> finalListTimes = new ArrayList<>();
        //100*需要临时引用的集合
        List<Object> finalListFlows = new ArrayList<>();
        //100*需要临时引用的最终返回数据集合
        Map<String, Object> finalMap = new HashMap<>(16);
        // 200*需要临时引用的最终返回数据集合
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Map.Entry<String, List<Double>> entry : mapGroupByDay.entrySet()) {
            String key = entry.getKey();
            List<Double> v = entry.getValue();
            double sum = 0;
            Double init = v.get(0);
            Double last = v.get(v.size() - 1);
            Double min = init, max = init;

            for (int i = 0; i < v.size(); i++) {
                Double d = v.get(i);
                sum += d;
                if (d > max) {
                    max = d;
                }
                if (d < min) {
                    min = d;
                }
            }

            String flowStr = flowMap.get(key);
            if (type == 1001 || type == 1002 || type == 1003 || type == 1004 || type == 1005 || type == 1006 || type == 1007) {

                List<Object> temp = new ArrayList<>();
                temp.add(init);
                temp.add(last);
                temp.add(min);
                temp.add(max);
                temp.add(flowStr);
                finalListdatas.add(temp);
                finalListTimes.add(key);
                finalListFlows.add(flowStr);
            } else {

                String avg = new BigDecimal(sum / v.size()).setScale(6, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("时间", key);
                map.put("最大", max);
                map.put("最小", min);
                map.put("开始", init);
                map.put("结束", last);
                map.put("平均", avg);
                map.put("流量", flowStr);
                mapList.add(map);
            }

        }
        finalMap.put("data", finalListdatas);
        finalMap.put("datas", finalListTimes);
        finalMap.put("volumes", finalListFlows);
        if (type == 1001 || type == 1002 || type == 1003 || type == 1004 || type == 1005 || type == 1006 || type == 1007) {

            return finalMap;
        } else {
            return mapList;
        }
    }

    private static String getHandlerTimeStr(Integer type, Map<String, String> map) {
        String timeStr = "";
        switch (type) {
            case 1002:
            case 2002:
                timeStr = map.get("timeStr").substring(0, 10);
                //获取日期，精确到日
                break;
            case 1003:
            case 2003:
                timeStr = map.get("timeStr").substring(0, 7);
                //获取时间，精确到月
                break;
            case 1004:
            case 2004:
                timeStr = map.get("timeStr").substring(0, 4);
                //获取时间，精确到年
                break;
            case 1006:
            case 2006:
                timeStr = currentWeek(map.get("timeStr"));
                //获取时间，精确到周
                break;
            //获取时间，精确到季度
            case 1007:
            case 2007:
                String year = map.get("timeStr").substring(0, 4);
                String month = map.get("timeStr").substring(5, 7);
                switch (month) {
                    case "01":
                    case "02":
                    case "03":
                        timeStr = year + "年第1季度";
                        //获取时间，精确到季度
                        break;
                    case "04":
                    case "05":
                    case "06":
                        timeStr = year + "年第2季度";
                        break;
                    case "07":
                    case "08":
                    case "09":
                        timeStr = year + "年第3季度";
                        break;
                    case "10":
                    case "11":
                    case "12":
                        timeStr = year + "年第4季度";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return timeStr;
    }


    private static String currentWeek(String dateStr) {

        Date date = DateFormat.parseSome(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //设置星期一为每周第一天
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        //获得第几周
        int year = calendar.get(Calendar.YEAR);
        //获取年份
        if (week == 1) {
            String substring = dateStr.substring(5, 7);
            if ("12".equals(substring)) {
                year++;
            }

        }
        calendar.setWeekDate(year, week, Calendar.MONDAY);
        //获得指定年的第几周的开始日期
        Date monday = calendar.getTime();
        //创建日期的时间该周的第一天，
        calendar.setWeekDate(year, week, Calendar.SUNDAY);
        //获得指定年的第几周的结束日期
        Date sunday = calendar.getTime();
        String s = DateFormat.formatSome(monday);
        String e = DateFormat.formatSome(sunday);

        return year + "年第" + week + "周("+s+"~"+e+")";

    }
}
