package com.lt.commparent.utils;

import java.io.Serializable;

/**
 * @Title: BaseResponse
 * @Package: com.leyou.apollo.framework
 * @Description: 基础服务返回类型
 * @author: lizhui
 * @date: 2019/2/27 11:14
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
public class BaseResponse<T> implements Serializable {

    private int resCode;

    private String message;

    private T data;

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
