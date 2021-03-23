package com.lt.commparent.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    /**
     * 返回method
     */
    public static Map<String, Object> getRespMap(Integer resCode, String message, RequestHead header, Object obj) {
        // header
        ResponseHead respHead = new ResponseHead();
        respHead.setResCode(resCode);
        respHead.setMessage(message);
        respHead.setTimeStamp(System.currentTimeMillis() + "");
        if (header != null) {
            respHead.setMessageId(header.getMessageId());
            respHead.setTransactionType(header.getTransactionType());
        }

        //返回
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("header", respHead);
        if (obj == null) {
            map.put("body", new HashMap<String, Object>());
        } else {
            map.put("body", obj);
        }
        return map;
    }

    public static Map<String, Object> getSuccess(Object data) {
        return getRespMap(0, "成功", null, data);
    }

    public static Map<String, Object> getError(String message) {
        return getRespMap(99999, message, null, null);
    }

    public static Map<String, Object> getError(int code, String message) {
        return getRespMap(code, message, null, null);
    }

    public static Map<String, Object> getError(Throwable e) {
        return getRespMap(99999, e.getMessage(), null, null);
    }

}
