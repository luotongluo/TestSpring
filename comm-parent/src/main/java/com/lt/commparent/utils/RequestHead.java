package com.lt.commparent.utils;

import com.alibaba.fastjson.annotation.JSONField;

public class RequestHead extends Header {


    @JSONField(name = "app_id")
    private String appId;

    @JSONField(name = "token")
    private String token;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
