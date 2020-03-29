package com.lt.convergebase.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tong.luo
 * @description TestController
 * @date 2020/3/28 23:06
 */
@RestController
@RequestMapping("test")
public class TestController {

    /**
     *getTestInfo
     * @param req
     * @return
     */
    @RequestMapping("getTestInfo")
    public String getTestInfo(@RequestBody String req) {
        return req;
    }

    /**
     *getTestForRequestParam
     * @param req
     * @return
     */
    @RequestMapping("getTestForRequestParam")
    public String getTestForRequestParam(@RequestParam("info") String req) {
        return req;
    }

}
