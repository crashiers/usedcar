package com.cn.jhsoft.usedcar.common.utils;

import java.math.BigDecimal;

/**
 * 帮助类
 * Created by chenyi9 on 2018/4/16.
 */
public class HelpUtils {

    /**
     * 四舍五入保留两位小数
     * @param f
     * @return
     */
    public static Float mathRound(Float f){
        return mathRound(f, 2);
    }


    public static Float mathRound(Float f, int scale) {
        if (f == null){
            return 0F;
        }

        float s = f;
        s = new BigDecimal(s).setScale(scale, BigDecimal.ROUND_HALF_UP).floatValue();
        if (Math.round(s) - s == 0) {
            s = Math.round(s);
        }
        return s;
    }

}
