package com.lt.commparent.tools;


import org.springframework.util.StringUtils;

public class SignUtil {

    /**
     * 生成api签名
     *
     * @param timeStamp
     * @param appKey
     * @return
     */
    public static String generator(String timeStamp, String appKey, String body) {
        System.out.println("appKey : " + appKey + ",timeStamp : " + timeStamp + ",body:" + body);
        //时间戳
        StringBuffer buffer = new StringBuffer();
        buffer.append(appKey).append(body).append(timeStamp);
        System.out.println("buffer : " + buffer.toString());
        return MD5Util.MD5Encode(buffer.toString()).toUpperCase();
    }

    /**
     * 校验md5 签名是否一致
     *
     * @param fromSign
     * @param timeStamp
     * @param appKey
     * @param body
     * @return
     */
    public static boolean checkSign(String fromSign, String timeStamp, String appKey, String body) {
        if (StringUtils.isEmpty(fromSign)) {
            return false;
        }
        String toSign = generator(timeStamp, appKey, body);
        System.out.println("fromSign : " + fromSign + ",toSign : " + toSign);
        if (!fromSign.toUpperCase().equalsIgnoreCase(toSign)) {
            return false;
        }
        return true;
    }

}
