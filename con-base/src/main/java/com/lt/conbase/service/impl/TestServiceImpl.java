package com.lt.conbase.service.impl;

import com.lt.conbase.service.TestService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luotong
 * @description TestServiceImpl
 * @date 2020/4/9 19:04
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public Map test() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("test","test");
        return hashMap;
    }
}
