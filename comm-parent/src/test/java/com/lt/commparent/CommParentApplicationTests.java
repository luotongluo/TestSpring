package com.lt.commparent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class CommParentApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
//        JedisUtils.set("test","test");
//        Object test = JedisUtils.get("test");
        redisTemplate.opsForValue().set("test", "test");
        Object test1 = redisTemplate.opsForValue().get("test");
        System.out.println(test1);
    }

}
