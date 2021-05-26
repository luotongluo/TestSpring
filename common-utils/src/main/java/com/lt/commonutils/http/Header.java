package com.lt.commonutils.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Header implements Serializable {
    private static final long serialVersionUID = 263551892440506626L;

    /**
     * 消息流水号
     */
    @JSONField(name = "message_id")
    private String messageId;


    /**
     * 时间戳
     */
    @JSONField(name = "time_stamp")
    private String timeStamp;

    /**
     * 接口编号
     */
    @JSONField(name = "transaction_type")
    private String transactionType;

    /**
     * 商户代码
     */
    @JSONField(name = "app_id")
    private Integer appId;

    @JSONField(name = "token")
    private String token;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
