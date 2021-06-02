package com.lt.concon.controller;

import com.whalin.MemCached.MemCachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author tong.luo
 * @description MemCacheTestController
 * @date 2021/6/2 17:00
 */
@RestController
@RequestMapping("memCache")
public class MemCacheTestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private MemCachedClient memCachedClient;

    @RequestMapping("memCacheTest")
    public String memCacheTest() {
        String key = "com.lt.concon.controller.MemCacheTestController.memCacheTest";
        this.memCachedClient.set(key, key);
        Object o = this.memCachedClient.get(key);
        logger.info("key -->[{}] --  val --> [{}]",key,o);
        this.memCachedClient.delete(key);
        //3s后过期
        this.memCachedClient.set(key,key,new Date(3000));
        /*memCachedClient.set("num", "666", new Date(System.currentTimeMillis()+3000));与上面的区别是当设置了这个时间点
        之后，它会以服务端的时间为准，也就是说如果本地客户端的时间跟服务端的时间有差值，这个值就会出现问题。
        例：如果本地时间是20:00:00,服务端时间为20:00:10，那么实际上会是40秒之后这个缓存key失效*/
        Object o1 = memCachedClient.get(key);
        logger.info("key -->[{}] --  val --> [{}]",key,o1);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object o2 = memCachedClient.get(key);
        logger.info("key -->[{}] --  val --> [{}]",key,o2);
        return key;
    }
}
