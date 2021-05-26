package com.lt.commonutils.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;


/**
 * @author xueyuan
 * @ClassName: MessageUtil
 * @Description:
 * @date 2016年5月17日 上午11:35:16
 */
public class MessageUtil {


    /**
     * 解析body
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getBoby(String json) throws Exception {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        // 如果全加密形态加密
        if (!json.contains("{")) {
            json = json.replace(" ", "+");
            json = new String(Base64Util.decode(json), "UTF-8");
            Map<String, Object> msgMap = JSON.parseObject(json, Map.class);
            returnMap = (Map<String, Object>) msgMap.get("body");
        } else {
            // 消息体加密
            Map<String, Object> msgEntity = JSON.parseObject(json, Map.class);
            if (msgEntity.get("body").getClass().equals(String.class)) {
                byte[] b = Base64Util.decode(msgEntity.get("body").toString());
                String bodyStr = new String(b, "UTF-8");
                returnMap = JSON.parseObject(bodyStr, Map.class);
            } else {
                // 全都不加密
                Map<String, Object> msgMap = JSON.parseObject(json, Map.class);
                returnMap = (Map<String, Object>) msgMap.get("body");
            }
        }
        return returnMap;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBoby2Entity(String json, Class<T> t) throws Exception {

        T object = t.newInstance();
        String bodyStr = "";
        // 如果全加密形态加密
        if (!json.contains("{")) {
            json = json.replace(" ", "+");
            json = new String(Base64Util.decode(json), "UTF-8");
            Map<String, Object> msgMap = JSON.parseObject(json, Map.class);
            if (msgMap.get("body") != null && !msgMap.get("body").equals("")) {
                bodyStr = msgMap.get("body").toString();
            } else {
                bodyStr = "{}";
            }

        } else {
            // 消息体加密
            Map<String, Object> msgEntity = JSON.parseObject(json, Map.class);
            if (msgEntity.get("body").getClass().equals(String.class)) {
                byte[] b = Base64Util.decode(msgEntity.get("body").toString());
                bodyStr = new String(b, "UTF-8");
            } else {
                // 全都不加密
                Map<String, Object> msgMap = JSON.parseObject(json, Map.class);
                bodyStr = msgMap.get("body").toString();

            }
        }
        object = JSON.parseObject(bodyStr, t);

        return object;
    }

    // 取token
    @SuppressWarnings("unchecked")
//	public static String getToken(String json) throws Exception{
//
//		RequestHead head = null;
//		// 如果全加密形态加密
//		if (!json.contains("{")) {
//			json = json.replace(" ", "+");
//			json = new String(Base64Util.decode(json), "UTF-8");
//		}
//		Map<String, Object> msgMap = JSON.parseObject(json, Map.class);
//		head = JSON.parseObject(msgMap.get("header").toString(), RequestHead.class);
//
//		return head.getToken();
//	}

    /**
     * 获取userId
     */
    public static Integer getUserId(String userInfos) {
        if (userInfos == null || userInfos.equals("")) {
            return null;
        }
        String[] str = userInfos.split(":");
        return Integer.parseInt(str[0]);
    }

    /**
     * 获取cardnum
     */
    public static String getUserCardnum(String userInfos) {
        String[] str = userInfos.split(":");
        return str[1];
    }

    /**
     * 获取name
     */
    public static String getUserName(String userInfos) {
        String[] str = userInfos.split(":");
        String name = null;
        //if(str.length > 2){//新加的参数，防止历史数据(只有3个参数)报错
        name = str[2];
        //}
        return name;
    }

    /**
     * 获取login
     */
    public static String getLogin(String userInfos) {
        String[] str = userInfos.split(":");
        String login = null;
        //if(str.length > 3){//新加的参数，防止历史数据(只有3个参数)报错
        login = str[3];
        //}
        return login;
    }

    /**
     * 根据json对象获取MAP
     *
     * @param
     * @return Map<String, Object> 返回类型
     * @throws @author Illidan
     * @Title: getMsgMap
     * @Description: 根据json对象获取MAP
     * @date 2016年6月1日 下午3:22:13
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMsgMap(String json) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        // 如果全加密形态加密
        if (!json.contains("{")) {
            json = json.replace(" ", "+");
            json = new String(Base64Util.decode(json), "UTF-8");
            returnMap = JSON.parseObject(json, Map.class);
        } else {
            // 消息体加密
            Map<String, Object> msgEntity = JSON.parseObject(json, Map.class);
            if (msgEntity.get("body").getClass().equals(String.class)) {
                byte[] b = Base64Util.decode(msgEntity.get("body").toString());
                String bodyStr = new String(b, "UTF-8");
                Map<String, Object> body = JSON.parseObject(bodyStr, Map.class);
                returnMap.put("body", body);
                returnMap.put("header", msgEntity.get("header"));
            } else {
                // 全都不加密
                returnMap = JSON.parseObject(json, Map.class);
            }
        }

        return returnMap;
    }

    /**
     * @param
     * @return Map<String, Object> 返回类型
     * @throws @author Illidan
     * @Title: getMsgMap
     * @Description: 根据指定的BODY的对象回去msg的MAP
     * @date 2016年6月1日 下午4:18:08
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, Object> getMsgMap(String json, Class<T> t) throws Exception {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        String bodyStr = "";
        // 如果全加密形态加密
        if (!json.contains("{")) {
            json = json.replace(" ", "+");
            json = new String(Base64Util.decode(json), "UTF-8");
            returnMap = JSON.parseObject(json, Map.class);
            bodyStr = returnMap.get("body").toString();
        } else {
            // 消息体加密
            Map<String, Object> msgEntity = JSON.parseObject(json, Map.class);
            if (msgEntity.get("body").getClass().equals(String.class)) {
                byte[] b = Base64Util.decode(msgEntity.get("body").toString());
                bodyStr = new String(b, "UTF-8");
                returnMap.put("header", msgEntity.get("header"));
            } else {
                // 全都不加密
                returnMap = JSON.parseObject(json, Map.class);
                bodyStr = returnMap.get("body").toString();
            }
        }
        returnMap.put("body", JSON.parseObject(bodyStr, t));
        return returnMap;

    }

    /**
     * 解析header
     */
    @SuppressWarnings("unchecked")
    public static RequestHead getHeader(String json) throws Exception {

        RequestHead head = null;
        // 如果全加密形态加密
        if (!json.contains("{")) {
            json = json.replace(" ", "+");
            json = new String(Base64Util.decode(json), "UTF-8");
        }
        Map<String, Object> msgMap = JSON.parseObject(json, Map.class);
        head = JSON.parseObject(msgMap.get("header").toString(), RequestHead.class);

        return head;
    }


}
