package com.wxx.shop.filter;

import com.wxx.shop.dao.GoodsDao;
import com.wxx.shop.model.Goods;
import com.wxx.shop.service.impl.GoodsServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.wxx.shop.cache.RedisUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    private RedisUtil redisUtil;

    @Value("#{redisProp['redis.defaultCacheExpireTime']}")
    private Long defaultCacheExpireTime; // 缓存默认的过期时间

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        String queryParam = invocation.getArguments()[0].toString();
        String key = GoodsServiceImpl.QUERY_GOODS_NAME_KEY_PREFIX + queryParam;

        if (redisUtil.exists(key)) {
            LOGGER.info("找到缓存数据");
            return invocation.proceed();
        }

        LOGGER.info("根据key={}找不到缓存数据，开始查询数据库", key);
        List<Goods> goodsList = goodsDao.queryByName(queryParam);
        boolean result = set2Redis(invocation.getArguments()[0].toString(), goodsList);
        LOGGER.info("缓存设置结果{}", result);

        return invocation.proceed();
    }

    private boolean set2Redis(String queryParam, List<Goods> goodsList) {
        if (CollectionUtils.isEmpty(goodsList)) {
            LOGGER.info("集合为空，不设置缓存，直接返回true");
            return true;
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
        return redisUtil.set(GoodsServiceImpl.QUERY_GOODS_NAME_KEY_PREFIX + queryParam, value.toString(), EXPIRE_TIME);
    }

}
