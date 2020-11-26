package com.xmmems.forecast.ar;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @描述 预测工具类
 * @创建人 ithxw
 * @创建时间 2020.09.16 15:17
 */
public class ArUtil {
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

    /**
     * 一次指数平滑法 St(1)​=α⋅yt​+(1−α)⋅St−1(1)​
     *
     * @param list 存储数据的List<Double> 集合
     * @return 指数平滑值
     */
    public static String getExponentialSmoothingOne(List<Double> list, double o) {
        double s0 = 0;
        int size = 2;
        for (int i = 0; i < size; i++) {
            Double d = list.get(i);
            s0 += d;
        }
        s0 /= size;

        List<dto> rs = new ArrayList<>();
        rs.add(new dto(list.get(0), s0));
        for (int i = 1; i < list.size(); i++) {
            Double d = list.get(i);
            double st11= ExponentialSmoothingOneFormula(o, rs.get(i - 1).yt, rs.get(i - 1).st11);
            rs.add(new dto(d, st11));
        }
        //System.out.println(rs);

        //double a2 = 0;
        //for (dto r : rs) {
        //    double v2 = r.st11- r.yt;
        //    a2 += square(v2);
        //}
        //a2 /= rs.size();
        //a2 = reverseSquare(a2);
        //System.out.println(new BigDecimal(a2).setScale(4, 6).toPlainString() + "\t\t");
        return new BigDecimal(ExponentialSmoothingOneFormula(o,rs.get(rs.size()-1).yt,rs.get(rs.size()-1).st11)).setScale(6, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
    }

    //一次指数平滑法 公式 St(1)​=α⋅yt​+(1−α)⋅St−1(1)​
    private static double ExponentialSmoothingOneFormula(double o, double yt, double st11) {
        return o * yt + (1 - o) * st11;
    }

    //求绝对误差
    private static double getError(double a, double b) {
        return a - b;
    }

    //求某个数的2次方
    private static double square(double d) {
        return Math.pow(d, 2);
    }

    //求某个数的开2次方根
    private static double reverseSquare(double d) {
        return Math.sqrt(d);
    }

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(50d);
        list.add(52d);
        list.add(47d);
        list.add(51d);
        list.add(49d);
        list.add(48d);
        list.add(51d);
        list.add(40d);
        list.add(48d);
        list.add(52d);
        list.add(51d);
        list.add(59d);
        getExponentialSmoothingOne(list, 0.2);
    }

    private static String scale(double d) {
        return new BigDecimal(d).setScale(6, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
    }


}

class dto {
    public double yt;
    public double st11;


    public dto() {
    }

    public dto(double yt, double st11) {
        this.yt = yt;
        this.st11= st11;
    }

    @Override
    public String toString() {
        String string = new BigDecimal(st11).setScale(2, 6).toPlainString();
        String yt1 = new BigDecimal(yt).setScale(2, 6).toPlainString();
        return "{" +
                "y=" + yt1 +
                ", st11=" + string + ", flag=" + yt1.equals(string) +
                '}' ;
    }
}
