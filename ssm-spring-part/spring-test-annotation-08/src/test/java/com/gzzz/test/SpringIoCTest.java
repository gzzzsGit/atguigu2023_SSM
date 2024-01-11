package com.gzzz.test;

import com.gzzz.components.A;
import com.gzzz.components.B;
import com.gzzz.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
* className: SpringIoCTest
* Package : com.gzzz.test
* Description:
 *     TODO: 使用@SpringJUnitConfig注解指定配置文件/配置类，
 *           就不需要手动创建IoC容器了
* @Author gzzz
* @Create 2024/1/11 12:02
* @Version 1.0
*/
//@SpringJUnitConfig(locations = "xxx.xml") // location指定xml配置文件
@SpringJUnitConfig(value=JavaConfig.class) // value指定配置类
public class SpringIoCTest {
    @Autowired
    private A a;

    @Autowired
    private B b;
    @Test
    public void test1(){
        // 省略了创建ioc容器、获取组件

        // 可以直接使用组件
        System.out.println(a);
    }
}
