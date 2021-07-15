package com.xmmems.forecast.service;

import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.mapper.SimpleHourDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ForecastService {
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;

    /**
     * @param siteId
     * @param itemId
     * @param start
     * @param end
     * @param type   预测最新的一次个数
     * @return
     */
    public List<Map<String, String>> preValue(Integer siteId, Integer itemId, String start, String end, Integer type, Integer scale) throws ParseException, ArrayIndexOutOfBoundsException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sP = sdf.parse(start);
        String s = sdf.format(sP.getTime() - 48 * 60 * 60 * 1000);
        //0、多2天以便计算start时间的预测值
        List<Map<String, String>> mapList = simpleHourDataMapper.selectPreValue(siteId, itemId, s, end);

        //1、倒叙处理preValue，以前4个值的平均值做预测值
        for (int i = mapList.size() - 1; i >= 4; i--) {
            Map<String, String> map = mapList.get(i);
            String preValue = new BigDecimal(mapList.get(i - 1).get("value")).add(new BigDecimal(mapList.get(i - 2).get("value"))).add(new BigDecimal(mapList.get(i - 3).get("value"))).add(new BigDecimal(mapList.get(i - 4).get("value"))).divide(new BigDecimal("4"), scale, BigDecimal.ROUND_HALF_EVEN).toPlainString();
            map.put("preValue", preValue);
        }


        //3、一天测试次数
        int number = baseSiteitemMapper.selectNumber(siteId, itemId);
        //4、计算下一次的预测时间间隔几小时
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

        //比较查询所得数据的最后一个监测时间与前端所选结束时间的一个时间做对比
        //        Date eP = sdf.parse(end);
        //        Map<String, String> lastMap = mapList.get(mapList.size() - 1);
        //        Date lastP = sdf.parse(lastMap.get("timeStr"));

        //加type个预测值，没有真实值的监测数据
        for (int i = 0; i < type; i++) {
            addEle(mapList, subHour, sdf, scale);
        }

        //2、去除这多两天的数据
        Iterator<Map<String, String>> iterator = mapList.iterator();
        while (iterator.hasNext()) {
            Map<String, String> next = iterator.next();
            String timeStr = next.get("timeStr");
            Date t = sdf.parse(timeStr);
            if (t.compareTo(sP) < 0) {
                iterator.remove();
            } else {
                break;
            }
        }

        return mapList;
    }

    private void addEle(List<Map<String, String>> mapList, int subHour, SimpleDateFormat sdf, int scale) throws ParseException, ArrayIndexOutOfBoundsException {
        //最后一个值对象
        int size = mapList.size();
        Map<String, String> lastMap = mapList.get(size - 1);
        //预测的下一个值时间
        long l = sdf.parse(lastMap.get("timeStr")).getTime() + subHour * 60 * 60 * 1000L;
        String timeStr = sdf.format(l);
        //封装预测值对象
        Map<String, String> map = new HashMap<>();
        String preValue = null;
        preValue = new BigDecimal(mapList.get(size - 1).get("preValue")).add(new BigDecimal(mapList.get(size - 2).get("preValue"))).add(new BigDecimal(mapList.get(size - 3).get("preValue"))).add(new BigDecimal(mapList.get(size - 4).get("preValue"))).divide(new BigDecimal("4"), scale, BigDecimal.ROUND_HALF_EVEN).toPlainString();
        map.put("timeStr", timeStr);
        map.put("preValue", preValue);
        //添加预测值
        mapList.add(map);
    }

}
