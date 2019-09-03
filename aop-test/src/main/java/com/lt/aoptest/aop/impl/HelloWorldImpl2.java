package com.lt.aoptest.aop.impl;

import com.lt.aoptest.aop.HelloWorld;

/**
 * Created by tong.luo on 2019/9/2 23:08
 */
public class HelloWorldImpl2 implements HelloWorld {
    @Override
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
    }

    @Override
    public void doPrint() {
        System.out.println("Enter HelloWorldImpl2.doPrint()");
    }
}
