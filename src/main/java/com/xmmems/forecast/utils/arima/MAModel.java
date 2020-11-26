package com.xmmems.forecast.utils.arima;

import java.util.Vector;

public class MAModel {
    private double[] data;
    private int q;

    /**
     * MA模型构造函数
     * @param data 预数据
     * @param q 矩阵的值
     */
    public MAModel(double[] data, int q) {
        this.data = data;
        this.q = q;
    }

    public Vector<double[]> solveCoeOfMA() {
        Vector<double[]> vec = new Vector<>();
        double[] maCoe = new ARMAMethod().computeMACoe(this.data, this.q);

        vec.add(maCoe);

        return vec;
    }
}
