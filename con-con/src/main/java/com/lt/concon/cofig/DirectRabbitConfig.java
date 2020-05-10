
package com.lt.concon.cofig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DirectRabbitConfig {

    /**
     * 交换机
     *
     * @return
     */
    @Bean(name = "ltTestExchannge")
    DirectExchange ltTestExchannge() {
        return new DirectExchange(MqContents.LT_TEST_EXHCANGE);
    }

    @Bean(name = "ltTestQueue")
    public Queue ltTestQueue() {
        // 持久化得
        return new Queue(MqContents.LT_TEST_QUEUE, true);
    }

    @Bean
    Binding bindingSendDingDingMsg(Queue ltTestExchannge, DirectExchange ltTestQueue) {
        return BindingBuilder.bind(ltTestExchannge).to(ltTestQueue).with(MqContents.LT_TEST_QUEUE_KEY);
    }
}

