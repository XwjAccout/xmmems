package com.xmmems.forecast.utils.arima;

import java.util.Vector;

public class ARModel {
    private double[] data;
    private int p;

    /**
     * AR模型构造函数
     * @param data 预数据
     * @param p 矩阵的值
     */
    public ARModel(double[] data, int p) {
        this.data = data;
        this.p = p;
    }

    /**
     *
     * @return
     */
    public Vector<double[]> solveCoeOfAR() {
        Vector<double[]> vec = new Vector<>();
        double[] arCoe = new ARMAMethod().computeARCoe(this.data, this.p);

        vec.add(arCoe);

        return vec;
    }
}
