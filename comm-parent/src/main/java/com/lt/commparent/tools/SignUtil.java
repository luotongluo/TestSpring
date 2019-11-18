package com.lt.commparent.tools;


import org.springframework.util.StringUtils;

/**
 * @Title: SignUtil
 * @Package: com.leyou.apollo.tools
 * @Description: sign 生成和校验
 * @author: lizhui
 * @date: 2019/1/15 9:09
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
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
