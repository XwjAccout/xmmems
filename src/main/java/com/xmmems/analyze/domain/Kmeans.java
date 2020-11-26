package com.xmmems.analyze.domain;

import com.xmmems.common.exception.XMException;

import java.util.*;

public class Kmeans {


    //1、加载原始数据,加载数据库并进行预处理
    public List<List<Double>> loadAndPretreatment(List<Map<String, String>> itemValueMaps, List<List<Double>> valueLists) {

        if (itemValueMaps != null) {
            List<List<Double>> datal = new ArrayList<>();  //存储经过处理后的每一个样本的各个属性值和所属分类
            for (Map<String, String> itemValueMap : itemValueMaps) {
                List<Double> collect = new ArrayList<>();
                for (String s : itemValueMap.values()) {
                    Double aDouble = Double.valueOf(s);
                    collect.add(aDouble);
                }
                datal.add(collect);
            }
            return datal;//存储经过处理后的每一个样本的各个属性值和所属分类
        } else if (valueLists != null) {
            return valueLists;
        } else {
            throw new XMException(500, "聚类计算初始化出错");
        }
    }

    /**
     * 设置初始的聚类核心，a，b，c分别表示一个类的核心在data中的编号
     */
    public List<List<Double>> set_kernal(List<List<Double>> data, int k) {//设置初始的聚类核心 k 核心个数
        List<List<Double>> kernals = new ArrayList<>();

        if (data.size() <= k << 1) {
            throw new XMException(500, "数据个数太少，低于聚类核心个数的2倍，没必要聚类也无法聚类分析");
        }
        //Random random = new Random(k);  从 data 中随机选取 k 个不同的数据作为聚类核心最好，但是我这里用最中间的k个数据的规则选取核心
        int cen = (data.size() >> 1) - (k >> 1);
        //存储data的所有索引
        for (int i = 0; i < k; i++) {
            List<Double> src = data.get(cen + i);
            List<Double> dest = new ArrayList<Double>(src);
            dest.add(i + 0d);//添加类型
            kernals.add(dest);
        }
        return kernals;//存储每次迭代产生的聚类核心的每个属性值的均值
    }

    /**
     * 判断一个样本属于哪一个类，返回值1表示第一类，2表示第二类，3表示第三类
     */
    public static int choose(double[] data, double[] a, double[] b, double[] c) {//判断一个样本属于哪一个类，返回值1表示第一类，2表示第二类，3表示第三类
        double ta, tb, tc;
        //ta，tb，tc分别表示一个样本点到三个聚类核心的欧式距离的平方
        ta = (data[0] - a[0]) * (data[0] - a[0]) + (data[1] - a[1]) * (data[1] - a[1]) + (data[2] - a[2]) * (data[2] - a[2]) + (data[3] - a[3]) * (data[3] - a[3]);
        tb = (data[0] - b[0]) * (data[0] - b[0]) + (data[1] - b[1]) * (data[1] - b[1]) + (data[2] - b[2]) * (data[2] - b[2]) + (data[3] - b[3]) * (data[3] - b[3]);
        tc = (data[0] - c[0]) * (data[0] - c[0]) + (data[1] - c[1]) * (data[1] - c[1]) + (data[2] - c[2]) * (data[2] - c[2]) + (data[3] - c[3]) * (data[3] - c[3]);

        if (ta == Math.min(Math.min(ta, tb), tc))   //如果到第一类的距离最小返回1
            return 1;
        else if (tb == Math.min(Math.min(ta, tb), tc))//如果到第二类的距离最小返回2
            return 2;
        else if (tc == Math.min(Math.min(ta, tb), tc))//如果到第三类的距离最小返回3
            return 3;
        return 0;
    }

    private static void choose(List<Double> temp, List<List<Double>> kernals) {
        List<Double> distance = new ArrayList<>();

        for (int i = 0; i < kernals.size(); i++) {
            //一个聚合核心
            List<Double> kernal = kernals.get(i);
            //计算到聚合核心的距离
            double d = 0;
            for (int j = 0; j < kernal.size() - 1; j++) {
                Double k = kernal.get(j);
                Double aDouble = temp.get(j);

                d += (aDouble - k) * (aDouble - k);
            }
            distance.add(d);
        }

        Double min = Collections.min(distance);
        for (int i = 0; i < distance.size(); i++) {
            if (min == distance.get(i)) {
                //聚合类型的位置索引
                int index = kernals.get(i).size() - 1;
                Double type = kernals.get(i).get(index);
                try {
                    temp.set(index, type);//可能要换成set
                } catch (Exception e) {
                    temp.add(type);
                }
                return;
            }
        }

    }

    /**
     * 函数执行一次表示kmeans的一次迭代
     */
    public static List<List<Double>> onestep(List<List<Double>> data, List<List<Double>> kernal) {//函数执行一次表示kmeans的一次迭代
        List<List<Double>> newkernal = new ArrayList<>();//用于存放一次迭代后新的类的核心的各属性值
        int i = 0;
        List<Double> temp;

        while (i < data.size()) {//取出data中的每一个样本存放在temp中
            temp = data.get(i);
            choose(temp, kernal);//调用choose函数判断当前样本属于哪一个类
            i++;
        }

        Map<Double, List<Double>> map = new HashMap<>();
        Map<Double, Integer> mapnum = new HashMap<>();
        for (List<Double> datum : data) {
            //datum ： 一个历史数据
            //数据的聚类类型
            Double key = datum.get(datum.size() - 1);
            //处理数据，叠加总和
            List<Double> doubles = map.computeIfAbsent(key, k -> {
                ArrayList<Double> objects = new ArrayList<>();
                for (int z = 0; z < datum.size() - 1; z++) {
                    objects.add(0d);
                }
                return objects;
            });

            for (int j = 0; j < doubles.size(); j++) {
                Double d = datum.get(j);
                doubles.set(j, doubles.get(j) + d);
            }

            //处理数据，，同聚类类型加1
            Integer integer = mapnum.computeIfAbsent(key, k -> 0);
            mapnum.put(key, integer + 1);
        }

        //重新生成新的聚类核心集合
        for (Double key : map.keySet()) {
            //同类型的集合
            List<Double> value = map.get(key);
            //同类型有多少个
            Integer integer = mapnum.get(key);

            for (int j = 0; j < value.size(); j++) {
                value.set(j, value.get(j) / integer);
            }
            value.add(key);
        }

        for (Map.Entry<Double, List<Double>> entry : map.entrySet()) {
            newkernal.add(entry.getValue());
        }
        return newkernal;
    }

    /**
     * k_means算法的实现
     */
    public List<List<Double>> k_means(List<List<Double>> lists, List<List<Double>> setKernal) {
        while (true) {
            boolean con = true;
            List<List<Double>> t = onestep(lists, setKernal);//将 data和当前的init_kernal传入onestep函数进行一次迭代，返回值为迭代后的类的核心

            //判断本次迭代后返回的类的核心是不是和迭代之前的类的核心相同，如果不相同con被设为false，继续迭代。
            out:
            for (int i = 0; i < t.size(); i++) {
                List<Double> temp = t.get(i);
                for (int j = 0; j < temp.size() - 1; j++) {
                    if (!temp.get(j).equals(setKernal.get(i).get(j))) {
                        con = false;
                        break out;
                    }
                }
            }

            if (con) {//如果con为true说明本次迭代的核心和迭代之前的核心相同，说明聚类完成，退出循环
                return t;
            } else {
                setKernal = t;//如果本次迭代返回的新的核心和迭代之前的不同，则当前核心设置为返回的新的核心，继续循环迭代
            }
        }
    }

}