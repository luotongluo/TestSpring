package com.lt.test.controller;

import com.lt.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Test
 * @description: Test
 * @author: LT
 * @create: 2019-04-14 17:19
 */
@RestController
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("testCon")
    public String testCon() {
        logger.info("com.lt.test.controller.TestController.testCon");
        return testService.getTest();
    }

}
