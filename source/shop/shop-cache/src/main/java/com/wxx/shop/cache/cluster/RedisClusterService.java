package com.wxx.shop.cache.cluster;

import redis.clients.jedis.JedisCluster;

/**
 * redis集群客户端
 * Created by wangxiaoxian on 2017/4/20.
 */
public interface RedisClusterService {
    JedisCluster getJedisCluster();
}
