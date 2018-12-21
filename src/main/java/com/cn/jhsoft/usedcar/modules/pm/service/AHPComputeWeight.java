package com.cn.jhsoft.usedcar.modules.pm.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyongdong on 2018/5/3.
 */
public class AHPComputeWeight {
    // 平均随机一致性指针
    private double[] RI = {0.00, 0.00, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49};

    // 随机一致性比率
    private double CR = 0.0;

    private double CI;

    // 最大特征值
    private double lamta = 0.0;

    private double[] weight;
    private double[] w0;
    private double[] w1;
    private double[] w2;
    private Double[][] a;
    private int scale;

    public AHPComputeWeight(Double[][] a, int scale) {
        this.a = a;
        this.scale = scale;
    }

    public void getWeight() {
        int N = a[0].length;
        weight = new double[N];
        // 初始向量Wk
        w0 = new double[N];
        for (int i = 0; i < N; i++) {
            w0[i] = 1.0 / N;
        }

        // 一般向量W（k+1）
        w1 = new double[N];

        // W（k+1）的归一化向量
        w2 = new double[N];

        double sum = 1.0;
        double d = 1.0;

        // 误差
        double delt = 0.00001;
        while (d > delt) {
            d = 0.0;
            sum = 0;
            // 获取向量
            for (int j = 0; j < N; j++) {
                double t = 0.0;
                for (int l = 0; l < N; l++) {
                    t += a[j][l] * w0[l];
                }
                w1[j] = t;
                sum += w1[j];
            }

            // 向量归一化
            for (int k = 0; k < N; k++) {
                w2[k] = w1[k] / sum;

                // 最大差值
                d = Math.max(Math.abs(w2[k] - w0[k]), d);

                // 用于下次迭代使用
                w0[k] = w2[k];
            }
        }

        // 计算矩阵最大特征值lamta，CI，RI
        lamta = 0.0;
        for (int k = 0; k < N; k++) {
            lamta += w1[k] / (N * w0[k]);
        }

        CI = (lamta - N) / (N - 1);

        if (RI[N - 1] != 0) {
            CR = CI / RI[N - 1];
        }

        // 四舍五入处理
        lamta = round(lamta, scale);
        CI = Math.abs(round(CI, scale));
        CR =  Math.abs(round(CR, scale));
        for (int i = 0; i < N; i++) {
            w0[i] = round(w0[i], scale);
            w1[i] = round(w1[i], scale);
            w2[i] = round(w2[i], scale);
        }

        for (int i = 0; i < N; i++) {
            weight[i] = w2[i];
        }
    }

    private double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public Map<String, Object> calculate() {
        getWeight();
        Map<String, Object> result = new HashMap<String, Object>(4);
        result.put("lamta", lamta);
        result.put("CI", CI);
        result.put("CR", CR);
        result.put("weight", weight);
        return result;
    }
}
