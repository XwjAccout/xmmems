package com.xmmems.forecast.ar;

import com.xmmems.common.utils.DateFormat;
import com.xmmems.domain.SimpleHourData;
import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.mapper.SimpleHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.09.18 09:37
 */
@Service
@Transactional
public class ArService {
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;

    //定時預測數據
    @Scheduled(cron = "0 40 * * * ?")
    //@Scheduled(fixedRate = 10000000)
    public void te() {
        //ARIMA(22, 13);
        List<Map<String, Integer>> list = baseSiteitemMapper.getValidSiteIdItemId();

        list.forEach(map -> {
            Integer siteId = map.get("siteId");
            Integer itemId = map.get("itemId");
            Integer number = map.get("number");
            ar(siteId, itemId, number);
        });

    }

    private void ar(Integer siteId, Integer itemId, Integer number) {

        List<Map<String, String>> mapList = simpleHourDataMapper.select50(siteId, itemId);

        List<Double> list = new ArrayList<>();

        for (Map<String, String> map : mapList) {
            String troubleCode = map.get("troubleCode");
            if ("N".equals(troubleCode.trim())) {
                list.add(Double.parseDouble(map.get("value")));
            }
        }

        Collections.reverse(list);

        if (list.size() > 0) {

            String preValue1 = ArUtil.getArithmeticMean(list);
            String preValue2 = ArUtil.getWeightedArithmeticMean(list);
            String preValue3;
            if (itemId <= 9) {
                preValue3 = ArUtil.getExponentialSmoothingOne(list, 0.3);
            } else {
                preValue3 = ArUtil.getExponentialSmoothingOne(list, 0.7);
            }

            //这里把预测值存进数据库
            SimpleHourData record = new SimpleHourData();
            Map<String, String> map = mapList.get(0);
            String timeStr = map.get("timeStr");
            //List<Map<String, String>> siteItems = baseSiteitemMapper.selectBySiteId(siteId);
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

            Date date = new Date(DateFormat.parseAll(timeStr).getTime() + subHour * 3600000);
            record.setTime(date);
            record.setTimeStr(DateFormat.formatAll(date));
            record.setSiteId(siteId);
            record.setItemId(itemId);
            record.setPreValue1(preValue1);
            record.setPreValue2(preValue2);
            record.setPreValue3(preValue3);
            record.setNumber(number);
            try {
                simpleHourDataMapper.insertSelective(record);
            } catch (Exception e) {
                if (e.getMessage().contains("PRIMARY")) {
                    simpleHourDataMapper.updateByPrimaryKeySelective(record);
                }
            }
            System.out.println();
        }

    }

}
