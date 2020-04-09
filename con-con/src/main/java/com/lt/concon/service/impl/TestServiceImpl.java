package com.lt.concon.service.impl;

import com.lt.concon.service.TestService;
import com.lt.concon.service.feign.ConnBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author luotong
 * @description TestServiceImpl
 * @date 2020/4/9 19:08
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private ConnBaseService connBaseService;

    @Override
    public Map test() {
        return this.connBaseService.test();
    }
}
