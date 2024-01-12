package com.gzzz.test;

import com.gzzz.service.Calculator;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * className: SpringAopTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/12 13:17
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:spring.xml")
public class SpringAopTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.div(1, 1);
        System.out.println("add: " +add);
    }
}
