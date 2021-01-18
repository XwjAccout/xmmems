package com.xmmems.analyze.service;

import com.xmmems.analyze.dto.ClusterHourDto;
import com.xmmems.common.utils.WaterLevelTransformUtil;
import com.xmmems.dto.EnvQualityConfDTO;
import com.xmmems.mapper.BaseSiteMapper;
import com.xmmems.mapper.EnvQualityConfMapper;
import com.xmmems.mapper.SimpleHourDataMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @描述 水质类别占比分析
 * @创建人 ithxw
 * @创建时间 2020.09.29 13:58
 */
@Service
@Transactional
public class QualityAnalysisService {
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;
    @Autowired
    private EnvQualityConfMapper envQualityConfMapper;
    @Autowired
    private BaseSiteMapper baseSiteMapper;

    public List<TempData> levelPercent(Integer year, Integer siteId, List<Integer> itemIds) {
        Map<Integer, List<EnvQualityConfDTO>> envQualityConfMap = new HashMap<>();
        List<EnvQualityConfDTO> envQualityConfList = envQualityConfMapper.getEnvQualityConfDTOList();
        for (EnvQualityConfDTO envQualityConfDTO : envQualityConfList) {
            Integer itemId = envQualityConfDTO.getItemId();
            if (itemIds.contains(itemId)) {
                envQualityConfMap.computeIfAbsent(itemId, k -> new ArrayList<>()).add(envQualityConfDTO);
            }
        }

        Map<String, Map<String, Integer>> temp = new HashMap<>();
        ArrayList<Integer> newItemIds = new ArrayList<>(envQualityConfMap.keySet());
        List<ClusterHourDto> hours = simpleHourDataMapper.selectCluster(year + "-01-01 00:00:00.000", year + "-12-31 23:59:59.999", siteId, newItemIds);
        for (ClusterHourDto hour : hours) {
            Integer itemId = hour.getItemId();
            String itemName = hour.getItemName();
            BigDecimal valueBigDecimal = hour.getValueBigDecimal();
            List<EnvQualityConfDTO> envQualityConfDTOS = envQualityConfMap.get(itemId);
            for (EnvQualityConfDTO confDTO : envQualityConfDTOS) {
                if (confDTO.compareTo(valueBigDecimal)) {
                    Map<String, Integer> map = temp.computeIfAbsent(itemName, k -> new TreeMap<>(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            int a = WaterLevelTransformUtil.levelStringToLevelInt(o1);
                            int b = WaterLevelTransformUtil.levelStringToLevelInt(o2);
                            return a - b;
                        }
                    }));
                    String level = confDTO.getLevel();
                    Integer integer = map.get(level);
                    if (integer == null) integer = 0;
                    map.put(level, integer + 1);
                    break;
                }
            }
        }

        List<TempData> tempDataList = new ArrayList<>();

        //计算各个等级所占百分比
        for (Map.Entry<String, Map<String, Integer>> entry0 : temp.entrySet()) {

            String itemName0 = entry0.getKey();
            Map<String, Integer> value0 = entry0.getValue();
            //每个指标的总条数
            int sum = value0.values().stream().mapToInt(v -> v).sum();
            //System.out.println(itemName0 + "  :  " + sum);
            TempData tempData = new TempData(sum, itemName0, new ArrayList<>());
            //计算各个级别所占百分比
            for (Map.Entry<String, Integer> entry1 : value0.entrySet()) {
                String level = entry1.getKey();
                Integer count = entry1.getValue();
                String percent = new BigDecimal(count * 100d / sum).setScale(3, 6).toPlainString() + "%";
                //System.out.println(level + "  :  " + count + "  :  " + percent);
                Map<String, String> map = new HashMap<>();
                map.put("level", level);
                map.put("count", count + "");
                map.put("percent", percent);
                tempData.getLevelList().add(map);

            }
            tempDataList.add(tempData);
        }

        return tempDataList;
    }

    public Object mainTroubleList(Integer year, Integer siteId, List<Integer> itemIds) {
        Map<String, Object> finalMap = new HashMap<>();

        List<Map<String, String>> data = new ArrayList<>();
        Map<String, Double> temp = new HashMap<>();
        Map<String, String> statistics = new HashMap<>();

        List<TempData> tempDataList = levelPercent(year, siteId, itemIds);
        if (tempDataList.size() > 0) {
            int levelStandard=3;
            try {
                levelStandard = Integer.parseInt(baseSiteMapper.selectByPrimaryKey(siteId).getLevelStandard());
            } catch (Exception ignored) {
            }
            for (TempData tempData : tempDataList) {
                String itemName = tempData.getItemName();
                for (Map<String, String> map : tempData.getLevelList()) {
                    String level = map.get("level");
                    if (WaterLevelTransformUtil.compare(level, levelStandard)) {
                        //level大于levelStandard 代表污染
                        map.put("itemName", itemName);
                        data.add(map);
                        Double d = temp.get(itemName);
                        if (d == null) {
                            d=0d;
                        }
                        temp.put(itemName, d + Double.parseDouble(map.get("percent").replace("%", "")));
                    }
                }
            }
        }

        StringBuilder string = new StringBuilder();
        for (Map.Entry<String, Double> entry : temp.entrySet()) {
            String k = entry.getKey();
            Double v = entry.getValue();
            statistics.put(k, new BigDecimal(v).setScale(3, BigDecimal.ROUND_HALF_EVEN).toPlainString() + "%");
            if (v > 15) {
                string.append(k).append(",");
            }
        }
        String s = "水质良好，请继续保持";
        if (string.length() > 1) {

           s= new StringBuilder().append("请重点治理").append(string).append("等水质监测项目，该项目污染很严重，已经超过15%").toString();
        }

        finalMap.put("data", data);
        finalMap.put("statistics", statistics);
        finalMap.put("suggest", s);

        return finalMap;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class TempData {
    private int all;
    private String itemName;
    private List<Map<String, String>> levelList;
}

