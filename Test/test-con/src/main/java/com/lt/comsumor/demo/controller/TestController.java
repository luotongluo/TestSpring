package com.lt.comsumor.demo.controller;

import com.lt.comsumor.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Test
 * @description: test
 * @author: LT
 * @create: 2019-04-14 17:02
 **/
@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public String test(){
        return testService.getTest();
    }

}
