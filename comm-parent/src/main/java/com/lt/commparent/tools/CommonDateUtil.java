package com.lt.commparent.tools;


import org.springframework.util.StringUtils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Title: CommonDateUtil
 * @Package: com.leyou.apollo.promotion.manage.utils
 * @Description: 通用时间转换工具类
 * @author:
 * @date: 2019/2/28 11:55
 * @version: V1.0
 */
public class CommonDateUtil {

    public static final String FORMAT_YYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取指定格式的当前时间
     *
     * @param formatType
     * @return
     */
    public static String getCurrentTime(String formatType) {
        if (StringUtils.isEmpty(formatType)) {
            formatType = FORMAT_YYMMDDHHMMSS;
        }

        Locale locale = Locale.SIMPLIFIED_CHINESE;
        SimpleDateFormat dateStyle = new SimpleDateFormat(formatType, locale);
        return dateStyle.format(new Date());
    }

    /**
     * 获取当前时间的date
     * @param format
     * @return
     */
    public static Date getNowDate(String format) {
        try {
            String time = getCurrentTime(format);
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            ParsePosition pos = new ParsePosition(0);
            return formatter.parse(time, pos);
        }catch (Exception e){
           e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前时间的date
     * @return
     */
    public static Date getNowDate(){
        return getNowDate(FORMAT_YYMMDDHHMMSS);
    }
}
