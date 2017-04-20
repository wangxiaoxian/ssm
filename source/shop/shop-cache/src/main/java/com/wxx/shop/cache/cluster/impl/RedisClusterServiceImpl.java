/*
 * Copyright (c) 2017 Aspire Tech,Inc. All rights reserved.
 */
package com.wxx.shop.cache.cluster.impl;

import com.wxx.shop.cache.cluster.RedisClusterService;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * redis集群客户端
 *
 * @author wangxiaoxian
 * @version $v:1.0.0, $time:2017-04-20, $id:RedisClusterServiceImpl.java, Exp $
 */
public class RedisClusterServiceImpl implements RedisClusterService {

    private JedisCluster jedisCluster;

    public RedisClusterServiceImpl(String hostPortList,
                                   int connectionTimeout,
                                   int soTimeout,
                                   int maxRedirections,
                                   final GenericObjectPoolConfig poolConfig) {
        Set<HostAndPort> hostPortSet = convert2Set(hostPortList);
        jedisCluster = new JedisCluster(hostPortSet, connectionTimeout, soTimeout, maxRedirections, poolConfig);
    }

    /**
     * 将字符串格式的主机转化为集合类型
     * @param hostPortList 字符串格式的主机
     * @return Set<HostAndPort>
     */
    private Set<HostAndPort> convert2Set(String hostPortList) {
        String[] hostPortArray = hostPortList.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        for (String hostPort : hostPortArray) {
            hostAndPortSet.add(parseHostAndPort(hostPort));
        }
        return hostAndPortSet;
    }

    /**
     * 从 主机:端口 格式获取HostAndPort对象
     * @param hostPortStr 主机:端口 格式的字符串
     * @return HostAndPort对象
     */
    private HostAndPort parseHostAndPort(String hostPortStr) {
        String[] hostPort = hostPortStr.split(":");
        HostAndPort hostAndPort = new HostAndPort(hostPort[0],
                Integer.valueOf(hostPort[1]));
        return hostAndPort;
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }
}