package com.wxx.shop.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wxx.shop.cache.RedisUtil;
import com.wxx.shop.dao.GoodsDao;
import com.wxx.shop.model.Goods;
import com.wxx.shop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
    public static final String QUERY_GOODS_NAME_KEY_PREFIX = "query_goods_";
    @Autowired
    private GoodsDao           goodsDao;
    @Autowired
    private RedisUtil          redisUtil;
    @Autowired
    @Qualifier("inputToKafka")
    private MessageChannel     messageChannel;
    @Autowired
    @Qualifier("inputToKafka")
    private QueueChannel       queueChannel;

    @Override
    public List<Goods> queryPage(Goods condition) {

        List<Goods> list = goodsDao.queryPage(condition);
        return list;
    }

    @Override
    public List<String> queryByName(String goodsSearchName) {
        String result = (String) redisUtil.get(QUERY_GOODS_NAME_KEY_PREFIX + goodsSearchName);
        if (StringUtils.isEmpty(result)) {
            return Collections.EMPTY_LIST;
        }
        List<String> list = Arrays.asList(result.split(","));
        messageChannel.send(MessageBuilder.withPayload("hello=" + goodsSearchName).setHeader("messageKey", "bar")
            .setHeader("topic", "test").build());
		consume();
        return list;
    }

    public void consume() {
        Message msg = null;
        while ((msg = queueChannel.receive(-1)) != null) {
            String map = (String) msg.getPayload();
            System.out.println(map);
        }
    }
}
