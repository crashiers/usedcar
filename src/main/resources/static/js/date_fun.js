/**
 * 获取本周、本季度、本月、上月的开始日期、结束日期
 */
var now = new Date(); //当前日期
var nowDayOfWeek = now.getDay()-1; //今天本周的第几天
var nowDay = now.getDate(); //当前日
var nowMonth = now.getMonth(); //当前月
var nowYear = now.getYear(); //当前年
nowYear += (nowYear < 2000) ? 1900 : 0; //
var lastMonthDate = new Date(); //上月日期
lastMonthDate.setDate(1);
lastMonthDate.setMonth(lastMonthDate.getMonth() - 1);
var lastYear = lastMonthDate.getYear();
var lastMonth = lastMonthDate.getMonth();
//格式化日期：yyyy-MM-dd
function formatDate(date) {
    var myyear = date.getFullYear();
    var mymonth = date.getMonth() + 1;
    var myweekday = date.getDate();
    if (mymonth < 10) {
        mymonth = "0" + mymonth;
    }
    if (myweekday < 10) {
        myweekday = "0" + myweekday;
    }
    return (myyear + "-" + mymonth + "-" + myweekday);
}

//格式化日期：yyyy-MM
function formatDateYM(date) {
    var myyear = date.getFullYear();
    var mymonth = date.getMonth() + 1;
    if (mymonth < 10) {
        mymonth = "0" + mymonth;
    }
    return (myyear + "-" + mymonth);
}

//获得某月的天数
function getMonthDays(myMonth) {
    var monthStartDate = new Date(nowYear, myMonth, 1);
    var monthEndDate = new Date(nowYear, myMonth + 1, 1);
    var days = (monthEndDate - monthStartDate) / (1000 * 60 * 60 * 24);
    return days;
}
//获得本季度的开始月份
function getQuarterStartMonth() {
    var quarterStartMonth = 0;
    if (nowMonth < 3) {
        quarterStartMonth = 0;
    }
    if (2 < nowMonth && nowMonth < 6) {
        quarterStartMonth = 3;
    }
    if (5 < nowMonth && nowMonth < 9) {
        quarterStartMonth = 6;
    }
    if (nowMonth > 8) {
        quarterStartMonth = 9;
    }
    return quarterStartMonth;
}
//获得本周的开始日期
function getWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
    return formatDate(weekStartDate);
}
//获得本周的结束日期
function getWeekEndDate() {
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
    return formatDate(weekEndDate);
}
//获得上周的开始日期
function getLastWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek - 7);
    return formatDate(weekStartDate);
}
//获得上周的结束日期
function getLastWeekEndDate() {
    var weekEndDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek - 1);
    return formatDate(weekEndDate);
}
//获得本月的开始日期
function getMonthStartDate() {
    var monthStartDate = new Date(nowYear, nowMonth, 1);
    return formatDate(monthStartDate);
}
//获得本月的结束日期
function getMonthEndDate() {
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));
    return formatDate(monthEndDate);
}
//获得上月开始时间
function getLastMonthStartDate() {
    var lastMonthStartDate = new Date(nowYear, lastMonth, 1);
    return formatDate(lastMonthStartDate);
}
//获得上月结束时间
function getLastMonthEndDate() {
    var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));
    return formatDate(lastMonthEndDate);
}
//获得本季度的开始日期
function getQuarterStartDate() {
    var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1);
    return formatDate(quarterStartDate);
}
//获得本季度的结束日期
function getQuarterEndDate() {
    var quarterEndMonth = getQuarterStartMonth() + 2;
    var quarterStartDate = new Date(nowYear, quarterEndMonth,
        getMonthDays(quarterEndMonth));
    return formatDate(quarterStartDate);
}

function getDate(strDate){
    if(strDate==null||strDate===undefined) return null;
    var date = new Date();
    try{
        if(strDate == undefined){
            date= null;
        }else if(typeof strDate == 'string'){
            strDate = strDate.replace(/:/g,'-');
            strDate = strDate.replace(/ /g,'-');
            var dtArr = strDate.split("-");
            if(dtArr.length>=2&&dtArr.length<6){
                date=new Date(dtArr[0], dtArr[1], "01");
            }else if(date.length>8){
                date=new Date(Date.UTC(dtArr[0],dtArr[1]-1,dtArr[2],dtArr[3]-8,dtArr[4],dtArr[5]));
            }
        }else{
            date = null;
        }
        return date;
    }catch(e){
        alert('格式化日期出现异常：' + e.message);
    }
}

// 当前年月
function getThisMonth(){
    var pre = new Date();
    return formatDateYM(pre);
}
// 一年前的年月
function getPreYearMonth(){
    var pre = new Date();
    pre.setFullYear(pre.getFullYear()-1);
    return formatDateYM(pre);
}