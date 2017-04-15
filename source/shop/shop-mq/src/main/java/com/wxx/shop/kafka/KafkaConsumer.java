/*
 * Copyright (c) 2017 Aspire Tech,Inc. All rights reserved.
 */
package com.wxx.shop.kafka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;

/**
 * kafka消费者
 *
 * @author wangxiaoxian
 * @version $v:1.0.0, $time:2017-04-13, $id:KafkaConsumer.java, Exp $
 */
public class KafkaConsumer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QueueChannel queueChannel = (QueueChannel) context.getBean("inputFromKafka");
        Message msg = null;
        while ((msg = queueChannel.receive(-1)) != null) {
            String map = (String) msg.getPayload();
            System.out.println(map);
        }
    }
}