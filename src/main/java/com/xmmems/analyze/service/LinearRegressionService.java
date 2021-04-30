package com.xmmems.analyze.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.mapper.EnvHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述 线性回归相关系分析
 * @创建人 ithxw
 * @创建时间 2020.09.24 11:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LinearRegressionService {

    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;

    @Autowired
    private EnvHourDataMapper envHourDataMapper;

    public Object linearRegression(Integer siteId, String start, String end, Integer itemId) {

        String itemIdStr = itemId + "";
        Map<String, List<double[]>> itemIdandList = new HashMap<>(16);
//  key   relation 关系   value   x=y  如：温度=ph代表温度作为x轴，ph作为y轴
//  key   data 对应数据   value    List<double[]>  如：[[0.067732, 3.176513],[0.42781, 3.816464]]
        TypeReference<List<Map<String, String>>> type = new TypeReference<List<Map<String, String>>>() {
        };
        List<String> contents = envHourDataMapper.selectContent(siteId, start, end);
        for (String content : contents) {
            double valueX = 0;
            List<Map<String, String>> list = JsonUtils.nativeRead(content, type);
            if (list != null && list.size() >= 2) {

                for (Map<String, String> map : list) {
                    String itemIdTemp = map.get("itemId").replace(".0", "");
                    if (itemIdStr.equals(itemIdTemp)) {
                        valueX = Double.parseDouble(map.get("value"));
                        break;
                    }
                }
                for (Map<String, String> map : list) {
                    String itemIdTemp = map.get("itemId").replace(".0", "");
                    if (!itemIdStr.equals(itemIdTemp)) {
                        double valueY = Double.parseDouble(map.get("value"));
                        List<double[]> ds = itemIdandList.computeIfAbsent(itemIdTemp, k -> new ArrayList<>());
                        double[] d = {valueX, valueY};
                        ds.add(d);
                    }
                }
            }

        }

        List<BaseSiteitemDTO> columns = baseSiteitemMapper.getColumns(siteId);
        List<Map<String, Object>> listmap = new ArrayList<>();
        for (BaseSiteitemDTO column : columns) {
            int itemId1 = column.getItemId();
            if (itemId != itemId1) {

                String itemName = column.getItemName();
                Map<String, Object> map = new HashMap<>(4);
                map.put("relation", itemName);
                map.put("data", itemIdandList.get(itemId1 + ""));
                listmap.add(map);
            }

        }

        return listmap;
    }
}
