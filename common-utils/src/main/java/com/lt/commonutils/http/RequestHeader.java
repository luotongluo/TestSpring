package com.lt.commonutils.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class RequestHeader extends Header implements Serializable {

    private static final long serialVersionUID = -2397175134295361494L;

    /**
     * 终端版本
     */
    @JSONField(name = "version")
    private String version;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
