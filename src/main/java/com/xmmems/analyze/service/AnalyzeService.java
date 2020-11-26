package com.xmmems.analyze.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.analyze.domain.Item;
import com.xmmems.analyze.domain.Kmeans;
import com.xmmems.analyze.dto.ClusterHourDto;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.dto.BaseSiteDTO;
import com.xmmems.mapper.BaseSiteMapper;
import com.xmmems.mapper.EnvHourDataMapper;
import com.xmmems.mapper.SimpleHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @描述 聚类分析
 * @创建人 ithxw
 * @创建时间 2020.07.16 11:49
 */
@Service
@Transactional
public class AnalyzeService {

    @Autowired
    private EnvHourDataMapper hourMapper;

    @Autowired
    private BaseSiteMapper baseSiteMapper;

    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    //主成分分析（PCA）是多元统计分析中用来分析数据的一种方法，PCA通过线性变换将原始数据变换为一组各维度线性无关的表示，
    // 可用于提取数据的主要特征分量，常用于##高维数据的降维##。

    public Map<String, List<Object>> clusterGroupBySite(Integer year, List<Integer> itemIds) {
        List<BaseSiteDTO> sites = baseSiteMapper.getSites(UserHolder.loginId());
        String start = year + "-01-01 00:00:00.000";
        String end = year + "-12-31 23:59:59.999";

        if (sites.size() > 0) {
            List<Object> time = new ArrayList<>();
            List<Object> data = new ArrayList<>();

            for (BaseSiteDTO site : sites) {
                time.add(site.getSiteName());
                List<ClusterHourDto> hours = null;
                try {
                    hours = simpleHourDataMapper.selectCluster(start, end, site.getId(), itemIds);
                } catch (Exception e) {
                    continue;
                }

                //保存初始化数据组的集合，一个子集合需要有  size  个数据
                List<List<Double>> initData = new ArrayList<>();
                //用来存储需要统计的项目id
                Set<Integer> rankSet = new LinkedHashSet<>();
                //按小时分组，一个小时一组数据，一个小时  size  个数据，低于或者高于不计入运算
                Map<String, List<ClusterHourDto>> groupByDay = new LinkedHashMap<>();
                hours.forEach(hour -> {
                    if ("N".equals(hour.getTroubleCode().trim()) || "".equals(hour.getTroubleCode().trim())) {
                    }
                    String timeStr = hour.getTimeStr();
                    groupByDay.computeIfAbsent(timeStr, k -> new ArrayList<>()).add(hour);
                    rankSet.add(hour.getItemId());
                });

                int size = rankSet.size();

                groupByDay.forEach((k, v) -> {
                    if (v.size() == size) {
                        //排序
                        Collections.sort(v);
                        List<Double> collect = v.stream().map(ClusterHourDto::getValue).map(Double::valueOf).collect(Collectors.toList());
                        initData.add(collect);
                    } else {
                        System.out.println("这组数据少了直指标值");
                    }
                });

                List<List<String>> temp = initData.stream().map(list -> list.stream().map(dd -> new BigDecimal(dd + "").toPlainString()).collect(Collectors.toList())).collect(Collectors.toList());
                data.add(temp);
            }

            Map<String, List<Object>> returnData = new HashMap<>();
            returnData.put("time", time);
            returnData.put("data", data);
            return returnData;
        } else {
            return null;
        }
    }

    public Map<String, List<Object>> clusterGroupByMonth(Integer siteId, Integer year, List<Integer> itemIds,String type) {
        String start = year + "-01-01 00:00:00.000";
        String end = year + "-12-31 23:59:59.999";
        List<ClusterHourDto> hours = null;
        try {
            hours = simpleHourDataMapper.selectCluster(start, end, siteId, itemIds);
        } catch (Exception e) {
            return null;
        }
        //按月份分组，计算每个月份的聚类核心
        Map<String, List<ClusterHourDto>> groupByMonth = new LinkedHashMap<>();  //正常数据
        //Map<String, List<ClusterHourDto>> groupByMonthError = new LinkedHashMap<>();  //异常数据
        Set<Integer> rankSet = new LinkedHashSet<>();  //用来存储需要统计的项目id
        hours.forEach(hour -> {
            Integer itemId = hour.getItemId();
            if (itemIds.contains(itemId)) {
                rankSet.add(itemId);
            }

            String month = hour.getTimeStr().substring(0, 7);
            //暂时不区分异常正常数据
            //if ("N".equals(hour.getTroubleCode().trim()) || "".equals(hour.getTroubleCode().trim())) {
            groupByMonth.computeIfAbsent(month, k -> new ArrayList<>()).add(hour);
            //} else {
            //groupByMonthError.computeIfAbsent(month, k -> new ArrayList<>()).add(hour);
            //}
        });

        //每组数据个数
        int size = rankSet.size();

        Map<String, List<List<Double>>> DoubleByMonth = new LinkedHashMap<>();
//保存指标名称，这里用来因子分析
        List<Object> factor = new ArrayList<>();
        //处理正常数据的聚类
        groupByMonth.forEach((month, lists) -> {
            //System.out.println("同一个月份"+month+"----共"+lists.size());

            //保存初始化数据组的集合，一个子集合需要有  size  个数据
            List<List<Double>> initData = new ArrayList<>();

            //按小时分组，一个小时一组数据，一个小时  size  个数据，低于或者高于不计入运算
            Map<String, List<ClusterHourDto>> groupByDay = new LinkedHashMap<>();
            lists.forEach(item -> {
                String timeStr = item.getTimeStr();
                groupByDay.computeIfAbsent(timeStr, k -> new ArrayList<>()).add(item);
            });


            groupByDay.forEach((k, v) -> {
                if (v.size() == size) {
                    //排序
                    Collections.sort(v);
                    List<Double> collect = v.stream().map(ClusterHourDto::getValue).map(Double::valueOf).collect(Collectors.toList());
                    initData.add(collect);

                    if (!"聚类分析".equals(type) && factor.size() == 0) {

                        factor.addAll(v.stream().map(ClusterHourDto::getItemName).collect(Collectors.toList()));
                    }
                } else {
                    //System.out.println("这组数据有少了值");
                }
            });

            DoubleByMonth.put(month, initData);
        });

        //DoubleByMonth.forEach((month,monthList)->{
        //    Kmeans main = new Kmeans();
        //    //加载啊原始数据
        //    List<List<Double>> lists = main.loadAndPretreatment(null, monthList);
        //    //获取初始聚类核心
        //    List<List<Double>> initKernal = main.set_kernal(lists, kernal);//设置初始核心
        //    //获取最终聚类核心集合
        //    List<List<Double>> finalKernal = main.k_means(lists, initKernal);
        //});

        List<Object> time = new ArrayList<>();
        List<Object> data = new ArrayList<>();
        DoubleByMonth.forEach((month, monthList) -> {
            if (monthList.size() > 0) {
                time.add(month);
                List<List<String>> temp = monthList.stream().map(list -> list.stream().map(dd -> new BigDecimal(dd + "").toPlainString()).collect(Collectors.toList())).collect(Collectors.toList());
                data.add(temp);
            }
        });
        Map<String, List<Object>> returnData = new HashMap<>();
        returnData.put("time", time);
        returnData.put("data", data);
        if (!"聚类分析".equals(type)) {
            returnData.put("factor", factor);
        }


        return returnData;
    }


    //聚类分析，采用k-means（月份）
    public Map<String, List<List<Double>>> analyzeKmeans(Integer siteId, String year, Integer kernal) {

        List<Map<String, Object>> hours = hourMapper.selectHistoryData(siteId, year + "-01-01 00:00:00.000", year + "-12-31 23:59:59.999", "desc");
        //按月份分组，计算歘每个月份的聚类核心
        Map<String, List<Map<String, Object>>> groupByMonth = new LinkedHashMap<>();
        for (Map<String, Object> hour : hours) {
            String moniterTime = hour.get("moniterTime") + "";
            String month = moniterTime.substring(0, 7);//2020-01
            List<Map<String, Object>> list = groupByMonth.computeIfAbsent(month, k -> new ArrayList<>());
            list.add(hour);
        }

        Map<String, List<List<Double>>> returnMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<Map<String, Object>>> entry : groupByMonth.entrySet()) {
            String monthKey = entry.getKey();
            List<Map<String, Object>> monthValues = entry.getValue();

            List<Map<String, String>> itemValueMaps = new ArrayList<>();
            for (Map<String, Object> hour : monthValues) {
                Map<String, String> map = new LinkedHashMap<>();
                List<Item> items = JsonUtils.nativeRead(hour.get("content") + "", new TypeReference<List<Item>>() {
                });
                items.forEach(item -> {
                    String itemName = item.getItemName().trim();
                    String value = item.getValue();
                    switch (itemName) {
                        case "温度":
                        case "溶解氧":
                        case "浊度":
                        case "pH":
                        case "电导率":
                            map.put(itemName, value);
                            break;
                        default:
                            //暂时不干任何事
                            break;
                    }
                });
                if (map.size() == 5) {
                    itemValueMaps.add(map);
                }
            }

            Kmeans main = new Kmeans();
            List<List<Double>> lists = main.loadAndPretreatment(itemValueMaps, null);

            List<List<Double>> setKernal = main.set_kernal(lists, kernal);//设置初始核心

            //最终的聚类核心集合
            List<List<Double>> finalKernal = main.k_means(lists, setKernal);

            //  聚合类型，个数
            Map<Double, Double> percent = new HashMap<>();

            for (List<Double> doubles : lists) {
                for (int i = 0; i < doubles.size(); i++) {
                    Double d = doubles.get(i);
                    //System.out.print(d + "   ");
                    if (i == doubles.size() - 1) {
                        //这里d是数据聚合类型
                        //个数
                        Double aDouble = percent.get(d);
                        if (aDouble == null) {
                            percent.put(d, 1d);
                        } else {
                            percent.put(d, aDouble + 1d);
                        }
                    }
                }
                //System.out.println();
            }

            // System.out.println("聚类分析百分比打印");

            BigDecimal all = new BigDecimal(lists.size() + "");
            for (List<Double> singel : finalKernal) {
                for (int i = 0; i < singel.size(); i++) {
                    Double d = singel.get(i);
                    singel.set(i, new BigDecimal(d + "").setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue());
                }
                //类型
                Double type = singel.get(singel.size() - 1);
                //个数
                Double num = percent.get(type);
                //百分比
                double v = new BigDecimal(num * 100 + "").divide(all, 2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
                singel.add(v);
            }

            returnMap.put(monthKey, finalKernal);
        }

        return returnMap;
    }

    public Map<String, List<List<Double>>> analyzeKmeansForSite(String year, Integer kernal) {
        List<BaseSiteDTO> sites = baseSiteMapper.getSites(UserHolder.loginId());
        Map<String, List<List<Double>>> returnMap = new LinkedHashMap<>();
        for (BaseSiteDTO site : sites) {

            List<Map<String, Object>> hours = hourMapper.selectHistoryData(site.getId(), year + "-01-01 00:00:00.000", year + "-12-31 23:59:59.999", "desc");
            List<Map<String, String>> itemValueMaps = new ArrayList<>();
            for (Map<String, Object> hour : hours) {
                Map<String, String> map = new LinkedHashMap<>();
                List<Item> items = JsonUtils.nativeRead(hour.get("content") + "", new TypeReference<List<Item>>() {
                });
                items.forEach(item -> {
                    String itemName = item.getItemName().trim();
                    String value = item.getValue();
                    switch (itemName) {
                        case "温度":
                        case "溶解氧":
                        case "浊度":
                        case "pH":
                        case "电导率":
                            map.put(itemName, value);
                            break;
                        default:
                            //暂时不干任何事
                            break;
                    }
                });
                if (map.size() == 5)
                    itemValueMaps.add(map);
            }

            Kmeans main = new Kmeans();
            List<List<Double>> lists = main.loadAndPretreatment(itemValueMaps, null);

            List<List<Double>> setKernal = main.set_kernal(lists, kernal);//设置初始核心

            //最终的聚类核心集合
            List<List<Double>> finalKernal = main.k_means(lists, setKernal);

            //System.out.println("聚类核心");
            //  聚合类型，个数
            Map<Double, Double> percent = new HashMap<>();

            for (List<Double> doubles : lists) {
                for (int i = 0; i < doubles.size(); i++) {
                    Double d = doubles.get(i);
                    if (i == doubles.size() - 1) {
                        //这里d是数据聚合类型
                        //个数
                        Double aDouble = percent.get(d);
                        if (aDouble == null) {
                            percent.put(d, 1d);
                        } else {
                            percent.put(d, aDouble + 1d);
                        }
                    }
                }
            }

            BigDecimal all = new BigDecimal(lists.size() + "");
            for (List<Double> singel : finalKernal) {
                for (int i = 0; i < singel.size(); i++) {
                    Double d = singel.get(i);
                    singel.set(i, new BigDecimal(d + "").setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue());
                }
                //类型
                Double type = singel.get(singel.size() - 1);
                //个数
                Double num = percent.get(type);
                //百分比
                double v = new BigDecimal(num * 100 + "").divide(all, 2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
                singel.add(v);
            }

            returnMap.put(site.getSiteName(), finalKernal);
        }

        return returnMap;
    }


}



