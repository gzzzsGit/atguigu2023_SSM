package com.gzzz.test;

import com.gzzz.config.JavaConfig;
import com.gzzz.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * className: SprinIoCTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/11 0:42
 * @Version 1.0
 */
public class SprinIoCTest {
    @Test
    public void test1(){
        ApplicationContext appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController controller = appContext.getBean(StudentController.class);
        controller.findAll();
    }
}
