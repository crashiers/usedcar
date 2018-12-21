package com.cn.jhsoft.usedcar.common.utils;

/**
 * Created by chenyi9 on 2018/5/28.
 */
public class StringUtils {


    /**
     * 删除一字符串 最后指定的字符
     * @param paramsStr
     * @return
     */
    public static StringBuilder rTrim(StringBuilder paramsStr, String c){
        if (paramsStr.length() == 0){
            return paramsStr;
        }
        if (paramsStr.toString().substring(paramsStr.toString().length() - c.length()).equals(c)){
            paramsStr.deleteCharAt(paramsStr.toString().length() - c.length());
        }
        return paramsStr;
    }

    /**
     * 删除一字符串 最后指定的字符
     * @param paramsStr
     * @param c
     * @return
     */
    public static String rTrim(String paramsStr, String c){
        if (paramsStr.length() == 0){
            return paramsStr;
        }
        if (paramsStr.substring(paramsStr.length() - c.length()).equals(c)){
            return paramsStr.substring(0, paramsStr.length() - c.length());
        }
        return paramsStr;
    }

}
