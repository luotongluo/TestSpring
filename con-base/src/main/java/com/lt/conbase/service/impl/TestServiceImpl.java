package com.lt.conbase.service.impl;

import com.lt.conbase.dao.TestDbMapper;
import com.lt.conbase.pojo.TestDb;
import com.lt.conbase.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author luotong
 * @description TestServiceImpl
 * @date 2020/4/9 19:04
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDbMapper testDbMapper;

    @Override
    public Map test() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("test", "test");
        return hashMap;
    }

    @Override
    public Map add() {
        TestDb testDb = new TestDb();
        testDb.setCreateTime(new Date());
        String string = UUID.randomUUID().toString();
        testDb.setDoSomtthing(string);
        testDb.setName(string);
        Integer add = testDbMapper.add(testDb);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("count",add);
        return stringObjectHashMap;
    }
}
