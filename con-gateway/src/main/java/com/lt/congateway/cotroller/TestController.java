package com.lt.congateway.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tong.luo
 * @description TestController
 * @date 2020/4/18 23:23
 */
@RestController
public class TestController {
    @RequestMapping(name = "/,/test")
    public String test() {
//        throw new UseException("play");
        return "success";
    }
}
