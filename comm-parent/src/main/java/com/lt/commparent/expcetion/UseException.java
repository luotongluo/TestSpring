package com.lt.commparent.expcetion;

/**
 * @author tong.luo
 * @description UseException
 * @date 2020/4/18 23:20
 */
public class UseException extends RuntimeException{
    private String msg;

    public UseException(String msg) {
        this.msg = msg;
    }
}
