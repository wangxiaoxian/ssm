package com.wxx.shop.mq;

import com.wxx.shop.kafka.KafkaConsumer;
import com.wxx.shop.kafka.constenum.GoodsChannelEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by wangxiaoxian on 2017/4/15.
 */
@Service
public class GoodsConsumer extends KafkaConsumer {

    @Autowired
    @Qualifier(GoodsChannelEnum.GOODS_CHANNEL)
    private QueueChannel queueChannel;

    @PostConstruct
    public void init() {
        super.init(1);

        executorService.submit(new GoodsConsumerThread());
    }

    @PreDestroy
    @Override
    public void destroy() {
        super.destroy();

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
