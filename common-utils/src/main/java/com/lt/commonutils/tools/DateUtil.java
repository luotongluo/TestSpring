package com.lt.commonutils.tools;


import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: DateUtil
 * @Package:
 * @Description: 时间转换
 * @author:
 * @date: 2019/1/15 10:35
 * @version: V1.0
 */
public class DateUtil {

    public static final String formatDefaultTimestamp = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";

    private static String patternUse = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";

    /**
     * 功能：判断字符串是否为日期格式
     *
     * @param strDate
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile(patternUse);
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将相应格式的时间字符串转成DATE
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date, String formatType) {
        SimpleDateFormat f = new SimpleDateFormat(formatType);
        Date innerDate;
        try {
            innerDate = f.parse(date);
        } catch (ParseException e) {
            innerDate = new Date();
            e.printStackTrace();
        }
        return innerDate;
    }

    /**
     * 获取相应格式的当前时间
     * 不传参数，使用默认格式
     *
     * @param formatType
     * @return
     */
    public static String getCurrentFormatDate(String formatType) {
        if (StringUtils.isEmpty(formatType)) {
            formatType = formatDefaultTimestamp;
        }
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        SimpleDateFormat dateStyle = new SimpleDateFormat(formatType, locale);
        return dateStyle.format(new Date());
    }

    /**
     * 把日期时间格式化为指定格式，如：yyyy-MM-dd HH:mm
     *
     * @param dt         java.util.Date
     * @param formatType : 指定日期转化格式字符串模板,例如:yyyy-MM-dd
     * @return 格式化后的日期时间字符串
     */
    public static String formatDateTime(Date dt, String formatType) {
        String newDate = "";
        if (dt != null) {
            Locale locale = Locale.CHINESE;
            SimpleDateFormat dateStyle = new SimpleDateFormat(formatType, locale);
            newDate = dateStyle.format(dt);
        }
        return newDate;
    }


    /**
     * 将时间格式字符串转换为时间对象
     *
     * @param strDate
     * @return
     */
    public static Date format(String strDate, String aFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(aFormat);
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 获取某一天是星期几
     *
     * @param date
     * @return
     * @author
     * @date 2013-5-10
     */
    public static int getWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * @param
     * @return int    返回类型
     * @throws
     * @Title: getMonth
     * @Description: 获取当前日期是第几月
     * @author Abin
     * @date 2019年3月11日 下午4:18:42
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取某一天的前一天
     *
     * @param date
     * @return
     * @author
     * @date 2013-6-7
     */
    public static Date getYesterday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 根据一个时间戳(长整形字符串)生成指定格式时间字符串
     *
     * @param time   时间戳(长整形字符串)
     * @param format 格式字符串如yyyy-MM-dd
     * @return 时间字符串
     */
    public static String getDate(long time, String format) {
        Date d = new Date();
        d.setTime(time);
        DateFormat df = new SimpleDateFormat(format);
        return df.format(d);
    }

    public static Date getDate(long time) {
        Date d = new Date();
        d.setTime(time);

        return d;
    }

    /**
     * 秒时间戳，转日期时间戳
     *
     * @param timeStamp
     * @param format
     * @return
     */
    public static long getTimeStampDate(String timeStamp, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatDefaultTimestamp);
        String sd = sdf.format(new Date(Long.parseLong(timeStamp + "000")));
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(sd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long s = date.getTime() / 1000;
        return s;
    }

    /**
     * 时间戳转日期
     *
     * @param timeStamp
     * @return
     */
    public static String getDateTimeStamp(String timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatDefaultTimestamp);
        String sd = sdf.format(new Date(Long.parseLong(timeStamp + "000")));
        return sd;
    }

    /**
     * 返回一个指定数字后的时间
     *
     * @param x 指定几分钟
     * @return
     */
    public static String getTimeMinuteAdd(Date date, int x) {
        long new_d = date.getTime() + (x * 60 * 1000);
        return getDate(new_d, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 当前时间+Interval 分钟 后的时间
     *
     * @param Interval
     * @return
     * @author
     * @date 2013-6-6
     */
    public static Date addDate(int Interval) {
        Calendar c = Calendar.getInstance();
        // 设置当前日期
        c.setTime(new Date());
        // 日期分钟加1,Calendar.DATE(天),Calendar.HOUR(小时)
        c.add(Calendar.MINUTE, Interval);
        Date date = c.getTime();
        return date;

    }

    /**
     * 判断特定时间是否在一个时间范围内
     *
     * @param time
     * @param starttime
     * @param endtime
     * @return
     */
    public static Boolean isInTheTime(Date time, Date starttime, Date endtime) {

        if (time == null || starttime == null || endtime == null) {
            return false;
        }

        if ((time.compareTo(starttime) >= 0) && (time.compareTo(endtime) <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static Date getNowStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getNowEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static String getNowTime() {
        Calendar Cld = Calendar.getInstance();
        // 年
        int YY = Cld.get(Calendar.YEAR);
        // 月
        int MM = Cld.get(Calendar.MONTH) + 1;
        // 日
        int DD = Cld.get(Calendar.DATE);
        // 时
        int HH = Cld.get(Calendar.HOUR_OF_DAY);
        // 分
        int mm = Cld.get(Calendar.MINUTE);
        // 秒
        int SS = Cld.get(Calendar.SECOND);
        // 毫秒
        int MI = Cld.get(Calendar.MILLISECOND);
        String valueOf = String.valueOf(YY);
        String MMString = String.valueOf(MM);
        String DDString = String.valueOf(DD);
        String HHString = String.valueOf(HH);
        String mmString = String.valueOf(mm);
        String SSString = String.valueOf(SS);
        String MIString = String.valueOf(MI);
        return valueOf + MMString + DDString + HHString + mmString + SSString + MIString;
    }
}
