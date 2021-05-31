package com.lt.concon.rabbit;

import com.alibaba.fastjson.JSON;
import com.lt.commonutils.config.MqContents;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author tong.luo
 * @description MsgSender
 * @date 2020/4/20 22:35
 */
@Component
@RabbitListener(queues = MqContents.LT_TEST_QUEUE)
public class MsgSender {
    private static Logger logger = LoggerFactory.getLogger(MsgSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplatel;

    @RabbitHandler
    public void process(Map map, Channel channel) {
        logger.info("req:{}", JSON.toJSONString(map));
        try {
            channel.basicAck(1, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
