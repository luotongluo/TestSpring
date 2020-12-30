package com.lt.conbase.test;

import com.lt.commparent.tools.MD5Util;

/**
 * @author tong.luo
 * @description TestDeploy
 * @date 2020/12/30 11:28
 */
public class TestDeploy {
    public static void main(String[] args) {
        byte[] cipherStr = MD5Util.getCipherStr("123");
        System.out.println(cipherStr);
    }
}
