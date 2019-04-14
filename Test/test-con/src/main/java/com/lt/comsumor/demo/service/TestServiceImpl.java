package com.lt.comsumor.demo.service;

import com.lt.comsumor.demo.feign.TestFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Test
 * @description: testService
 * @author: LT
 * @create: 2019-04-14 17:15
 */
@Service
public class TestServiceImpl implements TestService {
    private static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @Autowired
    private TestFeign testFeign;

    @Override
    public String getTest() {
        logger.info("com.lt.comsumor.demo.service.TestServiceImpl.getTest");
        String s = testFeign.testCon();
        return s;
    }
}
