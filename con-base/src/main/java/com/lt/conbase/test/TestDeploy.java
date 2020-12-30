package com.lt.conbase.test;

//import com.lt.commparent.tools.MD5Util;
import com.lt.commparent.tools.MD5Util;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tong.luo
 * @description TestDeploy
 * @date 2020/12/30 11:28
 */
public class TestDeploy {
    public static void main(String[] args) {
        String str = "123";
//        byte[] cipherStr = MD5Util.getCipherStr(str);
//        System.out.println(cipherStr);
        StringUtils.isNotEmpty(str);
    }
}
