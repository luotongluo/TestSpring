package com.lt.connweb.enums;

/**
 * @author tong.luo
 * @description ResultCode
 * @date 2021/1/4 10:21
 */
public enum ResultCode {
    NO_PERMISSION(900, "");
    private int code;
    private String name;

    ResultCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
