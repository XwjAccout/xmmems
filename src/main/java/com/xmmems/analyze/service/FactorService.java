package com.xmmems.analyze.service;

import Jama.Matrix;
import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

//因子分析
@Service
@Transactional
public class FactorService {

    @Autowired
    private AnalyzeService analyzeService;

    private static final com.fasterxml.jackson.core.type.TypeReference<List<List<List<Double>>>> type = new TypeReference<List<List<List<Double>>>>() {
    };

    public List<Map<String, Object>> factorCu(Integer siteId, Integer year, List<Integer> itemIds) {

        //Map<String, Object> reMap = new HashMap<>();

        Map<String, List<Object>> stringListMap = analyzeService.clusterGroupByMonth(siteId, year, itemIds,"因子分析");
        List<Object> itemNames = stringListMap.get("factor");
        List<Object> Odatas = stringListMap.get("data");
        List<List<List<Double>>> datas = JsonUtils.nativeRead(JsonUtils.toString(Odatas), type);
        List<List<Double>> all = new ArrayList<>();
        datas.forEach(all::addAll);

        double[][] doubles = new double[all.size()][all.get(0).size()];
        for (int j = 0; j < all.size(); j++) {
            List<Double> list = all.get(j);
            doubles[j] = list.stream().mapToDouble(dd -> dd).toArray();
        }

        //求均值
        //double[] average = getAverage(array);
        //print1(average, 5, "均值");
        // 计算方差
        double[] variance = getVariance(doubles);
        //print1(variance, 5, "方差");
        // 求标准差
        double[] sd = getStandardDevition(variance);
        //print1(sd, 5, "标准差");
        // 标准化数据
        //double[][] standard = getStandard(array, sd);
        //print2(standard, 5, "标准化后的矩阵");
        // 计算协方差矩阵--方阵
        double[][] covMatrix = getCovMatrix(doubles);
        //print2(covMatrix, 5, "协方差矩阵");
        // 计算相关矩阵---方阵
        double[][] correlationMatrix = getCorrelationMatrix(covMatrix, sd);
        //print2(correlationMatrix, 3, "相关矩阵");
        // 求矩阵特征值
        double[][] eigenvalue = getEigenvalue(correlationMatrix);
        //print2(eigenvalue, 5, "由特征值组成的对角矩阵");
        // 特征值从大到小排序并保存成键值对形式
        TreeMap<Integer, Double> map = getMap(eigenvalue);
        // 计算方差贡献率
        double[] contibutionRatio = getContibutionRatio(map);
        //print1(contibutionRatio, 5,"方差贡献率");
        // 计算方差累积贡献率
        double[] cumuContributionRatio = getCumuContributionRatio(contibutionRatio);
        //print1(cumuContributionRatio, 5, "方差累积贡献率");
        // 确定公共因子的个数
        int num = getNum(cumuContributionRatio);
        //System.out.println("公共因子个数：" + num);
        //reMap.put("num", num);
        // 求矩阵的特征向量
        double[][] eigenvector = getEigenvector(correlationMatrix);
        //print2(eigenvector, 5, "矩阵的特征向量");
        // 获取特征值对应的特征向量
        double[][] vVector = getVVector(map, eigenvector);
        //print2(vVector, 5, "特征值对应的特征向量");
        // 获取因子载荷矩阵
        double[][] matrixA = getMatrixA(map, vVector, num);
        //print2(matrixA, 3, "因子载荷矩阵:A");
        // 获取特殊因子矩阵
        double[][] matrixD = getMatrixD(map, vVector, num);
        //print2(matrixD, 4, "特殊因子矩阵:D");

        double[][] tempTemp = matrixA;
        for (int i = 1; i < 6; i++) {
            // 进行因子旋转--方差最大正交旋转
            double[][] varimax = getVarimax(tempTemp, num);
            //print2(varimax, 3, "因子旋转--方差最大正交旋转，第" + i + "次");

            //print1(contibutionRatio1, 5, "旋转后的方差贡献率");
            // 计算因子载荷的方差
            double a_var = getA_Var(varimax);
            //System.out.println("总方差:" + new BigDecimal(a_var + "").setScale(5, BigDecimal.ROUND_HALF_EVEN).toPlainString());
            tempTemp = varimax;
        }
        //print2(tempTemp, 3, "旋转");
        // 计算旋转后的方差贡献率
        double[] contibutionRatio1 = getContibutionRatio1(tempTemp);
       // print1(contibutionRatio1, 5, "因子贡献率");
       // reMap.put("percent", contibutionRatio1);
       // reMap.put("normal", matrixA);
       // reMap.put("rnomal", tempTemp);
        //double[][] score = getScore(correlationMatrix, tempTemp, standard);//
        //print2(score, 5, "因子得分");

        //计算因子综合得分
        //double[] scores = getScores(score, contibutionRatio1);

        List<Map<String, Object>> newList = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            Map<String, Object> newmap = new HashMap<>();
            newmap.put("factor", n + 1); // 因子i
            newmap.put("percent", new BigDecimal(contibutionRatio1[n]*100).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());
            for (int i = 0; i < itemNames.size(); i++) {
                newmap.put(itemNames.get(i) + "", new BigDecimal(tempTemp[i][n]).setScale(8, BigDecimal.ROUND_HALF_EVEN).toPlainString());
            }
            newList.add(newmap);
        }


        return newList;

    }

    // 从数据库中获取数据
    public static double[][] getHseData() {
        Random random = new Random();
        List<Double> list = new ArrayList<Double>() {{
            for (int i = 0; i < 100; i++) {
                add(random.nextInt(100) + 0.0);
            }
        }};
        double[][] result = new double[24][26];
        double[] temp = new double[24 * 26];


        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 26; j++) {
                result[i][j] = temp[26 * i + j];
            }
        }
        return result;
    }

    // 计算均值
    private static double[] getAverage(double[][] array) {
        int h = array.length; // 行号--h
        int l = array[0].length;// 列号--l
        double[] average = new double[l];// 每个变量的均值
        for (int i = 0; i < l; i++) {
            double temp = 0.0;
            for (int j = 0; j < h; j++) {
                temp += array[j][i];
            }
            average[i] = temp / h;
        }
        return average;
    }

    // 计算方差
    private static double[] getVariance(double[][] array) {
        int h = array.length; // 行号--h
        int l = array[0].length;// 列号--l
        double[] average = getAverage(array);
        double[] var = new double[l];

        for (int i = 0; i < l; i++) {
            double temp = 0.0;
            for (int j = 0; j < h; j++) {
                temp += Math.pow((array[j][i] - average[i]), 2);  // pow(double a, double b) a 的 b 次方
            }
            var[i] = temp / (h - 1);
        }
        return var;
    }

    // 计算标准差
    private static double[] getStandardDevition(double[] var) {
        double[] sd = new double[var.length];

        for (int i = 0; i < var.length; i++) {
            sd[i] = Math.sqrt(var[i]);  //求平方根
        }
        return sd;
    }

    // 标准化数据
    private static double[][] getStandard(double[][] array, double[] sd) {
        int h = array.length; // 行号--h
        int l = array[0].length;// 列号--l
        double[][] result = new double[h][l];// 标准化
        double[] average = getAverage(array);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                result[i][j] = (array[i][j] - average[j]) / sd[j];
            }
        }

        return result;
    }

    // 计算协方差矩阵--方阵
    private static double[][] getCovMatrix(double[][] array) {
        int h = array.length;
        int l = array[0].length;
        double[][] temp = new double[h][l];// 保存计算协方差的中间矩阵
        double[][] result = new double[l][l];
        double[] average = getAverage(array); // 求均值

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                temp[i][j] = array[i][j] - average[j];
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                double t = 0;
                for (int k = 0; k < h; k++) {
                    t += temp[k][i] * temp[k][j];
                }
                result[i][j] = t / (h - 1);
            }
        }
        return result;
    }

    // 计算相关矩阵---方阵
    private static double[][] getCorrelationMatrix(double[][] cov, double[] sd) {
        int l = cov.length;
        double[][] result = new double[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                result[i][j] = cov[i][j] / (sd[i] * sd[j]);
            }
        }

        return result;
    }

    // 求矩阵特征值
    private static double[][] getEigenvalue(double[][] array) {
        Matrix m = new Matrix(array);
        Matrix m1 = m.eig().getD(); // 由特征值组成的对角矩阵
        return m1.getArray();
    }

    // 求矩阵的特征向量
    private static double[][] getEigenvector(double[][] array) {
        Matrix m = new Matrix(array);
        Matrix m1 = m.eig().getV(); // 该矩阵的每一列对应的是一个单位正交特征向量
        return m1.getArray();
    }

    // 特征值从大到小排序并保存成键值对形式
    private static TreeMap<Integer, Double> getMap(double[][] array) {
        int h = array.length;
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<Integer, Double> sorted_map = new TreeMap<Integer, Double>(bvc);
        double[] temp = new double[h]; // 存储特征值
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (i == j) {
                    temp[i] = array[i][j];
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            map.put(i, temp[i]);
        }
        //System.out.println("\n排序前键值对：\n");
        //map.forEach((k, m) -> System.out.println(k + "=" + new BigDecimal(m + "").setScale(15, BigDecimal.ROUND_HALF_EVEN).toPlainString()));
        sorted_map.putAll(map);
        //System.out.println("\n排序后的键值对：\n");
        // sorted_map.forEach((k, m) -> System.out.println(k + "=" + new BigDecimal(m + "").setScale(15, BigDecimal.ROUND_HALF_EVEN).toPlainString()));

        return sorted_map;
    }

    // 计算方差贡献率
    private static double[] getContibutionRatio(TreeMap<Integer, Double> tm) {
        int h = tm.size();
        double[] percent = new double[h];
        int count = 0;

        for (Map.Entry<Integer, Double> entry : tm.entrySet()) {
            double value = entry.getValue();
            percent[count] = value / h;
            System.out.println("特征值：" + new BigDecimal(value + "").setScale(3, 6) + "   方差贡献率：" + new BigDecimal(percent[count] * 100).setScale(3, 6) + "%");
            //System.out.printf("\n键%d 对应的特征值 %.3f  所占的比例为  %.3f"+, keyt, value, percent[count]*100);
            count++;
        }
        return percent;
    }

    // 计算方差累积贡献率
    private static double[] getCumuContributionRatio(double[] array) {
        double[] result = new double[array.length];
        double temp = 0.0;
        for (int i = 0; i < array.length; i++) {
            temp += array[i];
            result[i] = temp;
            System.out.printf("累积贡献率：%.3f \n", result[i] * 100);
        }
        return result;
    }

    // 确定公共因子的个数
    private static int getNum(double[] array) {
        int number = 1;// 公因子个数
        for (double v : array) {
            if (v < 0.75) {
                number++;
            }
        }
        //System.out.println("\n公共因子个数：" + number);
        return number;
    }

    // 获取特征值对应的特征向量
    private static double[][] getVVector(TreeMap<Integer, Double> tm, double[][] array) {
        int h = array.length;
        double[][] result = new double[h][h];
        int[] temp = new int[h];
        int count = 0;
        for (Map.Entry<Integer, Double> entry : tm.entrySet()) {
            int key = entry.getKey();
            temp[count] = key;
            count++;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                result[i][j] = array[i][temp[j]];
            }
        }
        return result;
    }

    // 获取因子载荷矩阵
    private static double[][] getMatrixA(TreeMap<Integer, Double> tm, double[][] array, int num) {
        int h = array.length;
        double[][] A = new double[h][num];
        double[] temp = new double[h];
        int count = 0;
        for (Map.Entry<Integer, Double> entry : tm.entrySet()) {
            double value = entry.getValue();
            temp[count] = Math.sqrt(value);
            // System.out.printf("特征值开平方根：%.5f\n", temp[count]);
            count++;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < num; j++) {
                A[i][j] = temp[j] * array[i][j];
            }
        }
        return A;
    }

    // 获取特殊因子矩阵
    private static double[][] getMatrixD(TreeMap<Integer, Double> tm, double[][] array, int num) {
        int h = array.length;
        double[][] B = new double[h][h - num];
        double[][] C = new double[h][h];
        double[][] D = new double[h][h];
        double[] temp = new double[h];
        int count = 0;
        for (Map.Entry<Integer, Double> entry : tm.entrySet()) {
            double value = entry.getValue();
            temp[count] = Math.sqrt(value);
            count++;
        }
        for (int i = 0; i < h; i++) {
            for (int j = num; j < h; j++) {
                B[i][j - num] = temp[j] * array[i][j];
            }
        }
        Matrix m = new Matrix(B);
        Matrix m1 = m.times(m.transpose());
        C = m1.getArray();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (i == j)
                    D[i][j] = C[i][j];
            }
        }
        return D;
    }

    // 进行因子旋转--方差最大正交旋转
    private static double[][] getVarimax(double[][] array, int num) {
        int h = array.length;
        int l = array[0].length;
        double[] hi = new double[h]; // 变量共同度
        double[][] standardA = new double[h][l];//标准化处理因子载荷阵
        double[][] result = new double[h][l];// 旋转后的因子载荷矩阵
        double[] u = new double[h];
        double[] v = new double[h];
        double A = 0.0;
        double B = 0.0;
        double C = 0.0;
        double D = 0.0;
        double E = 0.0;
        //标准化处理A
        for (int i = 0; i < h; i++) {
            double temp = 0.0;
            for (int j = 0; j < l; j++) {
                temp += Math.pow(array[i][j], 2);
            }
            hi[i] = temp;
            //System.out.printf("变量共同度：%.5f\n", hi[i]);
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                standardA[i][j] = Math.pow(array[i][j], 2) / hi[i];
            }
        }

        double[][] P = new double[l][l]; // 构造正交矩阵
        Matrix m = new Matrix(standardA);
        for (int k = 0; k < num - 1; k++) {
            for (int p = k + 1; p < num; p++) {
                for (int i = 0; i < h; i++) {
                    u[i] = (Math.pow(array[i][k], 2) - Math.pow(array[i][p], 2)) / hi[i];
                }
                for (int i = 0; i < h; i++) {
                    v[i] = (2 * array[i][k] * array[i][p]) / hi[i];
                }
                for (int i = 0; i < h; i++) {
                    A += u[i];
                    B += v[i];
                    C += (u[i] * u[i]) - (v[i] * v[i]);
                    D += 2 * u[i] * v[i];
                }
                E = (Math.atan((D - (2 * A * B) / h) / (C - (A * A - B * B) / h))) / 4.0;
                //System.out.printf("\n旋转角度 E = %.5f\n", E);
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < l; j++) {
                        if (i == j)
                            P[i][j] = 1;
                        else
                            P[i][j] = 0;
                    }
                }
                double[][] T = P;
                T[k][k] = Math.cos(E);
                T[k][p] = -Math.sin(E);
                T[p][k] = Math.sin(E);
                T[p][p] = Math.cos(E);
                Matrix m1 = new Matrix(T);//正交矩阵
                m = m.times(m1);
            }
        }

        return m.getArray();// 旋转后的因子载荷矩阵
    }

    // 计算旋转后的方差贡献率
    private static double[] getContibutionRatio1(double[][] array) {
        int h = array.length;
        int l = array[0].length;
        double[] percent = new double[h];
        double sum = 0.0;
        for (int i = 0; i < l; i++) {
            double temp = 0.0;
            for (int j = 0; j < h; j++) {
                temp += Math.pow(array[j][i], 2);
            }
            percent[i] = temp / h;
            //System.out.printf("\n旋转后的方差贡献率--F["+(i+1)+"]: %.3f\n",percent[i]);
            sum += percent[i];
        }
        //System.out.printf("\n方差累积贡献率：:%.3f\n",sum);
        return percent;
    }

    // 计算因子载荷的方差
    private static double getA_Var(double[][] array) {
        int h = array.length;
        int l = array[0].length;
        double[] var = new double[l];// 每一列的方差
        double v = 0.0;// 总方差
        double[][] B = new double[h][l];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                B[i][j] = Math.pow(array[i][j], 2);
            }
        }
        double[] ad = getAverage(B);
        for (int i = 0; i < l; i++) {
            double temp = 0.0;
            for (int j = 0; j < h; j++) {
                temp += Math.pow(B[j][i] - ad[i], 2);
            }
            var[i] = temp / h;
            //System.out.printf("每一列的方差：%.5f\n", var[i]);
            v += var[i];
        }

        return v;
    }

    /**
     * @param R     相关系数矩阵  inverse 逆向
     * @param A     载荷矩阵
     * @param array 归一化数据
     * @return 因子得分
     */
    private static double[][] getScore(double[][] R, double[][] A, double[][] array) {
        Matrix m2 = (new Matrix(A).transpose()).times(new Matrix(R).inverse());//计算得分函数的系数
        //System.out.println("得分函数的系数");
        //m2.print(5, 0);

        Matrix m4 = m2.times(new Matrix(array).transpose());
        //System.out.println("因子得分：");
        //m4.transpose().print(5, 5);
        return m4.transpose().getArray();
    }

    //计算因子综合得分
    private static double[] getScores(double[][] array, double[] percent) {
        int h = array.length;
        int l = array[0].length;
        double[] result = new double[h];
        double temp = 0.0;

        for (int i = 0; i < l; i++) {
            temp += percent[i];
        }
        for (int i = 0; i < h; i++) {
            double t = 0.0;
            for (int j = 0; j < l; j++) {
                t += array[i][j] * percent[j];
            }
            result[i] = t / temp;
            //System.out.printf("综合得分：%.3f\n", result[i]);
        }
        return result;
    }

    private static void print2(double[][] d, int scale, String msg) {
        System.out.println("------" + msg + "-----");
        Matrix matrix = new Matrix(d);
        matrix.print(6, scale);
        System.out.println("--------------------------------");
        System.out.println();
    }

    private static void print1(double[] d, int scale, String msg) {
        System.err.println("-----" + msg + "-----");
        for (int i = 0; i < d.length; i++) {
            System.out.print(format(d[i], scale) + "\t");
        }
        System.out.println();
        System.out.println("--------------------------------");
    }

    private static String format(Object d, int scale) {
        return new BigDecimal(d + "").setScale(scale, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
    }

    private static double formatToDouble(double d, int scale) {
        return new BigDecimal(d + "").setScale(scale, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().doubleValue();
    }
}

// map按值进行排序
class ValueComparator implements Comparator<Integer> {

    private Map<Integer, Double> base;

    public ValueComparator(Map<Integer, Double> base) {
        this.base = base;
    }

    public int compare(Integer a, Integer b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
