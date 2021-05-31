package com.lt.commonutils.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtils {
    public static final String FORMAT_DEFAULT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMM = "yyyy-MM";
    public DateUtils() {
    }

    public static void main(String[] args) {
        Date date = getTimeBackThirtyDay();
        SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
        System.out.println(sf.format(date));
    }

    public static Date getCurrDay() {
        SimpleDateFormat sf = new SimpleDateFormat(FORMAT_DEFAULT_TIMESTAMP);
        Date date = null;

        try {
            date = sf.parse(sf.format(new Date()));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return date;
    }

    public static Date getTimeBackThirtyDay() {
        SimpleDateFormat sf = new SimpleDateFormat(FORMAT_DEFAULT_TIMESTAMP);
        Date date = null;

        try {
            Calendar cale = Calendar.getInstance();
            cale.add(5, -30);
            date = sf.parse(sf.format(cale.getTime()));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return date;
    }

    public static Date getFirstdayForCurrMonth() {
        SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYYMMDD);
        Calendar cale = Calendar.getInstance();
        Date date = null;

        try {
            cale.add(2, 0);
            cale.set(5, 1);
            String dateStr = sf.format(cale.getTime()) + " 00:00:00";
            date = (new SimpleDateFormat(FORMAT_DEFAULT_TIMESTAMP)).parse(dateStr);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return date;
    }

    public static Date getLastdayForCurrMonth() {
        SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYYMMDD);
        Calendar cale = Calendar.getInstance();
        Date date = null;

        try {
            cale.add(2, 1);
            cale.set(5, 0);
            String dateStr = sf.format(cale.getTime()) + " 23:59:59";
            date = (new SimpleDateFormat(FORMAT_DEFAULT_TIMESTAMP)).parse(dateStr);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return date;
    }

    public static String getStringToday() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String dateToString(Date date) {
        String str = FORMAT_DEFAULT_TIMESTAMP;
        SimpleDateFormat format = new SimpleDateFormat(str);
        String dateFormat = format.format(date);
        return dateFormat;
    }

    public static String dateToStringMod(Date date, int data) {
        String str = FORMAT_DEFAULT_TIMESTAMP;
        SimpleDateFormat format = new SimpleDateFormat(str);
        String dateFormat = format.format(date.getTime() + (long) data * 1000L * 60L);
        return dateFormat;
    }

    public static String dateToStringModHour(Date date, int data) {
        String str = FORMAT_DEFAULT_TIMESTAMP;
        SimpleDateFormat format = new SimpleDateFormat(str);
        String dateFormat = format.format(date.getTime() + (long) data * 1000L * 60L * 60L);
        return dateFormat;
    }

    public static Date stringToDate(String string) {
        String str = FORMAT_DEFAULT_TIMESTAMP;
        SimpleDateFormat format = new SimpleDateFormat(str);
        Date date = new Date();

        try {
            date = format.parse(string);
        } catch (Exception var5) {
            var5.getStackTrace();
        }

        return date;
    }

    public static Date getNowDateToDay() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_YYYYMMDD);
        String dateString = formatter.format(currentTime);
        Date parse = null;

        try {
            parse = formatter.parse(dateString);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return parse;
    }

    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_YYYYMMDD);
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_YYYYMMDD);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date getNow() {
        Date currentTime = new Date();
        return currentTime;
    }

    public static synchronized String getNo(int k) {
        return getUserDate(FORMAT_YYYYMMDDHHMMSS) + getRandom(k);
    }

    public static String getUserDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static synchronized String getRandom(int i) {
        Random jjj = new Random();
        if (i == 0) {
            return "";
        } else {
            String jj = "";

            for (int k = 0; k < i; ++k) {
                jj = jj + jjj.nextInt(9);
            }

            return jj;
        }
    }
}
