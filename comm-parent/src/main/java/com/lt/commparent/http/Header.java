package com.lt.commparent.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @Title: Header
 * @Package: com.leyou.apollo
 * @Description: 消息头
 * @author: lizhui
 * @date: 2019/1/14 9:31
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
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
