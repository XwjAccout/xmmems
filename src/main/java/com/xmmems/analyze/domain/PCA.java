package com.xmmems.analyze.domain;

import Jama.Matrix;

import java.util.*;
import java.util.Map.Entry;

/*
 * 算法步骤:
 * 1)将原始数据按列组成n行m列矩阵X
 * 2)特征中心化。即每一维的数据都减去该维的均值，使每一维的均值都为0
 * 3)求出协方差矩阵
 * 4)求出协方差矩阵的特征值及对应的特征向量
 * 5)将特征向量按对应的特征值大小从上往下按行排列成矩阵，取前k行组成矩阵p
 * 6)Y=PX 即为降维到k维后的数据
 */
public class PCA {

    private static final double threshold = 0.99;// 特征值阈值

    /**
     * 使每个样本的均值为0
     *
     * @param primary 原始二维数组矩阵
     * @return averageArray 中心化后的矩阵
     */
    public static double[][] changeAverageToZero(double[][] primary) {
        int n = primary.length;
        int m = primary[0].length;
        double[] sum = new double[m];
        double[] average = new double[m];
        double[][] averageArray = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += primary[j][i];
            }
            average[i] = sum[i] / n;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                averageArray[j][i] = primary[j][i] - average[i];
            }
        }
        return averageArray;
    }

    /**
     * 计算协方差矩阵
     *
     * @param matrix 中心化后的矩阵
     * @return result 协方差矩阵
     */
    public static double[][] getVarianceMatrix(double[][] matrix) {
        int n = matrix.length;// 行数
        int m = matrix[0].length;// 列数
        double[][] result = new double[m][m];// 协方差矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                double temp = 0;
                for (int k = 0; k < n; k++) {
                    temp += matrix[k][i] * matrix[k][j];
                }
                result[i][j] = temp / (n - 1);
            }
        }
        return result;
    }

    /**
     * 求特征值矩阵
     *
     * @param matrix 协方差矩阵
     * @return result 向量的特征值二维数组矩阵
     */
    public static double[][] getEigenvalueMatrix(double[][] matrix) {
        Matrix A = new Matrix(matrix);
        // 由特征值组成的对角矩阵,eig()获取特征值
//      A.eig().getD().print(10, 6);
        return A.eig().getD().getArray();
    }

    /**
     * 标准化矩阵（特征向量矩阵）
     *
     * @param matrix 特征值矩阵
     * @return result 标准化后的二维数组矩阵
     */
    public static double[][] getEigenVectorMatrix(double[][] matrix) {
        Matrix A = new Matrix(matrix);
//      A.eig().getV().print(6, 2);
        return A.eig().getV().getArray();
    }

    /**
     * 得到主成分
     *
     * @param eigenvalue   特征值二维数组矩阵
     * @param eigenVectors 特征向量二维数组矩阵
     * @return principalMatrix 主成分矩阵
     */
    public static Matrix getPrincipalComponent(double[][] eigenvalue, double[][] eigenVectors) {
        Matrix A = new Matrix(eigenVectors);// 定义一个特征向量矩阵
        double[][] tEigenVectors = A.transpose().getArray();// 特征向量转置
        Map<Integer, double[]> principalMap = new HashMap<>();// key=主成分特征值，value=该特征值对应的特征向量
        TreeMap<Double, double[]> eigenMap = new TreeMap<>(Collections.reverseOrder());// key=特征值，value=对应的特征向量；初始化为翻转排序，使map按key值降序排列
        double total = 0;// 存储特征值总和
        int index = 0, n = eigenvalue.length;
        double[] eigenvalueArray = new double[n];// 把特征值矩阵对角线上的元素放到数组eigenvalueArray里，得到的才是真正的特征值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    eigenvalueArray[index] = eigenvalue[i][j];
                }
            }
            index++;
        }

        for (int i = 0; i < tEigenVectors.length; i++) {
            double[] value = tEigenVectors[i];
            eigenMap.put(eigenvalueArray[i], value);
        }

       /* eigenMap.forEach((k, v) -> {
            System.out.print("特征值：" + new BigDecimal(k + "").setScale(8, BigDecimal.ROUND_HALF_EVEN).toPlainString());
            System.out.println("特征向量：");
            for (double v1 : v) {
                System.out.print("   "+new BigDecimal(v1 + "").setScale(8, BigDecimal.ROUND_HALF_EVEN).toPlainString());
            }
            System.out.println();
        });*/

        // 求特征总和
        for (int i = 0; i < n; i++) {
            total += eigenvalueArray[i];
            //System.out.println(new BigDecimal(eigenvalueArray[i]+"").toPlainString());
        }
        // 选出前几个主成分
        double temp = 0;
        int principalComponentNum = 0;// 主成分数
        List<Double> plist = new ArrayList<>();// 主成分特征值
        for (double key : eigenMap.keySet()) {
            if (temp / total <= threshold) {
                temp += key;
                plist.add(key);
                principalComponentNum++;
            }
        }
        //System.out.println("\n" + "当前阈值: " + threshold);
        //System.out.println("取得的主成分数: " + principalComponentNum + "\n");

        // 往主成分map里输入数据
        for (int i = 0; i < plist.size(); i++) {
            if (eigenMap.containsKey(plist.get(i))) {
                principalMap.put(i, eigenMap.get(plist.get(i)));
            }
        }

        // 把map里的值存到二维数组里
        double[][] principalArray = new double[principalMap.size()][];
        Iterator<Entry<Integer, double[]>> it = principalMap.entrySet().iterator();
        for (int i = 0; it.hasNext(); i++) {
            principalArray[i] = it.next().getValue();
        }
        return new Matrix(principalArray);
    }

    /**
     * 矩阵相乘
     *
     * @param averageArray 归一化数组
     * @param matrix  主成分矩阵
     * @return result 结果矩阵
     */
    public static Matrix getResult(double[][] averageArray, Matrix matrix) {
        Matrix primaryMatrix = new Matrix(averageArray);
        return primaryMatrix.times(matrix.transpose());
    }
}