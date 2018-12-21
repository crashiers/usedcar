package com.cn.jhsoft.usedcar.common.utils;

import java.net.URLDecoder;

/**
 * Created by chenyi9 on 2017/10/16.
 */
public class EncodeUtils {

    /**
     * 16进制的中文字符串 转为 中文
     * @param hex16String 16进制的中文字符串
     * @return 中文
     * @throws Exception
     */
    public static String Hex16toChineseString(String hex16String) throws Exception {
        hex16String = hex16String.replace("\\x", "%");
        return URLDecoder.decode(hex16String,"utf-8");
    }

}
