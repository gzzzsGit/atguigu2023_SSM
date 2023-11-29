package com.gzzz.test;

import com.gzzz.config.JavaConfigurarion;
import com.gzzz.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * className: SpringIoCTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/30 0:56
 * @Version 1.0
 */
public class SpringIoCTest {
    @Test
    public void test(){
        // 1.创建ioc容器
        // 方法一
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfigurarion.class);

        // 方法二
        AnnotationConfigApplicationContext annotationConfigApplicationContext1 = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext1.register(JavaConfigurarion.class);
        annotationConfigApplicationContext1.refresh(); // 一点要刷新才生效

        // 获取bean
        StudentController bean = annotationConfigApplicationContext.getBean(StudentController.class);//bean:com.gzzz.ioc_01.StudentController@29215f06
        System.out.println("bean:" + bean);

        StudentController bean1 = annotationConfigApplicationContext1.getBean(StudentController.class);
        System.out.println(bean1==bean);//false

    }
}
