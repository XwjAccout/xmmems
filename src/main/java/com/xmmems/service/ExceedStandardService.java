package com.xmmems.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.auth.domain.SysUserToken;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.*;
import com.xmmems.domain.ExceedStandard;
import com.xmmems.domain.base.BaseSite;
import com.xmmems.domain.env.EnvHourData;
import com.xmmems.domain.env.EnvHourDataExample;
import com.xmmems.domain.env.EnvQualityConf;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.mapper.BaseItemMapper;
import com.xmmems.mapper.BaseSiteMapper;
import com.xmmems.mapper.EnvHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @描述 超标统计业务层
 * @创建人 ithxw
 * @创建时间 2020.03.13 09:55
 */
@Service
@Transactional
public class ExceedStandardService {
    @Autowired
    private BaseSiteMapper baseSiteMapper;

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

        List<ExceedStandard> list = new ArrayList<>();
        if (envHourDatas != null) {
            Future<Map<String, List<EnvQualityConf>>> allEnvQualityConfsFuture = PoolExecutor.submit(new Callable<Map<String, List<EnvQualityConf>>>() {
                @Override
                public Map<String, List<EnvQualityConf>> call() throws Exception {
                    //2、查询所有指标的质量类别集合,查询全部 一次性查询，在根据项目名进行处理
                    Map<String, List<EnvQualityConf>> allEnvQualityConfs = new HashMap<>();
                    List<EnvQualityConf> envQualityConfList = commonService.getEnvQualityConfList();
                    for (EnvQualityConf envQualityConf : envQualityConfList) {
                        String kpiName = envQualityConf.getKpiName();
                        allEnvQualityConfs.computeIfAbsent(kpiName, k -> new ArrayList<>()).add(envQualityConf);
                    }
                    return allEnvQualityConfs;
                }
            });

            Future<List<String>> columnsFuture = PoolExecutor.submit(new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    //获取站点包含的监测项目
                    List<BaseSiteitemDTO> columns = monitorService.getColumns(Integer.valueOf(siteId));
                    return columns.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());
                }
            });


            Map<String, List<EnvQualityConf>> allEnvQualityConfs = null;
            List<String> collect = null;
            String standardLevel = getSlevel(siteId);
            try {
                collect = columnsFuture.get();
                allEnvQualityConfs = allEnvQualityConfsFuture.get();
            } catch (Exception e) {
                FileLog.error("多线程获取获取数据出错com.xmmems.service.ExceedStandardService.findByDateAndSiteName");
                e.printStackTrace();
                throw new XMException(500,"多线程获取获取数据出错com.xmmems.service.ExceedStandardService.findByDateAndSiteName");
            }
            //获取质量类别集合
            for (EnvHourData envHourData : envHourDatas) {

                List<Map<String, String>> itemList = JsonUtils.nativeRead(envHourData.getContent(), new TypeReference<List<Map<String, String>>>() {
                });
                for (Map<String, String> item : itemList) {
                    String itemName = item.get("itemName");
                    if (collect.contains(itemName)) {
                        String value = item.get("value");

                        //是否保留两位小数
                        if (scale != null && scale) {
                            value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
                        }

                        //获取具体监测因子的质量类别集合
                        List<EnvQualityConf> envQualityConfs = allEnvQualityConfs.get(itemName);

                        if (envQualityConfs != null && envQualityConfs.size() > 0) {

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

                }
            }
        }

        return list;  //获取全部数据
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
                e.setDate(envHourData.getGenTime());  //监测时间
                //e.setMnId();   站点MN号
                e.setSiteId(envHourData.getSiteId() + "");   //站点id
                e.setSiteName(envHourData.getSiteName());
                //e.setItemCode();  监测因子对应代码
                e.setItemId(item.get("itemId"));
                e.setItemName(itemName);
                e.setItemValue(bigDecimal1.toPlainString());
                if (baseItemMapper.selectByName(itemName) != null) {
                    e.setItemUnit(baseItemMapper.selectByName(itemName).getUnit());
                }
                if (!"溶解氧".equals(itemName)) {
                    e.setItemStandard(envQualityConf.getMaxVal());
                } else {
                    e.setItemStandard(envQualityConf.getMinVal());
                }

                String wateType = envQualityConf2.getLevel();
                if (!"溶解氧".equals(itemName)) {
                    BigDecimal divide = bigDecimal1.subtract(new BigDecimal(e.getItemStandard())).divide(new BigDecimal(e.getItemStandard()), 4, BigDecimal.ROUND_HALF_EVEN);
                    BigDecimal bigDecimal = divide.setScale(1, BigDecimal.ROUND_HALF_EVEN);
                    if (bigDecimal.compareTo(new BigDecimal(0)) == 0) {
                        bigDecimal = divide.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                        if (bigDecimal.compareTo(new BigDecimal(0)) == 0) {
                            bigDecimal = divide.setScale(3, BigDecimal.ROUND_HALF_EVEN);
                        }
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

    public List<Map<String, Object>> realtime() {
        Future<Map<String, List<EnvQualityConf>>> allEnvQualityConfsFuture = PoolExecutor.submit(new Callable<Map<String, List<EnvQualityConf>>>() {
            @Override
            public Map<String, List<EnvQualityConf>> call() throws Exception {
                //2、查询所有指标的质量类别集合,查询全部 一次性查询，在根据项目名进行处理
                Map<String, List<EnvQualityConf>> allEnvQualityConfs = new HashMap<>();
                List<EnvQualityConf> envQualityConfList = commonService.getEnvQualityConfList();
                for (EnvQualityConf envQualityConf : envQualityConfList) {
                    String kpiName = envQualityConf.getKpiName();
                    allEnvQualityConfs.computeIfAbsent(kpiName, k -> new ArrayList<>()).add(envQualityConf);
                }
                return allEnvQualityConfs;
            }
        });

        SysUserToken loginUser = UserHolder.getLoginUser();
        Future<List<Map<String, Object>>> realTimeDataFuture = PoolExecutor.submit(new Callable<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> call() throws Exception {
                UserHolder.setLoginUser(loginUser);
                //实时数据
                return monitorService.getRealTimeData();
            }
        });

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, List<EnvQualityConf>> allEnvQualityConfs = null;
        List<Map<String, Object>> realTimeData = null;
        try {
            allEnvQualityConfs = allEnvQualityConfsFuture.get();
            realTimeData = realTimeDataFuture.get();
        } catch (Exception e) {
            String err = "使用多线程出错com.xmmems.service.ExceedStandardService.realtime";
            FileLog.error(err);
            e.printStackTrace();
            throw new XMException(500, err);
        }

        for (Map<String, Object> map : realTimeData) {
            Map<String, Object> temp = new HashMap<>();
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
                    if (!"moniterTime-level-siteName-levelStandard-siteId".contains(itemName)) {
                        String value = entry.getValue() + "";
                        if (value.contains("$$") && !value.contains("≤")) {
                            if (stringBuilder.length() != 0) {
                                stringBuilder.append(",");
                            }
                            stringBuilder.append(itemName);
                            List<EnvQualityConf> envQualityConfs = allEnvQualityConfs.get(itemName);
                            if (envQualityConfs != null) {
                                String tempValue = value.replaceAll("[^\\d\\.]", "");
                                double v = Double.parseDouble(tempValue);
                                for (EnvQualityConf envQualityConf : envQualityConfs) {
                                    String kpiName = envQualityConf.getKpiName();
                                    if (!kpiName.equals("溶解氧")) {
                                        if (envQualityConf.getLevel().equals(levelStandard)) {
                                            double v1 = Double.parseDouble(envQualityConf.getMaxVal());
                                            double v2 = (v - v1) / v1;
                                            String string = new BigDecimal(v2).setScale(4, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
                                            temp.put("beishu", itemName + "(" + envQualityConf.getMaxVal() + "/" + string + ")");
                                            break;
                                        }
                                    }
                                }
                            }
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
        Map<String, Integer> map = new HashMap<>();

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
       /* if (StringUtils.isNotBlank(siteId )) {
            String now = DateFormat.formatSome(System.currentTimeMillis());
            List<ExceedStandard> list = findByDateAndSiteName(now+" 00:00:00", now+" 23:59:59", siteId,null ,false);
            System.out.println();
        }*/
        return null;
    }
}
