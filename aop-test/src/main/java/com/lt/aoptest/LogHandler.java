package com.lt.aoptest;

/**
 * Created by tong.luo on 2019/9/2 23:27
 */
public class LogHandler {
    public void logBefore() {
        System.out.println("this is logger logBefore init ……");

    }

    public void logAfter() {
        System.out.println("this is logger logAfter init ……");
    }
}
