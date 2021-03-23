package com.lt.commparent.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 时间戳加随机数生成一个订单号，可根据需要自行定义
 *
 * @author cardinfolink
 */
public class RandomUtil {


    /**
     * 生成消息id
     *
     * @return
     */
    public static String getMessgeId() {
        StringBuilder result = new StringBuilder();
        result.append(getCurrTime()).append(assembleRandom());
        return result.toString();
    }

    /**
     * 生成12位随机数
     *
     * @return
     */
    public static String assembleRandom() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for (int i = 0; i < 12; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    /**
     * 生成n位随机数
     *
     * @param n
     * @return
     */
    public static String assembleRandom(int n) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for (int i = 0; i < n; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time = format.format(date);
        return time;
    }


    public static void main(String args[]) {

    }


    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code
     * @return
     */
    public static String autoGenericCode(Long code, int num) {
        String codeStr = String.valueOf(code);
        if (codeStr.length() > num) {
            codeStr = codeStr.substring(codeStr.length() - num - 1, codeStr.length() - 1);
        } else {
            codeStr = String.format("%0" + num + "d", code);
        }
        return codeStr;
    }


}
