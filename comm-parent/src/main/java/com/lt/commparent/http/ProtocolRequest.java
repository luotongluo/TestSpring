package com.lt.commparent.http;

import java.io.Serializable;
import java.util.Map;

/**
 * @Title: ProtocolRequest
 * @Package: com.leyou.entity
 * @Description: 接口请求实体类
 * @author: lizhui
 * @date: 2018/11/22 9:12
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
public class ProtocolRequest implements Serializable {

    private static final long serialVersionUID = 8361488992432130911L;
    /**
     * 请求消息头
     */
    private RequestHeader header;

    /**
     * 请求消息体
     */
    private Map<String, Object> body;

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }
}
