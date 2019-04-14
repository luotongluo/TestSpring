package com.lt.commparent.http;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: MapObjectTransfer
 * @Package: com.leyou.apollo.http
 * @Description: json和object 的转换
 * @author: lizhui
 * @date: 2019/1/15 10:20
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
public class MapObjectTransfer {


    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (obj == null) {
            return map;
        }
        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                map.put(fieldName, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


}
