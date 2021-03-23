package com.lt.conbase.controller;

import com.lt.conbase.service.TestService;
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
    @Resource
    private TestService testService;

    @RequestMapping("test")
    @ResponseBody
    public Map test() {
        return this.testService.test();
    }

    @RequestMapping("add")
    @ResponseBody
    public Map add() {
        long start = System.currentTimeMillis();
        Map add = this.testService.add();
        System.out.println("time :" + (System.currentTimeMillis() - start));
        return add;
    }
}
