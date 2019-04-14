package com.lt.comsumor.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: Test
 * @description: Feign
 * @author: LT
 * @create: 2019-04-14 17:24
 */
@FeignClient("test-service")
public interface TestFeign {
    @RequestMapping("testCon")
    String testCon();
}
