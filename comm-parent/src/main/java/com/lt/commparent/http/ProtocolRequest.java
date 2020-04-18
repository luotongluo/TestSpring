package com.lt.commparent.http;

import java.io.Serializable;
import java.util.Map;

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
