package com.xmmems.analyze.service;

import com.xmmems.mapper.SimpleHourDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @描述 趋势分析
 * @创建人 ithxw
 * @创建时间 2020.09.10 11:06
 */
@Service
@Transactional
public class TrendService {

    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    //指数回归
    public List<double[]> mkdl(Integer siteId, Integer itemId, String start, String end, Integer space) {

        Integer count = simpleHourDataMapper.selectValuesCount(siteId, itemId, start, end);
        List<String> list = simpleHourDataMapper.selectValues(siteId, itemId, start, end, space, count);
        List<double[]> temp = new ArrayList<>();
        if (list.size() > 0) {
            double[] doubles = list.stream().mapToDouble(dd -> new BigDecimal(dd).doubleValue()).toArray();

            for (int i = 0; i < doubles.length; i++) {
                double[] d = new double[2];
                d[0] = i + 1;
                d[1] = doubles[i];
                temp.add(d);
            }
        }

        return temp;
    }

    public String mannKendall(Integer siteId, Integer itemId, String start, String end, Integer space) {
        Integer count = simpleHourDataMapper.selectValuesCount(siteId, itemId, start, end);
        List<String> list = simpleHourDataMapper.selectValues(siteId, itemId, start, end, space, count);

        if (list.size() > 0) {
            List<double[]> tempTime = new ArrayList<>();  //时间升序排序
            List<double[]> tempValue = new ArrayList<>();  //值大小升序排序
            double[] doubles = list.stream().mapToDouble(dd -> new BigDecimal(dd).doubleValue()).toArray();

            for (int i = 0; i < doubles.length; i++) {
                double[] d = new double[2];
                d[0] = i + 1;
                d[1] = doubles[i];
                tempTime.add(d);
            }

            Arrays.sort(doubles);  //升序

            for (int i = 0; i < doubles.length; i++) {
                double[] d = new double[2];
                d[0] = i + 1;
                d[1] = doubles[i];
                tempValue.add(d);
            }

            int size = tempTime.size();

            for (int i = 0; i < size; i++) {
                double[] timeValue = tempTime.get(i);
                double value = timeValue[1];
                for (int j = 0; j < tempValue.size(); j++) {
                    double[] comValue = tempValue.get(j);
                    if (comValue[1] == value) {
                        timeValue[1] = comValue[0];
                        comValue[1] = Double.MAX_VALUE;  //赋值最大值是为了不再参与排序
                        break;
                    }
                }
            }

            //总对数
            int all = size * (size - 1) / 2;

            //计算同序对数
            int syntropy = 0;
            for (int i = 0; i < size; i++) {
                double[] timeCom = tempTime.get(i);
                double com = timeCom[1];
                for (int j = i + 1; j < size; j++) {
                    double com2 = tempTime.get(j)[1];
                    if (com < com2) {
                        syntropy++;
                    }
                }
            }

            //计算异序对数
            int reverse = all - syntropy;

            //计算系数
            double i = 1.0 * (syntropy - reverse) / all;

            return new BigDecimal("" + i).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
        }
        return "";
    }

    //@Scheduled(initialDelay = 1000 ,fixedRate = 100000)
    public String spearman(Integer siteId, Integer itemId, String start, String end, Integer space) {
        Integer count = simpleHourDataMapper.selectValuesCount(siteId, itemId, start, end);
        List<String> list = simpleHourDataMapper.selectValues(siteId, itemId, start, end, space, count);
        if (list.size() > 0) {

            Double[] X1 = new Double[list.size()];
            Double[] Y1 = new Double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                X1[i] = i + 1d;
                Y1[i] = new Double(s);
            }

            List<Double> Xrange = getRange(X1, Arrays.copyOf(X1, X1.length));
            List<Double> Yrange = getRange(Y1, Arrays.copyOf(Y1, Y1.length));

            List<Double> di2 = getDI2(Xrange, Yrange);

            double sum = 0;

            for (Double aDouble : di2) {
                sum += aDouble;
            }
            double p = 1 - (6 * sum) / ((Math.pow(X1.length, 3)) - X1.length);
            //System.out.println(p);
            return new BigDecimal(p + "").setScale(4, BigDecimal.ROUND_HALF_EVEN).toPlainString();
        }
        return "";
    }

    //获取di的平方
    private static List<Double> getDI2(List<Double> xrange, List<Double> yrange) {
        List<Double> di2 = new ArrayList<>();
        for (int i = 0; i < xrange.size(); i++) {
            double v = xrange.get(i) - yrange.get(i);
            di2.add(Math.pow(v, 2));
        }
        return di2;
    }

    private static List<Double> getRange(Double[] a, Double[] b) {
        Arrays.sort(a);
        List<Map<Double, Double>> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            Map<Double, Double> map = new HashMap<>();
            map.put(a[i], i + 1d);
            list.add(map);
        }

        for (int i = 0; i < list.size(); i++) {
            Map<Double, Double> map = list.get(i);
            Map.Entry<Double, Double> next = map.entrySet().iterator().next();
            Double key = next.getKey();
            Double value = next.getValue();
            int count = 1;
            if (i + 1 < list.size()) {

                for (int j = i + 1; j < list.size(); j++) {
                    Map.Entry<Double, Double> next1 = list.get(j).entrySet().iterator().next();
                    if (key.equals(next1.getKey())) {
                        value = value + next1.getValue();
                        count++;
                    } else {
                        break;
                    }
                }
                value = value / count;
                for (int j = i + 1; j < list.size(); j++) {
                    Map.Entry<Double, Double> next1 = list.get(j).entrySet().iterator().next();
                    if (key.equals(next1.getKey())) {
                        next1.setValue(value);
                    } else {
                        break;
                    }
                }
                next.setValue(value);
            }
        }

        List<Double> res = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            for (Map<Double, Double> map : list) {

                Map.Entry<Double, Double> next = map.entrySet().iterator().next();
                if (b[i].equals(next.getKey())) {
                    res.add(next.getValue());
                    list.remove(map);
                    break;
                }
            }
        }

        return res;
    }


}
