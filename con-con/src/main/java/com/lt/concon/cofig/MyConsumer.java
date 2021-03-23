package com.lt.concon.cofig;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;

/**
 * @author tong.luo
 * @description MyConsumer
 * 自定义消费者
 * 设置手动ack和重回队列
 * @date 2020/4/20 22:24
 */
public class MyConsumer extends DefaultConsumer {
    Channel channel;

    public MyConsumer(Channel channel) {
        super(channel);
        this.channel = channel;
    }
}
