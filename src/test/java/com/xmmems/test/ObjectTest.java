package com.xmmems.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//因子分析
public class ObjectTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long s = System.currentTimeMillis();
        FutureTask<String> futureTask1 = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return tt1();
            }
        });
        FutureTask<String> futureTask2 = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return tt3();
            }
        });

        FutureTask<String> futureTask3 = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return tt5();
            }
        });

        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();

        long m = System.currentTimeMillis();
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());
        long e = System.currentTimeMillis();
        System.out.println(m-s);
        System.out.println(e-m);
        System.out.println(e-s);



    }

    public static String tt1() throws InterruptedException {
        Thread.sleep(1000);
        return "111";
    }
    public static String tt3() throws InterruptedException {
        Thread.sleep(3000);
        return "333";
    }
    public static String tt5() throws InterruptedException {
        Thread.sleep(5000);
        return "555";
    }






    private static void app() {
        System.out.println("11");
        throw new RuntimeException("test");
    }

    public  void aa() {
        double d = 0.05;
        int scale = 4;
        Random r = new Random();  //


        List<Double> list = new ArrayList<>();

        for (int i = 0; i < 1000000000; i++) {
            double v = r.nextDouble()*(getMax(d)+1);
            if (v >= getMin(d) && v <= getMax(d)) {
                list.add(v);
                if (list.size() == 7) {
                    break;
                }
            }
        }

        double[] doubles = list.stream().mapToDouble(dd -> dd).toArray();

        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = new BigDecimal(doubles[i]).setScale(scale, 6).doubleValue();
        }
        System.out.println("浓度为：" + d);
        System.out.println("数值范围：最小值 " + getMin(d) + " ,最大值 " + getMax(d));
        System.out.println("响应值分别：" +
                new BigDecimal(doubles[0]+"").toPlainString() + "\t" +
                new BigDecimal(doubles[1]+"").toPlainString() + "\t" +
                new BigDecimal(doubles[2]+"").toPlainString() + "\t" +
                new BigDecimal(doubles[3]+"").toPlainString() + "\t" +
                new BigDecimal(doubles[4]+"").toPlainString() + "\t" +
                new BigDecimal(doubles[5]+"").toPlainString() + "\t" +
                new BigDecimal(doubles[6]+"").toPlainString()

        );
        double avg = getAvg(doubles);
        System.out.println("平均值是为：" + new BigDecimal(avg).setScale(scale, 6).toPlainString());
        double error1 = getError1(doubles, avg);
        //System.out.println("方差为：" + error1);
        double error2 = getError2(error1);
        //System.out.println("标准差为：" + error2);
        System.out.println("相对偏差为：" + new BigDecimal(error2 * 100 / avg).setScale(2, 6).toPlainString() + "%");
        System.out.println("相对误差为：" + new BigDecimal(getError3(avg, d) * 100).setScale(2, 6).toPlainString() + "%");
    }

    static double getMax(double d) {
        return d * 1.1;
    }

    static double getMin(double d) {
        return d * 0.9;
    }

    static double getAvg(double[] ds) {
        double sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += ds[i];
        }
        return sum / 7;
    }

    static double getError1(double[] ds, double avg) {
        double sum = 0;
        for (int i = 0; i < ds.length; i++) {
            sum += Math.pow(ds[i] - avg, 2);
        }
        sum /= 6;
        return sum;
    }

    static double getError2(double e1) {
        return Math.sqrt(e1);
    }

    static double getError3(double avg, double stand) {
        return (avg - stand) / stand;
    }

}
