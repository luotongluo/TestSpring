package com.lt.commparent.utils;

public class RequestParms<T> {

    private RequestHead header;

    private T body;

    public RequestHead getHeader() {
        return header;
    }

    public void setHeader(RequestHead header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }


}
