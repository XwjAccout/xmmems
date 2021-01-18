package com.xmmems.service;

import com.xmmems.domain.base.BaseSite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class DataAnalyzeService {
    @Autowired
    private MonitorService monitorService;

    @Autowired
    private CommonService commonService;

    public List<Map<String, String>> monthDataAnalyze(Integer siteId, String startTime, String endTime,Boolean limit) {
        List<Map<String, String>> list = new ArrayList<>();
         ArrayList<Integer> statistics = new ArrayList<Integer>() {{
            for (int i = 0; i < 11; i++) {
                add(i);
            }
        }};

        List<Map<String, String>> month = monitorService.month(siteId, startTime, endTime, statistics,limit);

        Map<String, BaseSite> allSiteMap = commonService.getAllSiteMap();
        BaseSite site = allSiteMap.get(siteId);

        String levelStandard = site.getLevelStandard();
        if (levelStandard == null) {
            levelStandard = "3";
        }
        //标准水质
        Integer standard = Integer.valueOf(levelStandard);

        //正常水质
        List<String> nomalWater = new ArrayList<>();
        if (standard == 6) {
            nomalWater.add("I");
            nomalWater.add("II");
            nomalWater.add("III");
            nomalWater.add("IV");
            nomalWater.add("V");
            nomalWater.add("劣V");
        } else if (standard == 5) {
            nomalWater.add("I");
            nomalWater.add("II");
            nomalWater.add("III");
            nomalWater.add("IV");
            nomalWater.add("V");
        } else if (standard == 4) {
            nomalWater.add("I");
            nomalWater.add("II");
            nomalWater.add("III");
            nomalWater.add("IV");
        } else if (standard == 3) {
            nomalWater.add("I");
            nomalWater.add("II");
            nomalWater.add("III");
        } else if (standard == 2) {
            nomalWater.add("I");
            nomalWater.add("II");
        } else if (standard == 1) {
            nomalWater.add("I");
        }


        for (int i = month.size() - 1; i >= month.size() - 12; i--) {
            Map<String, String> map = month.get(i);
            String moniterTime = map.get("moniterTime");
            if (moniterTime.contains("平均有效数据获取率") || moniterTime.contains("有效数据获取率") || moniterTime.contains("平均捕捉率") || moniterTime.contains("数据捕捉率")
                    || moniterTime.contains("主要污染物") || moniterTime.contains("水质类别") || moniterTime.contains("分项类别")) {
                if (moniterTime.contains("有效数据获取率")) {
                    map.put("moniterTime", "单项月运转率(%)");
                } else if (moniterTime.contains("平均有效数据获取率")) {
                    map.put("moniterTime", "平均月运转率(%)");
                } else if (moniterTime.contains("主要污染物")) {
                    map.put("moniterTime", "主要污染指数");
                }
                list.add(map);
            }
            if (moniterTime.contains("分项类别")) {
                Map<String, String> newmap = new HashMap<>();
                Map<String, String> newmap2 = new HashMap<>();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (value.equals("") || nomalWater.contains(value)) {
                        newmap.put(key, "达标");
                        newmap2.put(key, "");
                    } else {
                        newmap.put(key, "不达标");
                        newmap2.put(key, key);
                    }
                }
                newmap.put("moniterTime", "达标情况");
                newmap2.put("moniterTime", "分项污染指数");
                list.add(newmap);
                list.add(newmap2);
            }
        }

        return list;
    }
}
