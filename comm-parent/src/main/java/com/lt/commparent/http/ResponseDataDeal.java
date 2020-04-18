package com.lt.commparent.http;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class ResponseDataDeal {


    /**
     * 又返回数据的success
     *
     * @param requestHeader 请求头
     * @param body          返回body内容
     */
    public static ProtocolResponse getSuccess(RequestHeader requestHeader, Object body) {
        ProtocolResponse protocolResponse = new ProtocolResponse();
        ResponseHeader responseHeader = protocolResponse.getHeader();
        responseHeader.setMessageId(requestHeader == null ? "0000000000000000000000000000" : requestHeader.getMessageId());
        responseHeader.setAppId(requestHeader == null ? 0 : requestHeader.getAppId());
        responseHeader.setTransactionType(requestHeader == null ? "" : requestHeader.getTransactionType());
        responseHeader.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        responseHeader.setResCode(ResultCode.SUCCESS.getIndex());
        responseHeader.setMessage(ResultCode.SUCCESS.getName());
        protocolResponse.setHeader(responseHeader);
        protocolResponse.setBody(body == null ? new HashMap<String, Object>() : MapObjectTransfer.objectToMap(body));
        return protocolResponse;
    }

    /**
     * 返回默认消息头，不建议使用
     * @param body  返回body内容
     */
    public static ProtocolResponse getSuccess(Object body) {
        return getSuccess(null,body);
    }

    /**
     * 成功，不返回任何参数
     * 成功，必须带头部信息
     *
     * @param requestHeader 请求头消息
     */
    public static ProtocolResponse getSuccess(RequestHeader requestHeader) {
        return getSuccess(requestHeader, null);
    }

    /**
     * 返回错误消息,完整信息
     *
     * @param requestHeader
     * @param resCode
     * @param resMsg
     * @return
     */
    public static ProtocolResponse getError(RequestHeader requestHeader, Integer resCode, String resMsg) {
        ProtocolResponse protocolResponse = new ProtocolResponse();
        ResponseHeader responseHeader = protocolResponse.getHeader();
        responseHeader.setMessageId(requestHeader == null ? "0000000000000000000000000000" : requestHeader.getMessageId());
        responseHeader.setAppId(requestHeader == null ? 0 : requestHeader.getAppId());
        responseHeader.setTransactionType(requestHeader == null ? "" : requestHeader.getTransactionType());
        responseHeader.setResCode(resCode);
        responseHeader.setMessage(resMsg);
        responseHeader.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        protocolResponse.setHeader(responseHeader);
        protocolResponse.setBody(new HashMap<String, Object>());
        return protocolResponse;
    }

    /**
     * 返回错误消息
     *
     * @param resCode
     * @param resMsg
     * @return
     */
    public static ProtocolResponse getError(Integer resCode, String resMsg) {
        return getError(null, resCode, resMsg);
    }

    /**
     * 默认系统错误
     *
     * @return
     */
    public static ProtocolResponse getError() {
        return getError(ResultCode.ERROR.getIndex(), ResultCode.ERROR.getName());
    }


    public static void main(String[] args) {
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setVersion("1.0");
        requestHeader.setAppId(100024);
        requestHeader.setMessageId("1111111");
        requestHeader.setTransactionType("getCode");
        Header header = new Header();
        header.setAppId(12222);
        header.setMessageId("22333333");
        header.setTimeStamp(System.currentTimeMillis()+"");
        header.setTransactionType("dslsld");

        String json = JSON.toJSONString(getSuccess(requestHeader, header));
        System.out.println(json);
    }

}
