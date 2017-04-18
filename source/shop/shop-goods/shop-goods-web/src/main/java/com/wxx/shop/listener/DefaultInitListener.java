/*
 * Copyright (c) 2017 Aspire Tech,Inc. All rights reserved.
 */
package com.wxx.shop.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 项目的默认监听器
 *
 * @author wangxiaoxian
 * @version $v:1.0.0, $time:2017-04-18, $id:ShopDefaultListener.java, Exp $
 */
public class DefaultInitListener  implements ServletContextListener {
    private final static Logger LOGGER       = LoggerFactory.getLogger(DefaultInitListener.class);
    protected static final String APP_ROOT_KEY = "APP_ROOT";
    protected static final String CONFIG_ROOT  = "configPath";
    protected String              appRootPath;

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        LOGGER.info("Initializing Web Application Context【" + sc.getRealPath("/") + "】.");
        System.setProperty(APP_ROOT_KEY, appRootPath = sc.getRealPath("/"));
        if (System.getProperty(APP_ROOT_KEY) == null) {
            System.setProperty(APP_ROOT_KEY, sc.getRealPath("/"));
            LOGGER.info("Initializing Web Application Context[" + System.getProperty(APP_ROOT_KEY) + "].");
        }
        initRootConfigPath(sc);
        intiLog(sc);
    }

    /**
     * 初始化配置文件根目录.
     */
    protected void initRootConfigPath(ServletContext sc) {
        LOGGER.info("设置系统配置文件根目录....");
        //首先从系统属性中读取
        String configPath = System.getProperty(CONFIG_ROOT);
        if (StringUtils.isEmpty(configPath)) {
            configPath = getUserDir() + "/config";
        }
        System.setProperty(CONFIG_ROOT, configPath);

        LOGGER.info("done! 配置文件根目录:" + configPath);
    }

    /**
     * 得到user.dir
     * @return user.dir
     */
    protected String getUserDir() {
        return System.getProperty("user.dir");
    }

    /**
     * 初始化日志输出文件根目录
     */
    protected void intiLog(ServletContext sc) {
    }

    public void contextDestroyed(ServletContextEvent event) {
        LOGGER.info("Web Application Context【" + appRootPath + "】 Destroyed.");
    }
}