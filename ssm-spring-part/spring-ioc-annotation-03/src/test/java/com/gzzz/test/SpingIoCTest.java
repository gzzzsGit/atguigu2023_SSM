package com.gzzz.test;

import com.gzzz.ioc_01.XxxController;
import com.gzzz.ioc_01.XxxDao;
import com.gzzz.ioc_02.JavaBean;
import com.gzzz.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    public void testIoC_02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean==bean1);//
        applicationContext.close();
    }
    
    @Test
    public void testIoC_03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController bean = applicationContext.getBean(UserController.class);

        // 场景一：ioc容器中有一个UserService对应的实现类对象
        System.out.println(bean.show());//  UserServiceImpl show...

        // 场景2: ioc容器没有默认的类型如何处理
        // @Autowired 使用它进行装配，【默认】情况下至少要求有一个bean !否则报错!可以指定佛系装配

        // 场景3:同一个类型有多个对应的组件@Autowired也会报错!无法选择!!
        // 解决1:成员属性名指定@Autowired 多个组件的时候，默认会根据成员属性名查找
        // 解决2:@Qualifier(value = "userServiceImpl")使用该注解指定获取bean的id!不能单独使用必须配合autowired

        // 优化点： @Autowired(required = true)+@QuaLifier(value = "userServiceImpl") == @Resource(name="userServiceImpl")
    }
    
    @Test
    public void testIoC_04(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        com.gzzz.ioc_04.JavaBean bean = applicationContext.getBean(com.gzzz.ioc_04.JavaBean.class);
        System.out.println("bean = " + bean);//admin
    }
}
