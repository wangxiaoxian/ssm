/*
 * Copyright (c) 2017 Aspire Tech,Inc. All rights reserved.
 */
package com.wxx.shop.kafka;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * kafka消费者
 *
 * @author wangxiaoxian
 * @version $v:1.0.0, $time:2017-04-13, $id:KafkaConsumer.java, Exp $
 */
public interface KafkaConsumer {

    void init();

    void destroy();
}