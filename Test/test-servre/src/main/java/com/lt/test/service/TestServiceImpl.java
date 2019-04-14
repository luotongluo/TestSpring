package com.lt.test.service;/**
 * @Author:LT
 * @Description:
 * @Date:2019，17:222019/4/14
 */

import org.springframework.stereotype.Service;

/**
 * @program: Test
 * @description: Test
 * @author: LT
 * @create: 2019-04-14 17:22
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getTest() {
        return "com.lt.test.service.TestServiceImpl.getTest^";
    }
}
