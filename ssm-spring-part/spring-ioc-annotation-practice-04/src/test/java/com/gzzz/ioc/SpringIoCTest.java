package com.gzzz.ioc;

import com.gzzz.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * className: SpringIoCTest
 * Package : com.gzzz.ioc
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 21:01
 * @Version 1.0
 */
public class SpringIoCTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.findAll();
    }
}
