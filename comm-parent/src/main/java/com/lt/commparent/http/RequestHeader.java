package com.lt.commparent.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
* @Title: RequestHeader
* @Package:  com.leyou.apollo
* @Description: 请求消息头
* @author: lizhui
* @date: 2019/1/14 9:33
* @version: V1.0
* <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
* <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
*/
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
