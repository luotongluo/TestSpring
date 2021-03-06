package com.lt.commonutils.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ResponseHeader extends Header implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应编码
     */
    @JSONField(name = "res_code")
    private Integer resCode;

    /**
     * 响应消息
     */
    @JSONField(name = "message")
    private String message;

    public ResponseHeader() {
    }

    public ResponseHeader(Integer resCode, String message) {
        super();
        this.resCode = resCode;
        this.message = message;
    }

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
