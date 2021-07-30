package com.xmmems.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.common.utils.WaterLevelTransformUtil;
import com.xmmems.domain.ExceedStandard;
import com.xmmems.domain.base.BaseItem;
import com.xmmems.domain.base.BaseSite;
import com.xmmems.domain.env.EnvHourData;
import com.xmmems.domain.env.EnvHourDataExample;
import com.xmmems.domain.env.EnvQualityConf;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.mapper.BaseItemMapper;
import com.xmmems.mapper.EnvHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @描述 超标统计业务层
 * @创建人 ithxw
 * @创建时间 2020.03.13 09:55
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExceedStandardService {

    @Autowired
    private EnvHourDataMapper envHourDataMapper;

    @Autowired
    private BaseItemMapper baseItemMapper;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private CommonService commonService;

    public List<ExceedStandard> findByDateAndSiteName(String start, String end, String siteId, Boolean scale) {

        EnvHourDataExample example = new EnvHourDataExample();
        EnvHourDataExample.Criteria criteria = example.createCriteria();
        criteria.andGenTimeGreaterThanOrEqualTo(DateFormat.parseAll(start));
        criteria.andGenTimeLessThanOrEqualTo(DateFormat.parseAll(end));
        criteria.andSiteIdEqualTo(Integer.valueOf(siteId));

        List<EnvHourData> envHourDatas = envHourDataMapper.selectByExampleWithBLOBs(example);

        return getExceedStandards(siteId, scale, envHourDatas);
        //获取全部数据
    }

    private List<ExceedStandard> getExceedStandards(String siteId, Boolean scale, List<EnvHourData> envHourDatas) {
        if (envHourDatas == null) {
            return new ArrayList<>();
        }
        //1、获取站点包含的监测项目
        List<BaseSiteitemDTO> temp = commonService.getBaseSiteItemBySiteId(Integer.valueOf(siteId));
        if (temp.isEmpty()) {
            //没有检测项目，无法做质量类别比较判断，直接返回即可
            return new ArrayList<>();
        }
        List<ExceedStandard> list = new ArrayList<>();
        List<String> columns = temp.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());

        //2、查询所有指标的质量类别集合,查询全部 一次性查询，在根据项目名进行处理
        Map<String, List<EnvQualityConf>> allEnvQualityConfs = commonService.getItemNameQualityConfMap();

        String standardLevel = getSlevel(siteId);
        //获取质量类别集合
        for (EnvHourData envHourData : envHourDatas) {

            List<Map<String, String>> itemList = JsonUtils.nativeRead(envHourData.getContent(), new TypeReference<List<Map<String, String>>>() {});
            for (Map<String, String> item : itemList) {
                String itemName = item.get("itemName");
                if (!columns.contains(itemName)) {
                    continue;
                }
                String value = item.get("value");

                //是否保留两位小数
                if (scale != null && scale) {
                    value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
                }

                //获取具体监测因子的质量类别集合
                List<EnvQualityConf> envQualityConfs = allEnvQualityConfs.get(itemName);
                if (envQualityConfs == null || envQualityConfs.size() == 0) {
                    continue;
                }

                if ("溶解氧".equals(itemName)) {
                    for (EnvQualityConf envQualityConf : envQualityConfs) {
                        //超标情况  第三类为标准，小于则属于超标（IV，V 劣V等）
                        if (standardLevel.equals(envQualityConf.getLevel()) && new BigDecimal(value).compareTo(new BigDecimal(envQualityConf.getMinVal())) < 0) {
                            handleExceedDate(list, envHourData, item, itemName, value, envQualityConfs, envQualityConf, standardLevel);
                            break;//中断循环
                        }
                    }
                } else {
                    for (EnvQualityConf envQualityConf : envQualityConfs) {
                        //超标情况  第三类为标准，超过则属于超标（IV，V 劣V等）
                        if (standardLevel.equals(envQualityConf.getLevel()) && new BigDecimal(value).compareTo(new BigDecimal(envQualityConf.getMaxVal())) > 0) {
                            //超标情况
                            handleExceedDate(list, envHourData, item, itemName, value, envQualityConfs, envQualityConf, standardLevel);
                            break;//中断循环
                        }
                    }
                }
            }
        }
        return list;
    }

    //获取标准水质
    private String getSlevel(String key) {
        Map<String, BaseSite> allSiteMap = commonService.getAllSiteMap();
        BaseSite site = allSiteMap.get(key);
        if (site == null) {
            return "III";
        }
        String levelStandard = site.getLevelStandard();
        //获取标准水质
        return levelStandard == null ? "III" : WaterLevelTransformUtil.levelIntToLevelString(Integer.parseInt(levelStandard));
    }

    /**
     * 处理超标数据
     */
    private void handleExceedDate(List<ExceedStandard> list, EnvHourData envHourData, Map<String, String> item, String itemName, String value, List<EnvQualityConf> envQualityConfs, EnvQualityConf envQualityConf, String standardLevel) {
        //实际数值
        BigDecimal bigDecimal1 = new BigDecimal(value);
        for (int i = envQualityConfs.size() - 1; i >= 0; i--) {
            EnvQualityConf envQualityConf2 = envQualityConfs.get(i);
            if (bigDecimal1.compareTo(new BigDecimal(envQualityConf2.getMinVal())) > 0 && bigDecimal1.compareTo(new BigDecimal(envQualityConf2.getMaxVal())) < 0) {
                //超标情况
                ExceedStandard e = new ExceedStandard();
                e.setDate(envHourData.getGenTime());
                //监测时间
                //e.setMnId();   站点MN号
                e.setSiteId(envHourData.getSiteId() + "");
                //站点id
                e.setSiteName(envHourData.getSiteName());
                //e.setItemCode();  监测因子对应代码
                e.setItemId(item.get("itemId"));
                e.setItemName(itemName);
                e.setItemValue(bigDecimal1.toPlainString());
                BaseItem b = commonService.getBaseItemByItemNameOrItemId(itemName);
                if (b != null) {
                    e.setItemUnit(b.getUnit());
                }
                if (!"溶解氧".equals(itemName)) {
                    e.setItemStandard(envQualityConf.getMaxVal());
                } else {
                    e.setItemStandard(envQualityConf.getMinVal());
                }

                String wateType = envQualityConf2.getLevel();
                if (!"溶解氧".equals(itemName)) {
                    BigDecimal divide = bigDecimal1.subtract(new BigDecimal(e.getItemStandard())).divide(new BigDecimal(e.getItemStandard()), 4, BigDecimal.ROUND_HALF_EVEN);
                    BigDecimal bigDecimal = divide.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    if (bigDecimal.compareTo(new BigDecimal(0)) == 0) {
                        bigDecimal = divide.setScale(3, BigDecimal.ROUND_HALF_EVEN);
                    }
                    String string = bigDecimal.toPlainString();
                    wateType = wateType + "类(" + string + ")";
                }
                e.setWaterType(wateType);
                e.setStandardLevel(standardLevel);
                list.add(e);
                break;
            }
        }
    }

    public List<Map<String, Object>> realtime(String siteType) {
        //2、查询所有指标的质量类别集合,查询全部 一次性查询，在根据项目名进行处理
        Map<String, List<EnvQualityConf>> allEnvQualityConfs = commonService.getItemNameQualityConfMap();

        List<Map<String, Object>> realTimeData = monitorService.getRealTimeData(siteType);

        return handlerRealExceed(allEnvQualityConfs, realTimeData);
    }

    private List<Map<String, Object>> handlerRealExceed(Map<String, List<EnvQualityConf>> allEnvQualityConfs, List<Map<String, Object>> realTimeData) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> map : realTimeData) {
            Map<String, Object> temp = new HashMap<>(16);
            temp.put("siteName", map.get("siteName"));
            String level = map.get("level") + "";
            temp.put("level", level);
            String levelStandard = map.get("levelStandard") + "";
            temp.put("levelStandard", levelStandard);
            if (level.contains("$$")) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String itemName = entry.getKey();
                    if ("moniterTime".equals(itemName)) {
                        temp.put("moniterTime", entry.getValue());
                        continue;
                    }
                    if ("moniterTime-level-siteName-levelStandard-siteId".contains(itemName)) {
                        continue;
                    }
                    String value = entry.getValue() + "";
                    if (!value.contains("$$") || value.contains("≤")) {
                        continue;
                    }
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(itemName);
                    List<EnvQualityConf> envQualityConfs = allEnvQualityConfs.get(itemName);
                    if (envQualityConfs == null) {
                        continue;
                    }
                    String tempValue = value.replaceAll("[^\\d\\.]", "");
                    double v = Double.parseDouble(tempValue);
                    for (EnvQualityConf envQualityConf : envQualityConfs) {
                        String kpiName = envQualityConf.getKpiName();
                        if ("溶解氧".equals(kpiName)) {
                            continue;
                        }
                        if (envQualityConf.getLevel().equals(levelStandard)) {
                            double v1 = Double.parseDouble(envQualityConf.getMaxVal());
                            double v2 = (v - v1) / v1;
                            String string = new BigDecimal(v2).setScale(4, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
                            temp.put("beishu", itemName + "(" + envQualityConf.getMaxVal() + "/" + string + ")");
                            break;
                        }
                    }
                }
                String value = stringBuilder.toString();
                temp.put("main", value);
                if (value.length() > 0) {
                    temp.put("exceed", "未达标$$");
                } else {
                    temp.put("exceed", "达标");
                }
            } else {
                temp.put("exceed", "达标");
                temp.put("main", "");
            }
            list.add(temp);
        }
        return list;
    }

    //查找主要污染源
    private String getMainByItemName(List<ExceedStandard> exceedStandards) {
        Map<String, Integer> map = new HashMap<>(4);

        exceedStandards.forEach(exceed -> {
            String itemName = exceed.getItemName();
            if (map.get(itemName) == null) {
                map.put(itemName, 1);
            } else {
                map.put(itemName, map.get(itemName) + 1);
            }
        });
        int max = 0;
        String main = "";
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entrie : entries) {
            if (entrie.getValue() > max) {
                max = entrie.getValue();
                main = entrie.getKey();
            }
        }
        return main;
    }

    public Object qualityEvaluation(String siteId) {
        return null;
    }

    public List<ExceedStandard> findCurrentTime(List<Integer> siteIds) {
        String s = DateFormat.formatSome(System.currentTimeMillis());
        String start = s + " 00:00:00";
        String end = s + " 23:59:59";
        EnvHourDataExample example = new EnvHourDataExample();
        EnvHourDataExample.Criteria criteria = example.createCriteria();
        criteria.andGenTimeGreaterThanOrEqualTo(DateFormat.parseAll(start));
        criteria.andGenTimeLessThanOrEqualTo(DateFormat.parseAll(end));
        criteria.andSiteIdIn(siteIds);

        List<EnvHourData> envHourDatas = envHourDataMapper.selectByExampleWithBLOBs(example);
        //按站点分类
        Map<Integer, List<EnvHourData>> map = new HashMap<>();
        for (EnvHourData envHourData : envHourDatas) {
            Integer siteId = envHourData.getSiteId();
            map.computeIfAbsent(siteId, k -> new ArrayList<>()).add(envHourData);
        }
        //分别查询超标数据
        List<ExceedStandard> collect = map.entrySet().parallelStream().map(e -> getExceedStandards(e.getKey() + "", true, e.getValue())).flatMap(List::stream).collect(Collectors.toList());
        return collect;
    }
}
