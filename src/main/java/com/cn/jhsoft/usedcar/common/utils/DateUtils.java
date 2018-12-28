package com.cn.jhsoft.usedcar.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 日期处理
 * 
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 中文简写  如：2010年12月01日
     */
    public static String FORMAT_SHORT_CN = "yyyy年M月d日";

    /**
     * 中文全称  如：2010年12月01日  23时15分06秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    public static Calendar calendar;


    //用来全局控制 上一周，本周，下一周的周数变化
    private  int weeks = 0;
    private int MaxDate;//一月最大天数
    private int MaxYear;//一年最大天数
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String formatFull(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static Date getDate(int amount){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, amount);
        return cal.getTime();
    }

    /**
     * 获取两个日期相差的天数
     * @param date1
     * @param date2
     * @return
     */
    public static long getDaysByTwoDate(String date1, String date2) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date startDate = sdf.parse( date1 );
        Date endDate = sdf.parse( date2 );
        long diff = endDate.getTime() - startDate.getTime();//这样得到的差值是微秒级别
        return diff / (1000 * 60 * 60 * 24);
    }

    /**
     * 在指定日期上加减一定的天数
     * @param date
     * @param amount
     * @return
     */
    public static Date getDate(String date, int amount){
        Calendar cal = Calendar.getInstance();
        int year = Integer.valueOf(date.split("-")[0]);
        int month = Integer.valueOf(date.split("-")[1]);
        int day = Integer.valueOf(date.split("-")[2]);
        cal.set(year, month-1, day);
        cal.add(Calendar.DATE, amount);
        return cal.getTime();
    }

    public static Date getDateFrom1900(int amount){
        Calendar calendar = new GregorianCalendar(1900,0,-1);
        calendar.add(Calendar.DATE, amount);
        return calendar.getTime();
    }

    public static String getTodayDate(){
        return format(new Date(), DateUtils.DATE_PATTERN);
    }

    public static String getTodayDateYMD(){
        return format(new Date(), DateUtils.DATE_TIME_PATTERN);
    }

    public static String getTodayDateYMDHMS(){
        return format(new Date(), DateUtils.DATE_TIME_PATTERN);
    }

    public static String getYesterdayDate(){
        return format(getDate(-1), DateUtils.DATE_PATTERN);
    }

    public static long getYesterdayTime() {
        Date date = getDate(-1);
        return date.getTime();
    }

    public static long getTodayTime() {
        Date date = new Date();
        return date.getTime();
    }

    /**
     * 获取时间戳
     */
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }


    /**
     * 获取时间戳
     */
    public static long getTimeStamp() {
        Date df = new Date();
        return df.getTime() / 1000;
    }

    /**
     * 获取日期年份
     * @param date 日期
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 功能描述：返回月
     *
     * @param date
     *            Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     *
     * @param date
     *            Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 根据时间戳获取日期
     * @param time
     * @return
     */
    public static Date getDate(Long time){
        SimpleDateFormat format =  new SimpleDateFormat(DATE_TIME_PATTERN);
        String d = format.format(time);
        try {
            return format.parse(d);
        }catch (Exception e){

        }
        return new Date();
    }

    /**
     * 功能描述：返回分
     *
     * @param date
     *            日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date
     *            Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date
     *            日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }




    /**
     * 根据一个日期，返回是一年中的第几周
     *
     * @param sdate
     * @return
     */
    public static int getWeekOfYear(String sdate) throws ParseException {
        // 再转换为时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(sdate);

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int mouth = calendar.get(Calendar.MONTH);
        // JDK think 2015-12-31 as 2016 1th week
        //如果月份是12月，且求出来的周数是第一周，说明该日期实质上是这一年的第53周，也是下一年的第一周
        if (mouth >= 11 && week <= 1) {
            week += 52;
        }
        return week;
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String getTimeStamp2Date(String seconds) {
        return getTimeStamp2Date(seconds, DATE_PATTERN);
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串zz
     * @param format
     * @return
     */
    public static String getTimeStamp2Date(String seconds, String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (seconds.length() == 10){
            seconds += "000";
        }
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @return
     */
    public static String getTimeStampByDate(String date_str){
        return getTimeStampByDate(date_str, DATE_PATTERN);
    }

    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getTimeStampByDate(String date_str, String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }




    /**
     * 根据一个日期，返回 "年周" 格式，并且周用 0补全两位数
     *
     * @param sdate
     * @return
     */
    public static String getWeekOfYearStr(String sdate) throws ParseException {
        int week = getWeekOfYear(sdate);
        String year = sdate.substring(0, 4);
        return year+String.format("%02d", week);
    }



    /**
     * 根据起始日期和结束日期所在的周，补全中间所空的所有 “年-周” 这种模式
     * @param startDate
     * @param endDate
     * @return
     */
    public static Set<String> getAllWeekByStartDateAndEndDate(String startDate, String endDate) throws ParseException {
        int startYear = Integer.parseInt(startDate.substring(0, 4));
        int endYear = Integer.parseInt(endDate.substring(0, 4));
        int startWeek = DateUtils.getWeekOfYear(startDate);
        int endWeek = DateUtils.getWeekOfYear(endDate);

        Set<String> weeks = new LinkedHashSet<>();
        // 临时存放结束周
        int tmpEndWeek = 0;

        // 全量年和周
        for (int i = startYear; i<= endYear; i++){
            // 初始时临时周为真正结束的周
            tmpEndWeek = endWeek;
            // 当前循环的还不是结束年，结束周要变为当前年的最后一周
            if (i != endYear){
                tmpEndWeek = DateUtils.getWeekOfYear(i+"-12-31");
            }
            // 对周的遍历
            for(int j = startWeek; j<=tmpEndWeek; j++){
                weeks.add(i + "-" + j);
            }
            // 当年的周遍历完成，进入下一年之前，把开始周设为第一周
            if (i != endYear){
                startWeek = 1;
            }
        }
        return weeks;
    }



    /**
     * 根据起始日期和结束日期所在的年月，补全中间所空的所有 “年-月” 这种模式
     * @param startDate
     * @param endDate
     * @return
     */
    public static Set<String> getAllMonthByStartDateAndEndDate(String startDate, String endDate) throws ParseException {
        int startYear = Integer.parseInt(startDate.substring(0, 4));
        int endYear = Integer.parseInt(endDate.substring(0, 4));
        int startMonth = Integer.parseInt(startDate.substring(5, 7));
        int endMonth = Integer.parseInt(endDate.substring(5, 7));

        Set<String> months = new LinkedHashSet<>();
        // 临时存放结束月
        int tmpEndMonth = 0;

        // 全量年和月
        for (int i = startYear; i<= endYear; i++){
            // 初始时临时月为真正结束的月
            tmpEndMonth = endMonth;

            // 当前循环的还不是结束年，结束月要变为当前年的最后一月
            if (i != endYear){
                tmpEndMonth = 12;
            }

            // 对月的遍历
            for(int j = startMonth; j<=tmpEndMonth; j++){
                months.add(i + "-" + j);
            }
            // 当年的月遍历完成，进入下一年之前，把开始月设为第一月
            if (i != endYear){
                startMonth = 1;
            }
        }
        return months;
    }




    // -----------------------------------------------------------------------------------------------------------------
    // ----------------------------------------工具类方法 ------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    public void test(){
        DateUtils tt = new DateUtils();
        System.out.println("获取当天日期:"+tt.getNowTime("yyyy-MM-dd"));
        System.out.println("获取本周一日期:"+tt.getMondayOFWeek());
        System.out.println("获取本周日的日期~:"+tt.getCurrentWeekday());
        System.out.println("获取上周一日期:"+tt.getPreviousWeekday());
        System.out.println("获取上周日日期:"+tt.getPreviousWeekSunday());
        System.out.println("获取下周一日期:"+tt.getNextMonday());
        System.out.println("获取下周日日期:"+tt.getNextSunday());
        System.out.println("获得相应周的周六的日期:"+tt.getNowTime("yyyy-MM-dd"));
        System.out.println("获取本月第一天日期:"+tt.getFirstDayOfMonth());
        System.out.println("获取本月最后一天日期:"+tt.getDefaultDay());
        System.out.println("获取上月第一天日期:"+tt.getPreviousMonthFirst());
        System.out.println("获取上月最后一天的日期:"+tt.getPreviousMonthEnd());
        System.out.println("获取下月第一天日期:"+tt.getNextMonthFirst());
        System.out.println("获取下月最后一天日期:"+tt.getNextMonthEnd());
        System.out.println("获取本年的第一天日期:"+tt.getCurrentYearFirst());
        System.out.println("获取本年最后一天日期:"+tt.getCurrentYearEnd());
        System.out.println("获取去年的第一天日期:"+tt.getPreviousYearFirst());
        System.out.println("获取去年的最后一天日期:"+tt.getPreviousYearEnd());
        System.out.println("获取明年第一天日期:"+tt.getNextYearFirst());
        System.out.println("获取明年最后一天日期:"+tt.getNextYearEnd());
        System.out.println("获取本季度第一天到最后一天:"+tt.getThisSeasonTime(11));
        System.out.println("获取两个日期之间间隔天数2008-12-1~2008-9.29:"+DateUtils.getTwoDay("2008-12-1","2008-9-29"));
    }

    /**
     * 得到二个日期间的间隔天数
     */
    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            java.util.Date date = myFormatter.parse(sj1);
            java.util.Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }


    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = DateUtils.strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 两个时间之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        java.util.Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }




    // 计算当月最后一天,返回字符串
    public String getDefaultDay(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE,1);//设为当前月的1号
        lastDate.add(Calendar.MONTH,1);//加一个月，变为下月的1号
        lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

        str=sdf.format(lastDate.getTime());
        return str;
    }

    // 上月第一天
    public String getPreviousMonthFirst(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE,1);//设为当前月的1号
        lastDate.add(Calendar.MONTH,-1);//减一个月，变为下月的1号
        //lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

        str=sdf.format(lastDate.getTime());
        return str;
    }

    //获取当月第一天
    public String getFirstDayOfMonth(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE,1);//设为当前月的1号
        str=sdf.format(lastDate.getTime());
        return str;
    }

    // 获得本周星期日的日期
    public String getCurrentWeekday() {
        weeks = 0;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus+7);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }


    //获取当天时间
    public String getNowTime(String dateformat){
        Date   now   =   new   Date();
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat(dateformat);//可以方便地修改日期格式
        String  hehe  = dateFormat.format(now);
        return hehe;
    }

    // 获得当前日期与本周日相差的天数
    private int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK)-1;         //因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    //获得本周一的日期
    public String getMondayOFWeek(){
        weeks = 0;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = format(monday);
        return preMonday;
    }

    //获得相应周的周六的日期
    public String getSaturday() {
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = format(monday);
        return preMonday;
    }

    // 获得上周星期日的日期
    public String getPreviousWeekSunday() {
        weeks=0;
        weeks--;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus+weeks);
        Date monday = currentDate.getTime();
        return format(monday);
    }

    // 获得上周星期一的日期
    public String getPreviousWeekday() {
        weeks=0;
        weeks--;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        return format(monday);
    }

    // 获得下周星期一的日期
    public String getNextMonday() {
        weeks++;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得下周星期日的日期
    public String getNextSunday() {

        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7+6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }



    private int getMonthPlus(){
        Calendar cd = Calendar.getInstance();
        int monthOfNumber = cd.get(Calendar.DAY_OF_MONTH);
        cd.set(Calendar.DATE, 1);//把日期设置为当月第一天
        cd.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        MaxDate=cd.get(Calendar.DATE);
        if(monthOfNumber == 1){
            return -MaxDate;
        }else{
            return 1-monthOfNumber;
        }
    }

    //获得上月最后一天的日期
    public String getPreviousMonthEnd(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH,-1);//减一个月
        lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);//日期回滚一天，也就是本月最后一天
        str=sdf.format(lastDate.getTime());
        return str;
    }

    //获得下个月第一天的日期
    public String getNextMonthFirst(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH,1);//减一个月
        lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天
        str=sdf.format(lastDate.getTime());
        return str;
    }

    //获得下个月最后一天的日期
    public String getNextMonthEnd(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH,1);//加一个月
        lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);//日期回滚一天，也就是本月最后一天
        str=sdf.format(lastDate.getTime());
        return str;
    }

    //获得明年最后一天的日期
    public String getNextYearEnd(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.YEAR,1);//加一个年
        lastDate.set(Calendar.DAY_OF_YEAR, 1);
        lastDate.roll(Calendar.DAY_OF_YEAR, -1);
        str=sdf.format(lastDate.getTime());
        return str;
    }

    //获得明年第一天的日期
    public String getNextYearFirst(){
        String str = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.YEAR,1);//加一个年
        lastDate.set(Calendar.DAY_OF_YEAR, 1);
        str=sdf.format(lastDate.getTime());
        return str;

    }

    //获得本年有多少天
    private int getMaxYear(){
        Calendar cd = Calendar.getInstance();
        cd.set(Calendar.DAY_OF_YEAR,1);//把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR,-1);//把日期回滚一天。
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        return MaxYear;
    }

    private int getYearPlus(){
        Calendar cd = Calendar.getInstance();
        int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);//获得当天是一年中的第几天
        cd.set(Calendar.DAY_OF_YEAR,1);//把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR,-1);//把日期回滚一天。
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        if(yearOfNumber == 1){
            return -MaxYear;
        }else{
            return 1-yearOfNumber;
        }
    }
    //获得本年第一天的日期
    public String getCurrentYearFirst(){
        int yearPlus = this.getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE,yearPlus);
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        return preYearDay;
    }


    //获得本年最后一天的日期 *
    public String getCurrentYearEnd(){
        Date date = new Date();
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式
        String  years  = dateFormat.format(date);
        return years+"-12-31";
    }


    //获得上年第一天的日期 *
    public String getPreviousYearFirst(){
        Date date = new Date();
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式
        String  years  = dateFormat.format(date); int years_value = Integer.parseInt(years);
        years_value--;
        return years_value+"-1-1";
    }

    //获得上年最后一天的日期
    public String getPreviousYearEnd(){
        weeks--;
        int yearPlus = this.getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE,yearPlus+MaxYear*weeks+(MaxYear-1));
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        getThisSeasonTime(11);
        return preYearDay;
    }

    //获得本季度
    public String getThisSeasonTime(int month){
        int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int season = 1;
        if(month>=1&&month<=3){
            season = 1;
        }
        if(month>=4&&month<=6){
            season = 2;
        }
        if(month>=7&&month<=9){
            season = 3;
        }
        if(month>=10&&month<=12){
            season = 4;
        }
        int start_month = array[season-1][0];
        int end_month = array[season-1][2];

        Date date = new Date();
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式
        String  years  = dateFormat.format(date);
        int years_value = Integer.parseInt(years);

        int start_days =1;//years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
        int end_days = getLastDayOfMonth(years_value,end_month);
        String seasonDate = years_value+"-"+start_month+"-"+start_days+";"+years_value+"-"+end_month+"-"+end_days;
        return seasonDate;

    }

    /**
     * 获取某年某月的最后一天
     * @param year 年
     * @param month 月
     * @return 最后一天
     */
    private int getLastDayOfMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
                || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        return 0;
    }
    /**
     * 是否闰年
     * @param year 年
     * @return
     */
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
