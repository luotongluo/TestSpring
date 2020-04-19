package com.lt.congateway;

import com.alibaba.fastjson.JSON;
import com.lt.congateway.utils.JedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SpringBootTest
class ConGatewayApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JedisUtils jedisUtils;

    @Test
    void test() {
//        redisTemplate.opsForValue().set("test","test");
//        Object test = redisTemplate.opsForValue().get("test");
//        System.out.println(test);
//        redisTemplate.opsForValue().set("test","test",10, TimeUnit.SECONDS);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>(16);
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            stringObjectHashMap.put(uuid, uuid + ":" + i);
        }
        Set<String> strings = stringObjectHashMap.keySet();
        System.out.println(JSON.toJSONString(stringObjectHashMap));
        this.jedisUtils.mset(stringObjectHashMap);
        List list = this.jedisUtils.mget(strings);
        System.out.println(JSON.toJSONString(list));
    }

}
