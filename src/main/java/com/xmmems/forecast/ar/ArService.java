package com.xmmems.forecast.ar;

import com.xmmems.common.utils.DateFormat;
import com.xmmems.domain.SimpleHourData;
import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.mapper.SimpleHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    @Scheduled(cron = "0 35 * * * ?")
    //@Scheduled(fixedRate = 10000000)
    public void te() {
        List<Map<String, Integer>> list = baseSiteitemMapper.getValidSiteIdItemId();

        list.forEach(map -> {
            Integer siteId = map.get("siteId");
            Integer itemId = map.get("itemId");
            Integer number = map.get("number");
            ar(siteId, itemId, number);
        });

    }

    private void ar(Integer siteId, Integer itemId, Integer number) {

        //获取5条
        List<Map<String, String>> mapList = simpleHourDataMapper.select50(siteId, itemId);

        List<Double> list = new ArrayList<>();

        for (Map<String, String> map : mapList) {
            //String troubleCode = map.get("troubleCode");
            //if ("N".equals(troubleCode.trim())) {
            list.add(Double.parseDouble(map.get("value")));
            //}
        }

        Collections.reverse(list);

        if (list.size() > 0) {

            String preValue = getWeightedArithmeticMean(list);

            //这里把预测值存进数据库
            SimpleHourData record = new SimpleHourData();
            Map<String, String> map = mapList.get(0);
            String timeStr = map.get("timeStr");
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
            record.setPreValue(preValue);
            record.setNumber(number);
            try {
                simpleHourDataMapper.insertSelective(record);
            } catch (Exception e) {
                if (e.getMessage().contains("PRIMARY")) {
                    simpleHourDataMapper.updateByPrimaryKeySelective(record);
                }
            }
        }
    }

    /**
     * 算术平均数
     *
     * @param list 存储数据的List<Double> 集合
     * @return 算术平均数
     */
    public static String getArithmeticMean(List<Double> list) {
        if (list != null && list.size() > 0) {
            double sum = 0;
            for (Double d : list) {
                sum += d;
            }
            sum = sum / list.size();
            return scale(sum);
        } else {
            throw new RuntimeException("参数 list 为 NULL 或者没有数据");
        }
    }

    /**
     * 加权算数平均数
     *
     * @param list 存储数据的List<Double> 集合
     * @return 加权算数平均数
     */
    public static String getWeightedArithmeticMean(List<Double> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            int all = 0;
            for (int i = 1; i <= size; i++) {
                all += i;
            }
            double sum = 0;
            for (int i = 1; i <= size; i++) {
                Double d = list.get(i - 1);
                sum += d * i;
            }
            sum = sum / all;
            return scale(sum);
        } else {
            throw new RuntimeException("参数 list 为 NULL 或者没有数据");
        }
    }

    private static String scale(double d) {
        return new BigDecimal(d).setScale(6, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
    }
}
