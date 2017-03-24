package cn.springmvc.test;

import java.io.FileNotFoundException;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import cn.springmvc.store.dao.GoodsDao;
import cn.springmvc.store.model.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml","classpath:conf/spring-mybatis.xml"})
public class GoodsTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private GoodsDao goodsDao;
	
	@BeforeClass
	public static void init() {
	    try {
	    	Log4jConfigurer.initLogging( "classpath:conf/log4j.properties" );
	    }
	    catch(Exception ex ) {
	    	System.err.println( "Cannot Initialize log4j" );
	    }
	}
	
	@Test
	public void insertGoodsTest() {
		Goods goods = new Goods();
		goods.setGoodsName("a");
		goodsDao.queryPage(goods);
		System.out.println();
	}
}
