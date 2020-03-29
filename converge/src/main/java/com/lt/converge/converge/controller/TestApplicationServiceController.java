package com.lt.converge.converge.controller;

import com.lt.converge.converge.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestApplicationServiceController {
    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping(value = "/test")
    public List<Map<String, Object>> test() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", i + 1);
            data.put("name", "test name " + i);
            data.put("age", 20 + i);
            result.add(data);
        }
        return result;
    }

    @RequestMapping("getTest")
    public String getTest() {
        String test = this.testService.getTest();
       return test;

    }
}