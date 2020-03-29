package com.lt.converge.converge.service.impl;

import com.lt.converge.converge.feign.TestFeignService;
import com.lt.converge.converge.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tong.luo
 * @description TestServiceImpl
 * @date 2020/3/28 23:15
 */
@Service
public class TestServiceImpl implements TestService {
    private static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @Autowired
    private TestFeignService testFeignService;

    @Override
    public String getTest() {
        String testForRequestParam = this.testFeignService.getTestForRequestParam("212312");
        return testForRequestParam;
    }
}
