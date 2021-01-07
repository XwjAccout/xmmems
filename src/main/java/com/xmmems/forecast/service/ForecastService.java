package com.xmmems.forecast.service;

import com.xmmems.common.utils.DateFormat;
import com.xmmems.forecast.ar.ArService;
import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.mapper.SimpleHourDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@Slf4j
public class ForecastService {
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;

    public List<Map<String, String>> preValue(Integer siteId, Integer itemId, String start, String end, Integer type) {
        List<Map<String, String>> mapList = simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
        if (type <= 1) {
            return mapList;
        } else {
            int number = baseSiteitemMapper.selectNumber(siteId, itemId);
            int subHour = 1;
            switch (number) {
                case 24:
                    subHour = 1;
                    break;
                case 12:
                    subHour = 2;
                    break;
                case 6:
                    subHour = 4;
                    break;
                case 8:
                    subHour = 3;
                    break;
            }

            for (int i = 2; i <= type; i++) {
                boolean b = i % 2 == 0;
                addNewPreValue(mapList, subHour, b);
            }
        }
        return mapList;
    }

    private void addNewPreValue(List<Map<String, String>> mapList, int subHour, boolean size) {
        List<Double> list = new ArrayList<>();

        for (Map<String, String> map : mapList) {
            String value = map.get("value");
            if (value == null) {
                value = map.get("preValue");

            }
            list.add(Double.parseDouble(value));
        }
        String pre = ArService.getWeightedArithmeticMean(list);
        if (size) pre = ArService.getArithmeticMean(list);
        String timeStr = mapList.get(mapList.size() - 1).get("timeStr");
        Date date = new Date(DateFormat.parseAll(timeStr).getTime() + subHour * 3600000);
        Map<String, String> map = new HashMap<>();
        map.put("timeStr", DateFormat.formatAll(date));
        map.put("preValue", pre);
        mapList.add(map);
    }
}
