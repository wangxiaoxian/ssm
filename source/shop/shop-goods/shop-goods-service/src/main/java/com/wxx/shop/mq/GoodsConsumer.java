package com.wxx.shop.mq;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.wxx.shop.constenum.GoodsChannelEnum;
import com.wxx.shop.kafka.KafkaConsumer;

/**
 * Created by wangxiaoxian on 2017/4/15.
 */
@Component
public class GoodsConsumer implements KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsConsumer.class);
    @Autowired
    @Qualifier(GoodsChannelEnum.GOODS_CHANNEL_CONSUMER)
    private PollableChannel pollableChannel;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @PostConstruct
    @Override
    public void init() {
        threadPoolTaskExecutor.execute(new GoodsConsumerThread());
    }

    @PreDestroy
    @Override
    public void destroy() {

    }

    private class GoodsConsumerThread extends Thread {
        @Override
        public void run() {
            Message msg = null;
            while ((msg = pollableChannel.receive(-1)) != null) {
                // 必须捕获异常，否则抛出异常后会跳出循环
                try {
                    String map = (String) msg.getPayload();
                    System.out.println(map);
                } catch (Exception e) {
                    LOGGER.error("消费goods消息出现异常", e);
                }
            }
        }
    }
}
