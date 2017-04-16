/*
 * Copyright (c) 2017 Aspire Tech,Inc. All rights reserved.
 */
package com.wxx.shop.kafka.demo;

/**
 * kafka生产者
 *
 * @author wangxiaoxian
 * @version $v:1.0.0, $time:2017-04-13, $id:KafkaProducer.java, Exp $
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

public class KafkaProducer {

    public static void main(String[] args) {
        //ApplicationContext context =new ClassPathXmlApplicationContext("spring-produce.xml");
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-produce.xml",
            KafkaProducer.class);
        context.start();

        MessageChannel messageChannel = (MessageChannel) context.getBean("inputToKafka");
        for (int i = 0; i < 15; i++) {
            Message<String> message = new GenericMessage<String>("test-------------");
            boolean flag = messageChannel.send(message);

            //boolean flag = messageChannel.send(message, 2 * 1000);
            System.out.println(flag);
        }

        try {
            System.out.println("Thread.sleep===========================");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.close();
    }

}