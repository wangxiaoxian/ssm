package com.wxx.shop.mq;

import com.wxx.shop.kafka.KafkaConsumer;
import com.wxx.shop.constenum.GoodsChannelEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by wangxiaoxian on 2017/4/15.
 */
@Component
public class GoodsConsumer implements KafkaConsumer {

    @Autowired
    @Qualifier(GoodsChannelEnum.GOODS_CHANNEL)
    private QueueChannel queueChannel;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @PostConstruct
    @Override
    public void init() {
        threadPoolTaskExecutor.execute(new GoodsConsumerThread());
    }

    @PreDestroy
    @Override
    public void destroy() {
        if (queueChannel != null) {
            queueChannel.clear();
        }
    }

    private class GoodsConsumerThread extends Thread {
        @Override
        public void run() {
            Message msg = null;
            while ((msg = queueChannel.receive(-1)) != null) {
                String map = (String) msg.getPayload();
                System.out.println(map);
            }
        }
    }
}
