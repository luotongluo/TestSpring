package com.lt.converge.converge.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tong.luo
 * @description TestFeignService
 * @date 2020/3/28 23:05
 */
@FeignClient("service-base")
public interface TestFeignService {
    @RequestMapping("getTestInfo")
    public String getTestInfo(@RequestBody String req);

    /**
     *getTestForRequestParam
     * @param req
     * @return
     */
    @RequestMapping("getTestForRequestParam")
    public String getTestForRequestParam(@RequestParam("info") String req);
}
