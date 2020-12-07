package com.xmmems.service.quality;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.BeanHelper;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.domain.*;
import com.xmmems.dto.Specific;
import com.xmmems.dto.ZeroSpan;
import com.xmmems.mapper.InspectDataMapper;
import com.xmmems.mapper.TreeDataMapper;
import com.xmmems.mapper.ZeroCheckHandledMapper;
import com.xmmems.mapper.ZeroCheckMapper;
import com.xmmems.service.ReportConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class TestDataService {
    @Autowired
    private TreeDataMapper treeDataMapper;
    @Autowired
    private ZeroCheckHandledMapper zeroCheckHandledMapper;
    @Autowired
    private InspectDataMapper inspectDataMapper;
    @Autowired
    private ZeroCheckMapper zeroCheckMapper;

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public List<TreeData> getTreeData() {
        Gson gson = new Gson();
        List<TreeData> list = treeDataMapper.getTreeData();
        list.forEach(tem -> {

            Map<String, Object> o = gson.fromJson(tem.getAttributes(), new TypeToken<Map<String, String>>() {
            }.getType());
            tem.setAttributeMap(o);
            //设置为空字符串，减少传递数据，加快网络传递速度
            tem.setAttributes("");
        });
        return list;
    }

    //查询零点核查数据1
    public List<Map<String, Object>> zeroData(String start, String end, Integer siteId) {
        List<ZeroCheck> list = zeroCheckMapper.selectZeroData(start, end, siteId, 1);
        Map<String, ZeroSpan> zeroSpanMap = new LinkedHashMap<>();
        Map<String, List<ZeroCheck>> zeroSpanMap1 = new LinkedHashMap<>();
        for (ZeroCheck zeroCheck : list) {
            List<ZeroCheck> zeroChecks = zeroSpanMap1.computeIfAbsent(zeroCheck.getItemName(), k -> new ArrayList<>());
            zeroChecks.add(zeroCheck);
        }
        String last = "0";
        //按照时间分组,存入zeroSpans
        for (List<ZeroCheck> zeroCheck : zeroSpanMap1.values()) {
            for (int count = 0; count < zeroCheck.size(); count++) {
                ZeroCheck temp = zeroCheck.get(count);
                String key = DateFormat.format(DateFormat.yyyy_MM_dd_HH, temp.getGenTime());
                ZeroSpan zeroSpan = zeroSpanMap.get(key);
                if (zeroSpan == null) {
                    zeroSpan = new ZeroSpan();
                    zeroSpan.setSiteId(temp.getSiteId());
                    zeroSpan.setSiteName(temp.getSiteName());
                    zeroSpan.setGenTime(temp.getGenTime());
                    zeroSpan.setReceiveId(temp.getType());
                    zeroSpanMap.put(key, zeroSpan);
                }
                Specific specific = new Specific();
                if (zeroCheck.size() == count + 1) {
                    last = zeroSpanMap1.get(temp.getItemName()).get(count).getCheck();
                } else {
                    last = zeroSpanMap1.get(temp.getItemName()).get(count + 1).getCheck();
                }
                specific.setLastResult(last);
                double absoluteStr = 0;
                double relativeStr = 0;
                if (!temp.getCheck().equals("0.0")) {
                    //计算绝对误差  绝对误差=测试结果-标液浓度(取绝对值）
                    absoluteStr = Double.parseDouble(temp.getCheck()) - Double.parseDouble(temp.getConcentration());
                    //计算相对误差  相对误差=（测试结果-前一次测量结果）*100/跨度值
                    relativeStr = (Double.parseDouble(temp.getCheck()) - Double.parseDouble(specific.getLastResult())) * 100 / Double.parseDouble(temp.getSpanvalues());
                }
                String relative = null;
                String absolute = null;
                switch (temp.getItemName()) {
                    case "高锰酸盐指数":
                        relative = setScale(relativeStr, 2);
                        absolute = setScale(absoluteStr, 2);
                        specific.setLastResult(setScale(last, 2));
                        specific.setNowResult(setScale(temp.getCheck(), 2));
                        break;
                    case "总磷":
                        relative = setScale(relativeStr, 3);
                        absolute = setScale(absoluteStr, 3);
                        specific.setLastResult(setScale(last, 3));
                        specific.setNowResult(setScale(temp.getCheck(), 3));
                        break;
                    case "总氮":
                        relative = setScale(relativeStr, 2);
                        absolute = setScale(absoluteStr, 2);
                        specific.setLastResult(setScale(last, 2));
                        specific.setNowResult(setScale(temp.getCheck(), 2));
                        break;
                    default:
                        relative = setScale(relativeStr, 2);
                        absolute = setScale(absoluteStr, 2);
                        specific.setLastResult(setScale(last, 2));
                        specific.setNowResult(setScale(temp.getCheck(), 2));
                        break;
                }

                specific.setAbsoluteError(absolute);
                specific.setRelativeError(relative + "%");
                //是否合格
                Map<String, String> map1 = isQualified1(temp.getItemName(), absoluteStr);
                for (String key1 : map1.keySet()) {
                    specific.setQualified1(key1);
                    String value = map1.get(key1);
                    specific.setTitle1(value);
                }
                //是否合格
                Map<String, String> map2 = isQualified2(temp.getItemName(), relativeStr);
                for (String key2 : map2.keySet()) {
                    specific.setQualified2(key2);
                    String value = map2.get(key2);
                    specific.setTitle2(value);
                }

                specific.setSolution(temp.getConcentration());
                specific.setRangev(temp.getSpanvalues());
                specific.setItemName(temp.getItemName());
                specific.setItemId(temp.getItemId());
                specific.setUnit(temp.getUnit());

                zeroSpan.addSpecific(specific);
            }
        }
        Collection<ZeroSpan> values = zeroSpanMap.values();
        List<ZeroCheckHandled> zeroCheckHandleds = new ArrayList<>();
        values.forEach(value -> {
            zeroCheckHandleds.add(BeanHelper.copyProperties(value, ZeroCheckHandled.class));
        });
        return getMaps(zeroCheckHandleds);
    }

    private static String setScale(double absoluteStr, int i) {
        return new BigDecimal(absoluteStr).setScale(i, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
    }

    private static String setScale(String absoluteStr, int i) {
        return new BigDecimal(absoluteStr).setScale(i, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
    }

    //查询跨度核查数据
    public List<Map<String, Object>> spanData(String start, String end, Integer siteId) {
        List<ZeroCheck> list = zeroCheckMapper.selectZeroData(start, end, siteId, 2);
        Map<String, ZeroSpan> zeroSpanMap = new LinkedHashMap<>();
        Map<String, List<ZeroCheck>> zeroSpanMap1 = new LinkedHashMap<>();
        for (ZeroCheck zeroCheck : list) {
            List<ZeroCheck> zeroChecks = zeroSpanMap1.computeIfAbsent(zeroCheck.getItemName(), k -> new ArrayList<>());
            zeroChecks.add(zeroCheck);
        }
        String last = "0.0";
        //按照时间分组,存入zeroSpans
        for (List<ZeroCheck> zeroCheck : zeroSpanMap1.values()) {
            for (int count = 0; count < zeroCheck.size(); count++) {
                ZeroCheck temp = zeroCheck.get(count);
                String key = DateFormat.format(DateFormat.yyyy_MM_dd_HH, temp.getGenTime());
                ZeroSpan zeroSpan = zeroSpanMap.get(key);
                if (zeroSpan == null) {
                    zeroSpan = new ZeroSpan();
                    zeroSpan.setSiteId(temp.getSiteId());
                    zeroSpan.setSiteName(temp.getSiteName());
                    zeroSpan.setGenTime(temp.getGenTime());
                    zeroSpan.setReceiveId(temp.getType());
                    zeroSpanMap.put(key, zeroSpan);
                }
                Specific specific = new Specific();
                if (zeroCheck.size() == count + 1) {
                    last = zeroSpanMap1.get(temp.getItemName()).get(count).getCheck();
                } else {
                    last = zeroSpanMap1.get(temp.getItemName()).get(count + 1).getCheck();
                }

                specific.setLastResult(last);
                double absoluteStr = 0.0;
                double relativeStr = 0.0;
                if (!temp.getCheck().equals("0.0")) {
                    //计算相对误差  （测试结果-标液浓度）/标液浓度
                    absoluteStr = (Double.parseDouble(temp.getCheck()) - Double.parseDouble(temp.getConcentration())) * 100 / Double.parseDouble(temp.getConcentration());
                    //计算相对误差  相对误差=（测试结果-前一次测量结果）/跨度值
                    relativeStr = (Double.parseDouble(temp.getCheck()) - Double.parseDouble(specific.getLastResult())) * 100 / Double.parseDouble(temp.getSpanvalues());
                }
                String relative = null;
                String absolute = null;
                switch (temp.getItemName()) {
                    case "高锰酸盐指数":
                        relative = setScale(relativeStr, 2);
                        absolute = setScale(absoluteStr, 2);
                        specific.setLastResult(setScale(last, 2));
                        specific.setNowResult(setScale(temp.getCheck(), 2));
                        break;
                    case "总磷":
                        relative = setScale(relativeStr, 3);
                        absolute = setScale(absoluteStr, 3);
                        specific.setLastResult(setScale(last, 3));
                        specific.setNowResult(setScale(temp.getCheck(), 3));
                        break;
                    case "总氮":
                        relative = setScale(relativeStr, 2);
                        absolute = setScale(absoluteStr, 2);
                        specific.setLastResult(setScale(last, 2));
                        specific.setNowResult(setScale(temp.getCheck(), 2));
                        break;
                    default:
                        relative = setScale(relativeStr, 2);
                        absolute = setScale(absoluteStr, 2);
                        specific.setLastResult(setScale(last, 2));
                        specific.setNowResult(setScale(temp.getCheck(), 2));
                        break;
                }


                specific.setAbsoluteError(absolute);
                specific.setRelativeError(relative);
                //是否合格
                Map<String, String> map1 = isQualifiedscope(relativeStr, absoluteStr);
                for (String key1 : map1.keySet()) {
                    specific.setQualified1(key1);
                    String value = map1.get(key1);
                    specific.setTitle1(value);
                }
                //是否合格
                Map<String, String> map2 = isQualifiedscope(relativeStr, absoluteStr);
                for (String key2 : map2.keySet()) {
                    specific.setQualified2(key2);
                    String value = map2.get(key2);
                    specific.setTitle2(value);
                }
                specific.setSolution(temp.getConcentration());
                specific.setRangev(temp.getSpanvalues());
                specific.setItemName(temp.getItemName());
                specific.setItemId(temp.getItemId());
                specific.setUnit(temp.getUnit());
                zeroSpan.addSpecific(specific);
            }
        }

        Collection<ZeroSpan> values = zeroSpanMap.values();

        List<ZeroCheckHandled> zeroCheckHandleds = new ArrayList<>();
        values.forEach(value -> {
            zeroCheckHandleds.add(BeanHelper.copyProperties(value, ZeroCheckHandled.class));
        });

        return getMaps(zeroCheckHandleds);
    }

    /**
     * 转换content为json，日期格式化
     *
     * @param list
     * @param s
     */
    private void convert(List<Map<String, Object>> list, String s) {
        Map<String, Object> map = JsonUtils.toMap(s, String.class, Object.class);
        map.put("content", JsonUtils.toBean((String) map.get("content"), List.class));
        map.put("genTime", sdf.format(new Date((Long) map.get("genTime"))));
        list.add(map);
    }

    public List<Map<String, Object>> recoveryData(String start, String end, Integer siteId) {

        ZeroCheckHandledExample example = new ZeroCheckHandledExample();
        example.setOrderByClause("genTime desc");
        ZeroCheckHandledExample.Criteria criteria = example.createCriteria();
        try {
            criteria.andGenTimeGreaterThanOrEqualTo(sdf.parse(start));
            criteria.andGenTimeLessThanOrEqualTo(sdf.parse(end));
        } catch (ParseException e) {
            throw new XMException(500, "日期解析错误");
        }
        criteria.andSiteIdEqualTo(siteId);
        criteria.andReceiveIdEqualTo(3);
        List<ZeroCheckHandled> zeroCheckHandleds = zeroCheckHandledMapper.selectByExampleWithBLOBs(example);
        return getMaps(zeroCheckHandleds);
    }

    private <T> List<Map<String, Object>> getMaps(List<T> handleds) {
        List<Map<String, Object>> list = new ArrayList<>();
        handleds.forEach(handled -> {
            convert(list, JsonUtils.toString(handled));
        });
        return list;
    }

    public List<InspectData> inspectData(String start, String end, Integer siteId) {

        InspectDataExample example = new InspectDataExample();
        InspectDataExample.Criteria criteria = example.createCriteria();
        try {
            criteria.andGenTimeGreaterThanOrEqualTo(sdf.parse(start));
            criteria.andGenTimeLessThanOrEqualTo(sdf.parse(end));
        } catch (ParseException e) {
            throw new XMException(500, "日期解析错误");
        }
        criteria.andSiteIdEqualTo(siteId);
        return inspectDataMapper.selectByExample(example);
    }


    public Map<String, Object> standardVerification(String start, String end, Integer siteId, Integer itemId) {
        //start = DateFormat.formatSome(DateFormat.parseSome(start).getTime() - 86400000);
        end = DateFormat.formatSome(DateFormat.parseSome(end).getTime() + 86400000);

        List<Map<String, String>> res1 = new ArrayList<>();
        List<Map<String, Object>> res2 = new ArrayList<>();
        Map<String, Object> res3 = new LinkedHashMap<>();
        List<Map<String, String>> list = zeroCheckMapper.selectStandardVerification(start, end, siteId, itemId);
        if (list.size() > 0) {
            int num5 = 0, num10 = 0, num15 = 0, num20 = 0, num = 0;
            BigDecimal bigDecimal5 = new BigDecimal("5");
            BigDecimal bigDecimal10 = new BigDecimal("10");
            BigDecimal bigDecimal15 = new BigDecimal("15");
            BigDecimal bigDecimal20 = new BigDecimal("20");

            BigDecimal hundred = new BigDecimal("100");//用来得到百分比用的
            Map<String, String> spanCheckCompare = ReportConfig.getSpanCheckCompare();  //跨度核查误差比较值集合
            Map<String, String> spanDriftCompare = ReportConfig.getSpanDriftCompare();  //跨度漂移误差比较值集合
            for (Map<String, String> contentItem : list) {
                //1、下面是跨度核查的主体数据
                String rangev = contentItem.get("spanvalues");//跨度值
                String nowResult = contentItem.get("checkdata");//测量结果
                String solution = contentItem.get("concentration");//标液浓度
                if (solution.equals("0.0")) {
                    continue;
                }
                //String unit = "mg/L";//单位,高锰酸盐指数，氨氮，总氮，总磷均是

                BigDecimal nowResultDecimal = new BigDecimal(nowResult);
                BigDecimal solutionDecimal = new BigDecimal(solution);
                //跨度核查相对误差：（测试结果-标液浓度）/ 标液浓度
                String percent = (nowResultDecimal.subtract(solutionDecimal)).multiply(hundred).divide(solutionDecimal, 2, BigDecimal.ROUND_HALF_EVEN).toPlainString();//跨度核查相对误差

                String itemName = contentItem.get("itemName");

                Map<String, String> temp = new HashMap<>();
                temp.put("genTime", contentItem.get("genTime"));
                temp.put("itemName", itemName);
                temp.put("solution", solution);
                temp.put("original", nowResult);
                temp.put("unit", "mg/L");
                temp.put("rangev", rangev);
                String compare = spanCheckCompare.get(itemName);//比较值

                BigDecimal percentDecimal = new BigDecimal(percent.replace("-", ""));//取得绝对值

                if (percentDecimal.compareTo(new BigDecimal(compare)) > 0) {
                    temp.put("nowResult", scale(itemName,nowResultDecimal) + "$$");
                    temp.put("percent", percent + "$$");
                    temp.put("qualified", "不合格$$");
                } else {
                    temp.put("nowResult", scale(itemName,nowResultDecimal));
                    temp.put("percent", percent);
                    temp.put("qualified", "合格");
                }

                res1.add(temp);

                //2、下面计算误差范围的比重  步骤1 统计个数
                if (percentDecimal.compareTo(bigDecimal5) <= 0) {
                    num5++;
                } else if (percentDecimal.compareTo(bigDecimal5) > 0 && percentDecimal.compareTo(bigDecimal10) <= 0) {
                    num10++;
                } else if (percentDecimal.compareTo(bigDecimal10) > 0 && percentDecimal.compareTo(bigDecimal15) <= 0) {
                    num15++;
                } else if (percentDecimal.compareTo(bigDecimal15) > 0 && percentDecimal.compareTo(bigDecimal20) <= 0) {
                    num20++;
                } else {
                    num++;
                }
            }
            //计算24小时跨度漂移相对误差
            //公式：（测试结果-前一次）/跨度值  ，因此两两对比，下面循环次数需要减去1
            for (int i = 0; i < res1.size(); i++) {
                //跨度漂移百分比
                Map<String, String> map = res1.get(i);
                if (i == res1.size() - 1) {
                    map.put("drift", "");
                    map.put("qualifieddDrift", "");
                } else {

                    String spanDrift = (new BigDecimal(map.get("original")).subtract(new BigDecimal(res1.get(i + 1).get("original")))).multiply(hundred).divide(new BigDecimal(map.get("rangev")), 2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
                    String itemName = map.get("itemName");
                    String compare = spanDriftCompare.get(itemName);
                    if (new BigDecimal(spanDrift.replace("-", "")).compareTo(new BigDecimal(compare)) > 0) {
                        map.put("drift", spanDrift + "$$");
                        map.put("qualifieddDrift", "不合格$$");
                    } else {
                        map.put("drift", spanDrift);
                        map.put("qualifieddDrift", "合格");
                    }
                }

            }


            //2、下面计算误差范围的比重  步骤2 统计比重
            //总项次
            double all = res1.size() + 0d;
            String s5 = new BigDecimal((num5 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s10 = new BigDecimal((num10 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s15 = new BigDecimal((num15 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s20 = new BigDecimal((num20 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s = new BigDecimal((num * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();

            Map<String, Object> m5 = getStringObjectMap(num5, s5, "±5%");
            Map<String, Object> m10 = getStringObjectMap(num10, s10, "±10%");
            Map<String, Object> m15 = getStringObjectMap(num15, s15, "±15%");
            Map<String, Object> m20 = getStringObjectMap(num20, s20, "±20%");
            Map<String, Object> m = getStringObjectMap(num, s, "其它");

            res2.add(m5);
            res2.add(m10);
            res2.add(m15);
            res2.add(m20);
            res2.add(m);

            //3、下面计算合格率
            //合格项次
            int numqu = num5 + num10 + num15;
            res3.put("allqualified", (int) all);
            res3.put("qualified", numqu);
            res3.put("notqualified", num20 + num);
            res3.put("qualifiedRate", new BigDecimal((numqu * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString() + "%");
        }

        Map<String, Object> res = new HashMap<>();
        res.put("res1", res1);
        res.put("res2", res2);
        res.put("res3", res3);
        return res;
    }

    private Map<String, Object> getStringObjectMap(int num, String proportion, String range) {
        Map<String, Object> m10 = new HashMap<>();
        m10.put("range", range);
        m10.put("num", num);
        m10.put("proportion", proportion);
        return m10;
    }

    //绝对合格判断
    private static Map<String, String> isQualified1(String itemName, double absolute) {
        if (itemName != null) {
            String qualified = null;
            String title = null;
            if ("高锰酸盐指数".equals(itemName) && Math.abs(absolute) <= 1) {
                qualified = "合格";
                title = "合格范围：≤±1";
            } else if ("总磷".equals(itemName) && Math.abs(absolute) <= 0.025) {
                qualified = "合格";
                title = "合格范围：≤±0.025";
            } else if ("氨氮".equals(itemName) && Math.abs(absolute) <= 0.05) {
                qualified = "合格";
                title = "合格范围：≤±0.05";
            } else if ("总氮".equals(itemName) && Math.abs(absolute) <= 0.2) {
                qualified = "合格";
                title = "合格范围：≤±0.2";
            } else {
                qualified = "不合格";
                title = "合格范围：≤±0.1";
            }
            Map<String, String> map = new HashMap<>();
            map.put(qualified, title);
            return map;
        }
        return null;
    }

    //相对合格判断
    private static Map<String, String> isQualified2(String itemName, double relative) {
        if (itemName == null) {
            return null;
        } else {
            String qualified = null;
            String title = null;
            if ("高锰酸盐指数".equals(itemName) && Math.abs(relative) <= 5) {
                qualified = "合格";
                title = "合格范围：≤±5%";
            } else if ("总磷".equals(itemName) && Math.abs(relative) <= 5) {
                qualified = "合格";
                title = "合格范围：≤±5%";
            } else if ("总氮".equals(itemName) && Math.abs(relative) <= 5) {
                qualified = "合格";
                title = "合格范围：≤±5%";
            } else if ("氨氮".equals(itemName) && Math.abs(relative) <= 5) {
                qualified = "合格";
                title = "合格范围：≤±5%";
            } else if ("溶解氧".equals(itemName) && Math.abs(relative) <= 0.3) {
                qualified = "合格";
                title = "合格范围：≤±0.3%";
            } else if ("电导率".equals(itemName) && Math.abs(relative) <= 1) {
                qualified = "合格";
                title = "合格范围：≤±1%";
            } else if ("浊度".equals(itemName) && Math.abs(relative) <= 3) {
                qualified = "合格";
                title = "合格范围：≤±3%";
            } else if ("总有机碳".equals(itemName) && Math.abs(relative) <= 5) {
                qualified = "合格";
                title = "合格范围：≤±5%";
            } else if ("生化需氧量".equals(itemName) && Math.abs(relative) <= 5) {
                qualified = "合格";
                title = "合格范围：≤±5%";
            } else {
                qualified = "不合格";
                title = "合格范围：≤±1%";
            }
            Map<String, String> map = new HashMap<>();
            map.put(qualified, title);
            return map;
        }
    }

    private static Map<String, String> isQualifiedscope(double relativeStr, double absolute) {

        String qualified = null;
        String title = null;
        if (Math.abs(absolute) <= 10 || Math.abs(relativeStr) <= 10) {
            qualified = "合格";
            title = "合格范围：≤±10%";
        } else {
            qualified = "不合格";
            title = "合格范围：≤±10%";
        }
        Map<String, String> map = new HashMap<>();
        map.put(qualified, title);
        return map;

    }

    public Map<String, Object> blankTest(String start, String end, Integer siteId, Integer itemId) {
        end = DateFormat.formatSome(DateFormat.parseSome(end).getTime() + 86400000);

        List<Map<String, String>> res1 = new ArrayList<>();
        List<Map<String, Object>> res2 = new ArrayList<>();
        Map<String, Object> res3 = new LinkedHashMap<>();
        List<Map<String, String>> list = zeroCheckMapper.blankTest(start, end, siteId, itemId);
        if (list.size() > 0) {
            int num5 = 0, num10 = 0, num15 = 0, num20 = 0, num = 0;
            BigDecimal bigDecimal5 = new BigDecimal("5");
            BigDecimal bigDecimal10 = new BigDecimal("10");
            BigDecimal bigDecimal15 = new BigDecimal("15");
            BigDecimal bigDecimal20 = new BigDecimal("20");

            BigDecimal hundred = new BigDecimal("100");//用来得到百分比用的
            Map<String, String> spanCheckCompare = ReportConfig.getZeroCheckCompare();  //空白核查误差比较值集合
            Map<String, String> spanDriftCompare = ReportConfig.getZeroDriftCompare();  //空白漂移误差比较值集合
            for (Map<String, String> contentItem : list) {
                //1、下面是跨度核查的主体数据
                String rangev = contentItem.get("spanvalues");//跨度值
                String nowResult = contentItem.get("checkdata");//测量结果
                String solution = contentItem.get("concentration");//标液浓度
                /*if (solution.equals("0.0")) {
                    continue;
                }*/
                //String unit = "mg/L";//单位,高锰酸盐指数，氨氮，总氮，总磷均是

                BigDecimal nowResultDecimal = new BigDecimal(nowResult);
                BigDecimal solutionDecimal = new BigDecimal(solution);
                String itemName = contentItem.get("itemName");
                //零点核查绝对误差 ：测试结果-标液浓度（取绝对值）
                String percent = scale(itemName,nowResultDecimal.subtract(solutionDecimal));

                Map<String, String> temp = new HashMap<>();
                temp.put("genTime", contentItem.get("genTime"));
                temp.put("itemName", itemName);
                temp.put("solution", solution);
                temp.put("original", nowResult);
                temp.put("unit", "mg/L");
                temp.put("rangev", rangev);
                String compare = spanCheckCompare.get(itemName);//比较值

                BigDecimal percentDecimal = new BigDecimal(percent.replace("-", ""));//取得绝对值

                if (percentDecimal.compareTo(new BigDecimal(compare)) > 0) {
                    temp.put("nowResult", scale(itemName,nowResultDecimal) + "$$");
                    temp.put("percent", percent + "$$");
                    temp.put("qualified", "不合格$$");
                } else {
                    temp.put("nowResult", scale(itemName,nowResultDecimal));
                    temp.put("percent", percent);
                    temp.put("qualified", "合格");
                }

                res1.add(temp);

                //2、下面计算误差范围的比重  步骤1 统计个数
                if (percentDecimal.compareTo(bigDecimal5) <= 0) {
                    num5++;
                } else if (percentDecimal.compareTo(bigDecimal5) > 0 && percentDecimal.compareTo(bigDecimal10) <= 0) {
                    num10++;
                } else if (percentDecimal.compareTo(bigDecimal10) > 0 && percentDecimal.compareTo(bigDecimal15) <= 0) {
                    num15++;
                } else if (percentDecimal.compareTo(bigDecimal15) > 0 && percentDecimal.compareTo(bigDecimal20) <= 0) {
                    num20++;
                } else {
                    num++;
                }
            }
            //计算24小时零点漂移相对误差 ：
            //公式：（测试结果-前一次）/跨度值  ，因此两两对比，下面循环次数需要减去1
            for (int i = 0; i < res1.size(); i++) {
                //跨度漂移百分比
                Map<String, String> map = res1.get(i);
                if (i == res1.size() - 1) {
                    map.put("drift", "");
                    map.put("qualifieddDrift", "");
                } else {

                    String spanDrift = (new BigDecimal(map.get("original")).subtract(new BigDecimal(res1.get(i + 1).get("original")))).multiply(hundred).divide(new BigDecimal(map.get("rangev")), 2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
                    String itemName = map.get("itemName");
                    String compare = spanDriftCompare.get(itemName);
                    if (new BigDecimal(spanDrift.replace("-", "")).compareTo(new BigDecimal(compare)) > 0) {
                        map.put("drift", spanDrift + "$$");
                        map.put("qualifieddDrift", "不合格$$");
                    } else {
                        map.put("drift", spanDrift);
                        map.put("qualifieddDrift", "合格");
                    }
                }

            }


            //2、下面计算误差范围的比重  步骤2 统计比重
            //总项次
            double all = res1.size() + 0d;
            String s5 = new BigDecimal((num5 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s10 = new BigDecimal((num10 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s15 = new BigDecimal((num15 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s20 = new BigDecimal((num20 * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            String s = new BigDecimal((num * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();

            Map<String, Object> m5 = getStringObjectMap(num5, s5, "±5%");
            Map<String, Object> m10 = getStringObjectMap(num10, s10, "±10%");
            Map<String, Object> m15 = getStringObjectMap(num15, s15, "±15%");
            Map<String, Object> m20 = getStringObjectMap(num20, s20, "±20%");
            Map<String, Object> m = getStringObjectMap(num, s, "其它");

            res2.add(m5);
            res2.add(m10);
            res2.add(m15);
            res2.add(m20);
            res2.add(m);

            //3、下面计算合格率
            //合格项次
            int numqu = num5 + num10 + num15;
            res3.put("allqualified", (int) all);
            res3.put("qualified", numqu);
            res3.put("notqualified", num20 + num);
            res3.put("qualifiedRate", new BigDecimal((numqu * 100 / all) + "").setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString() + "%");
        }

        Map<String, Object> res = new HashMap<>();
        res.put("res1", res1);
        res.put("res2", res2);
        res.put("res3", res3);
        return res;
    }

    public List<Map<String, Object>> site() {
        return zeroCheckMapper.site();
    }

    private static String scale(String itemName, BigDecimal bd) {
        switch (itemName) {
            case "总磷":
                return bd.setScale(3, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
            case "高锰酸盐指数":
            case "总氮":
            case "氨氮":
                return bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
            default:
                return bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
        }
    }
}
