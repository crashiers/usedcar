package com.cn.jhsoft.usedcar.common.utils;

/**
 * Redis所有Keys
 *
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {
    public static final String DEVICE_KEY = "device_";
    public static final String LOG_HOUR = "log_hour_";
    public static final String PAGE_KEY = "page_";
    public static final String USER_KEY = "user_";
    public static final String HR_DELETE_ROLE_KEY = "hr_delete_rote";
    public static final String PRODUCT360_TEMPERATURE = "temperature_";
    public static final String SING_SYSTEM_ALL = "sign_system_all";
    public static final String SING_SYSTEM_ALL_AMOUNT = "sign_system_all_amount";

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    /**
     * 取 实时计算的 每小时日志的key
     * @param hour
     * @return
     */
    public static String getLogHourKey(int hour){
        return getLogHourKey(hour, DateUtils.getTodayDate());
    }
    public static String getLogHourKey(int hour, String date){
        return LOG_HOUR + date + "_" + hour;
    }
}
