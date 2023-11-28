package com.gzzz.test;

import com.gzzz.ioc_01.XxxController;
import com.gzzz.ioc_01.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * className: SpingIoCTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 0:59
 * @Version 1.0
 */
public class SpingIoCTest {
    @Test
    public void testIoC1(){
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2.获取组件
        XxxController beanController = applicationContext.getBean(XxxController.class);
        XxxController beanController1 = applicationContext.getBean("controller1", XxxController.class);
        System.out.println("Controller: " + beanController);
        System.out.println("Controller1: " + beanController1);

        // ioc注解默认的组件name为类的首字母小写名
        XxxDao beanDao = (XxxDao) applicationContext.getBean("xxxDao");
        System.out.println("Dao: " + beanDao);

        // 3.关闭容器
        applicationContext.close();
    }
}
