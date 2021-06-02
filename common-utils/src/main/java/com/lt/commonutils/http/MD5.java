package com.lt.commonutils.http;


import com.lt.commonutils.tools.MD5Util;

import java.security.MessageDigest;

public class MD5 {
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c",
            "d", "e", "f"};


    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * @param
     * @return String    返回类型
     * @throws
     * @Title: MD5Encode
     * @Description: MD5转码
     * @author Illidan
     * @date 2016年5月5日 下午4:32:30
     */
    public static String MD5Encode(String origin) {
        String resultString = null;

        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {

        }
        return resultString;
    }

    /**
     * @param origin
     * @param charsetname
     * @return
     * @description:MD5Encode
     * @author:蔡彬彬
     * @return:String
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
            }
        } catch (Exception exception) {
        }
        return resultString;
    }

    public static void main(String[] args) {
        String a = "0d71a00c{\"header\":{\"appId\":\"10000024\",\"message_id\":\"15505429706326003053521\",\"transaction_type\":\"posLogin\",\"time_stamp\":\"1550542970632\"},\"body\":{\"cashier_username\":\"sc\",\"password\":\"123456\",\"host_name\":\"LEYOU-20190109Q\",\"host_ip\":\"192.168.5.168\",\"version\":\"1\"}}1550542970632";
        String b = MD5Encode(a);
        System.out.println(b);
        System.out.println(MD5Util.MD5Encode(a));
    }

}
