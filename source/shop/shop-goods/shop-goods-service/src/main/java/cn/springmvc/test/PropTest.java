/**  
 * 
 * cn.springmvc  
 * PropTest.java  
 * @author wangxiaoxian
 * 2016年5月13日-下午3:04:09
 */
package cn.springmvc.test;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**  
 * 
 * @author wangxiaoxian 
 */
public class PropTest {

    @Autowired
    @Qualifier("cmppConfig")
    private Properties prop;
    
    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:conf/spring.xml");
        prop = (Properties)ac.getBean("cmppConfig");
    }
    
    @Test
    public void testProp() {
        System.out.println(prop.getProperty("cmpp.longNum"));
    }
}
