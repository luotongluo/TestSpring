package com.lt.commonutils.expcetion;

import java.io.Serializable;

/**
 * @author tong.luo
 * @description BusinessException
 * @date 2021/6/2 17:34
 */
public class BusinessRunTimeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 3166045788647520827L;
    private String code ;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public BusinessRunTimeException(String message) {
        super(message);
        this.code = "403";
        this.msg = message;
    }

    public BusinessRunTimeException(String message, Throwable cause) {
        super(message, cause);
        this.code = "403";
        this.msg = message;
    }
    public BusinessRunTimeException(String message,String code, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.msg = message;
    }

    public BusinessRunTimeException(Throwable cause) {
        super(cause);
    }

}
