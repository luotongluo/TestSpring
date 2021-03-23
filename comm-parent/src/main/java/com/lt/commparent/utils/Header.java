package com.lt.commparent.utils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author
 */
public class Header {

    /**
     * 消息编号
     */
    @JSONField(name = "message_id")
    private String messageId;

    /**
     * 响应方时间戳
     */
    @JSONField(name = "time_stamp")
    private String timeStamp;

    /**
     * 接口编码
     */
    @JSONField(name = "transaction_type")
    private String transactionType;


    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}
