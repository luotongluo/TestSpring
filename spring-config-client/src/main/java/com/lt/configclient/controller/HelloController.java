package com.lt.configclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tong.luo
 * @description Controller
 * @date 2020/12/30 15:24
 */
@RefreshScope
@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Value("${springcloud.hello}")
    private String hello;
//    @Autowired
//    private PropertiesConfig propertiesConfig;

    @RequestMapping("/hello")
    public String from() {
        return hello;
    }
}
