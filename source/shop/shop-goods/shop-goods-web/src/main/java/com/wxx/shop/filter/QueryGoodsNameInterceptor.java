package com.wxx.shop.filter;

import com.wxx.shop.cache.cluster.RedisClusterService;
import com.wxx.shop.dao.GoodsDao;
import com.wxx.shop.constenum.GoodsChannelEnum;
import com.wxx.shop.model.Goods;
import com.wxx.shop.service.impl.GoodsServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.wxx.shop.cache.RedisUtil;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;

import java.math.BigDecimal;
import java.util.List;

/**
 * 给不同的方法来加入判断如果缓存存在数据，从缓存取数据。否则第一次从数据库取，并将结果保存到缓存 中去
 * Created by wangxiaoxian on 2017/4/11.
 */
@Component("queryGoodsNameInterceptor")
public class QueryGoodsNameInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryGoodsNameInterceptor.class);

    private static final Long EXPIRE_TIME = 6000L;//过期时间，单位秒

    @Autowired
    private GoodsDao goodsDao;
//    @Autowired
//    private RedisUtil redisUtil;
    @Autowired
    RedisClusterService redisClusterService;
    @Autowired
    @Qualifier(GoodsChannelEnum.GOODS_CHANNEL_PRODUCER)
    private MessageChannel messageChannel;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        String queryParam = invocation.getArguments()[0].toString();
        String key = GoodsServiceImpl.QUERY_GOODS_NAME_KEY_PREFIX + queryParam;

        logQueryParam(queryParam);

//        if (redisUtil.exists(key)) {
//            LOGGER.info("找到缓存数据");
//            return invocation.proceed();
//        }
        JedisCluster jedisCluster = redisClusterService.getJedisCluster();
        if (jedisCluster.exists(key)) {
            LOGGER.info("找到缓存数据");
            return invocation.proceed();
        }

        LOGGER.info("根据key={}找不到缓存数据，开始查询数据库", key);
        List<Goods> goodsList = goodsDao.queryByName(queryParam);
        Long result = set2Redis(invocation.getArguments()[0].toString(), goodsList);
        LOGGER.info("缓存设置结果{}", result);

        return invocation.proceed();
    }

    private void logQueryParam(String goodsSearchName) {
        // header中的key值决定对应消息存放在topic的哪个partition中，
        // key的计算方式实现类默认为org.apache.kafka.clients.producer.internals.DefaultPartitioner
        for (int i = 0; i < 10; i ++) {
            messageChannel.send(MessageBuilder.withPayload(goodsSearchName).setHeader(KafkaHeaders.MESSAGE_KEY, "key" + i)
                    .setHeader(KafkaHeaders.TOPIC, "goods").build());
        }
    }

    private Long set2Redis(String queryParam, List<Goods> goodsList) {
        if (CollectionUtils.isEmpty(goodsList)) {
            LOGGER.info("数据库找不到查询结果，无法缓存");
            return 0L;
        }
        StringBuffer value = new StringBuffer();
        for (Goods goods : goodsList) {
            value.append(goods.getGoodsName())
                    .append("(=")
                    .append(goods.getPrice() == null ? new BigDecimal(0) : goods.getPrice())
                    .append("元/斤)")
                    .append(",");
        }
        value.substring(0, value.length() - 1);
//        return redisUtil.set(GoodsServiceImpl.QUERY_GOODS_NAME_KEY_PREFIX + queryParam, value.toString(), EXPIRE_TIME);
        return redisClusterService.getJedisCluster().setnx(GoodsServiceImpl.QUERY_GOODS_NAME_KEY_PREFIX + queryParam, value.toString());
    }
}
