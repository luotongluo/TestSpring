package com.lt.commparent.http;

import java.io.Serializable;
import java.util.Map;

/**
 * @Title: ProtocolResponse
 * @Package: com.leyou.entity
 * @Description: 接口返回实体类
 * @author: lizhui
 * @date: 2018/11/22 9:12
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
public class ProtocolResponse implements Serializable {

    private static final long serialVersionUID = 784883675091763608L;

    /**
     * 返回消息头
     */
    private ResponseHeader header = new ResponseHeader();

    /**
     * 返回消息体
     */
    private Map<String, Object> body;

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }
}
