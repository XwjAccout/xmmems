package com.xmmems.forecast.utils.arima;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

/**
 * ARIMA的数学表达：
 * xt=μ+φ1?xt?1+...+φp?xt?p+θ1et?1?...?θqet?q
 *
 * 很明显哈，ARIMA的实质就是差分运算与ARMA模型的结合。其中，φ
 * φ是AR模型的参数，θ是MA模型的参数。
 */
public class ARIMAModel {
    double[] originalData = {};

    Vector<double[]> arimaCoe = new Vector<>();

    public ARIMAModel() {

    }

    public ARIMAModel(double[] originalData) {
        this.originalData = originalData;
    }

    /**
     * 一阶差分运算(1)
     *
     * @param preData 预数据
     * @return
     */
    public double[] preFirDiff(double[] preData) {
        double[] tmpData = new double[preData.length - 1];
        for (int i = 0; i < preData.length - 1; ++i) {
            tmpData[i] = preData[i + 1] - preData[i];
        }
        return tmpData;
    }

    /**
     * 七阶差分运算(7)//季节性差分(6, 7)
     *
     * @param preData 预数据  period 阶
     * @return
     */
    public double[] preSeasonDiff(double[] preData,int period) {
        double[] tmpData = new double[preData.length - period];
        for (int i = 0; i < preData.length - period; ++i) {
            tmpData[i] = preData[i + period] - preData[i];
        }
        return tmpData;
    }


    /**
     * period阶差分运算（period）
     *
     * @param preData 预数据
     * @param period  几阶
     * @return
     */
    public double[] prePeriodDiff(double[] preData, int period) {
        double[] tmpData = new double[preData.length - period];
        for (int i = 0; i < preData.length - period; ++i) {
            tmpData[i] = preData[i + period] - preData[i];
        }
        return tmpData;
    }

    /**
     * 获取差分平稳序列
     * @param period
     * @return
     */
    public double[] preDealDiff(int period) {
        if (period >= originalData.length - 1)        // 将6也归为季节性差分
        {
            period = 0;
        }
        switch (period) {
            case 0:
                return this.originalData;
            default:
                return preSeasonDiff(originalData,period);
        }
    }

    /**
     *
     * @param period
     * @param notModel
     * @param needNot
     * @return
     */
    public int[] getARIMAModel(int period, ArrayList<int[]> notModel, boolean needNot) {
        //差分平稳序列
        double[] data = this.preDealDiff(period);

        double minAIC = Double.MAX_VALUE;
        int[] bestModel = new int[3];
        int type = 0;
        Vector<double[]> coe = new Vector<>();

        // model产生, 即产生相应的p, q参数
        int len = data.length;
        if (len > 5) {
            len = 5;
        }
        int size = ((len + 2) * (len + 1)) / 2 - 1;
        int[][] model = new int[size][2];
        int cnt = 0;
        for (int i = 0; i <= len; ++i) {
            for (int j = 0; j <= len - i; ++j) {
                if (i == 0 && j == 0){
                    continue;
                }
                model[cnt][0] = i;
                model[cnt++][1] = j;
            }
        }

        for (int i = 0; i < model.length; ++i) {
            // 控制选择的参数
            boolean token = false;
            if (needNot) {
                for (int k = 0; k < notModel.size(); ++k) {
                    if (model[i][0] == notModel.get(k)[0] && model[i][1] == notModel.get(k)[1]) {
                        token = true;
                        break;
                    }
                }
            }
            if (token) {
                continue;
            }

            if (model[i][0] == 0) {
                MAModel ma = new MAModel(data, model[i][1]);
                coe = ma.solveCoeOfMA();
                type = 1;
            } else if (model[i][1] == 0) {
                ARModel ar = new ARModel(data, model[i][0]);
                coe = ar.solveCoeOfAR();
                type = 2;
            } else {
                ARMAModel arma = new ARMAModel(data, model[i][0], model[i][1]);
                coe = arma.solveCoeOfARMA();
                type = 3;
            }
            double aic = new ARMAMethod().getModelAIC(coe, data, type);
            // 在求解过程中如果阶数选取过长，可能会出现NAN或者无穷大的情况
            if (Double.isFinite(aic) && !Double.isNaN(aic) && aic < minAIC) {
                minAIC = aic;
                bestModel[0] = model[i][0];
                bestModel[1] = model[i][1];
                bestModel[2] = (int) Math.round(minAIC);
                this.arimaCoe = coe;
            }
        }
        return bestModel;
    }

    public double aftDeal(double predictValue, int period) {
        if (period >= originalData.length) {
            period = 0;
        }

        switch (period) {
            case 0:
                return  predictValue;
            default:
                return  (predictValue + originalData[originalData.length - period]);
        }
    }

    public double predictValue(int p, int q, int period) {
        double[] data = this.preDealDiff(period);
        int n = data.length;
        double predict = 0;
        double tmpAR = 0.0, tmpMA = 0.0;
        double[] errData = new double[q + 1];

        Random random = new Random();

        if (p == 0 && q != 0) {
            double[] maCoe = this.arimaCoe.get(0);
            for (int k = q; k < n; ++k) {
                tmpMA = 0;
                for (int i = 1; i <= q; ++i) {
                    tmpMA += maCoe[i] * errData[i];
                }
                //产生各个时刻的噪声
                for (int j = q; j > 0; --j) {
                    errData[j] = errData[j - 1];
                }
                errData[0] = random.nextGaussian() * Math.sqrt(maCoe[0]);
            }

            predict = tmpMA; //产生预测
        } else if (q == 0 && p != 0) {
            double[] arCoe = this.arimaCoe.get(0);

            for (int k = p; k < n; ++k) {
                tmpAR = 0;
                for (int i = 0; i < p; ++i) {
                    tmpAR += arCoe[i] * data[k - i - 1];
                }
            }
            predict = tmpAR;
        } else {
            double[] arCoe = this.arimaCoe.get(0);
            double[] maCoe = this.arimaCoe.get(1);

            for (int k = p; k < n; ++k) {
                tmpAR = 0;
                tmpMA = 0;
                for (int i = 0; i < p; ++i) {
                    tmpAR += arCoe[i] * data[k - i - 1];
                }
                for (int i = 1; i <= q; ++i) {
                    tmpMA += maCoe[i] * errData[i];
                }

                //产生各个时刻的噪声
                for (int j = q; j > 0; --j) {
                    errData[j] = errData[j - 1];
                }

                errData[0] = random.nextGaussian() * Math.sqrt(maCoe[0]);
            }

            predict =  tmpAR + tmpMA;
        }

        return predict;
    }
}
