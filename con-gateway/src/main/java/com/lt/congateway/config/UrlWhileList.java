package com.lt.congateway.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tong.luo
 * @description UrlWhileList
 * 请求地址白名单,无需校验token
 * @date 2020/4/19 15:52
 */
@Configuration
public class UrlWhileList implements InitializingBean {
    private final static List<String> URL_LIST = new ArrayList<String>();

    @Override
    public void afterPropertiesSet() throws Exception {
        //后台-获取图形验证码
        URL_LIST.add("/conn-web/");
//        //APP登录注册
//        URL_LIST.add("/xxx2-service/v1/token/app/login/*");
//        URL_LIST.add("/xxx3-service/v1/token/app/register/*");
//        //网页登录注册
//        URL_LIST.add("/xxx4-service/v1/token/mweb/login/*");
//        URL_LIST.add("/xxx5-service/v1/token/mweb/register/*");
//        //获取短信验证码
//        URL_LIST.add("/xxx6-service/v1/message/login");
    }

    public static List<String> getUrlList() {
        return URL_LIST;
    }
}
