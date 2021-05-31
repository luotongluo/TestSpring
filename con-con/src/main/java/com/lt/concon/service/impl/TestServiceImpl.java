package com.lt.concon.service.impl;

import com.alibaba.fastjson.JSON;
import com.lt.commonutils.config.MqContents;
import com.lt.concon.service.TestService;
import com.lt.concon.service.feign.ConnBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author luotong
 * @description TestServiceImpl
 * @date 2020/4/9 19:08
 */
@Service
public class TestServiceImpl implements TestService {

    private static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @Resource
    private ConnBaseService connBaseService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Map test() {
        return this.connBaseService.test();
    }

    @Override
    public Map add() {
        Map add = this.connBaseService.add();
        return add;
    }

    @Override
    public Map testSedMsg() {
        int loop = 1;
        for (int i = 0; i < loop; i++) {
            HashMap<String, Object> reqMap = new HashMap<>();
            UUID uuid = UUID.randomUUID();
            reqMap.put(uuid.toString(), uuid + ":" + i);
            this.rabbitTemplate.convertAndSend(MqContents.LT_TEST_EXHCANGE, MqContents.LT_TEST_QUEUE_KEY, reqMap);
            logger.info("交换机为：{},队列为：{},内容为：{}", MqContents.LT_TEST_EXHCANGE, MqContents.LT_TEST_QUEUE_KEY, JSON.toJSONString(reqMap));
        }
        return null;
    }
}
