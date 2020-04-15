package com.lt.concon.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author luotong
 * @description ConnBaseService
 * @date 2020/4/9 19:08
 */
@FeignClient("con-base")
public interface ConnBaseService {
    @RequestMapping("test")
    @ResponseBody
    public Map test();
}