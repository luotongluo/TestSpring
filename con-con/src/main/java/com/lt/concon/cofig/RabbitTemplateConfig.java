package com.lt.concon.cofig;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * <p><b>Description:</b> RabbitTemplate配置工厂类
 * <p><b>Company:</b>
 *
 * @author created by hongda at 11:33 on 2017-07-05
 * @version V0.1
 */
@Configuration
@Component
public class RabbitTemplateConfig {
    /**
     * 如果消息没有到exchange,则confirm回调,ack=false
     * 如果消息到达exchange,则confirm回调,ack=true
     * 但如果是找不到exchange，则会先触发returncallback
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate customRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        // mandatory 必须设置为true，ReturnCallback才会调用
        rabbitTemplate.setMandatory(true);

        /**confirmcallback用来确认消息是否有送达消息队列*/
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {

            System.out.println("init ack");
            if (!ack) {
                //try to resend msg into db
                //	System.out.println("ack false");
            } else {
                //delete msg in db
                System.out.println("ack true");
            }
        });
        /**若消息找不到对应的Exchange会先触发returncallback */
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, tmpExchange, tmpRoutingKey) -> {
            try {
                System.out.println("ReturnCallback true");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rabbitTemplate.send(message);
        });
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
        return jsonMessageConverter;
    }
}
