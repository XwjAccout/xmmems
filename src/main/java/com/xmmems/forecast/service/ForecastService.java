package com.xmmems.forecast.service;

import com.xmmems.common.utils.DateFormat;
import com.xmmems.domain.SimpleHourData;
import com.xmmems.forecast.utils.arima.ARIMAModel;
import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.mapper.SimpleHourDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
@Slf4j
public class ForecastService {
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;

    //定時預測數據
    @Scheduled(cron = "0 30 * * * ?")
    //@Scheduled(fixedRate = 1000)
    public void te() {
        //ARIMA(22, 13);
        List<Map<String, Integer>> list = baseSiteitemMapper.getValidSiteIdItemId();

        list.forEach(map -> {
            //System.out.println(map.get("siteId")+"====="+map.get("itemId"));
            Integer siteId = map.get("siteId");
            Integer itemId = map.get("itemId");
            Integer number = map.get("number");
            ARIMA(siteId, itemId, number);
        });

    }

    public void ARIMA(Integer siteId, Integer itemId, Integer number) {
        String preValue = null; //预测值

        List<Map<String, String>> mapList = simpleHourDataMapper.select50(siteId, itemId);

        ArrayList<Double> all = new ArrayList<>();

        //用来判断数剧是否多个相等
        Set<String> set = new LinkedHashSet<>();

        for (Map<String, String> map : mapList) {
            String troubleCode = map.get("troubleCode");
            if ("N".equals(troubleCode.trim())) {

                String value = map.get("value");
                all.add(Double.parseDouble(value));
                set.add(value);
            }
        }

        if (all.size() >= 6) {

            if (set.size() < 3) {
                preValue = set.iterator().next();
            } else {

                double[] data = new double[all.size()];
                for (int i = 0; i < data.length; ++i) {
                    data[i] = all.get(i);
                }

                ARIMAModel arima = new ARIMAModel(data);

                ArrayList<int[]> list = new ArrayList<>();
                int period = 1;  //阶段，期
                int modelCnt = 3;            //通过多次预测的平均值作为预测值
                double[] tmpPredict = new double[modelCnt];
                for (int k = 0; k < modelCnt; ++k)            //控制通过多少组参数进行计算最终的结果
                {
                    int[] bestModel = arima.getARIMAModel(period, list, k != 0);
                    if (bestModel.length == 0) {
                        tmpPredict[k] = data[data.length - period];

                        break;
                    } else {
                        double predictDiff = arima.predictValue(bestModel[0], bestModel[1], period);
                        tmpPredict[k] = arima.aftDeal(predictDiff, period);

                    }
                    //System.out.println("BestModel is " + bestModel[0] + " " + bestModel[1]);
                    list.add(bestModel);
                }
                all.clear();
                double sumPredict = 0.0;
                for (double i : tmpPredict) {
                    sumPredict += i;
                }

                sumPredict = sumPredict / tmpPredict.length;

                preValue = new BigDecimal(sumPredict).setScale(6, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
            }
            // log.info("预测的值:" + preValue);


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

    public List<Map<String, String>> preValue(Integer siteId, Integer itemId, String start, String end, Integer type) {
        switch (type) {
            case 1:return simpleHourDataMapper.selectPreValue1(siteId, itemId, start, end);
            case 2:return simpleHourDataMapper.selectPreValue2(siteId, itemId, start, end);
            case 3:return simpleHourDataMapper.selectPreValue3(siteId, itemId, start, end);
            case 4:return simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
            case 5:return simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
            case 6:return simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
            case 7:return simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
            case 8:return simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
            case 9:return simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
            case 10:return simpleHourDataMapper.selectPreValue(siteId, itemId, start, end);
            default:return null;
        }
    }
}
