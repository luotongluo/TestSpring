package com.lt.concon.controller;

import com.lt.concon.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author luotong
 * @description TestController
 * @date 2020/4/9 19:02
 */
@Controller
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private TestService testService;

    @RequestMapping("test")
    @ResponseBody
    public Map test() throws Exception {
        logger.info("test");
//        Thread.sleep(8100);
        return this.testService.test();
    }

    @RequestMapping("add")
    @ResponseBody
    public Map add() {
        return this.testService.add();
    }

    @RequestMapping("testSedMsg")
    @ResponseBody
    public Map testSedMsg() {
        return this.testService.testSedMsg();
    }
}
