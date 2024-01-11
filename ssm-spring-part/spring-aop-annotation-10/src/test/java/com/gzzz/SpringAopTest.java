package com.gzzz;

import com.gzzz.config.JavaConfig;
import com.gzzz.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * className: SpringAopTest
 * Package : com.gzzz
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/11 18:01
 * @Version 1.0
 */
@SpringJUnitConfig(JavaConfig.class)
public class SpringAopTest {

    @Autowired
    private Calculator calculator;// 用接口取值而不是直接用实现类，防止后期aop取不到代理对象
    //因为 aop-代理-jdk-接口-代理类- 代理对象和目标对象是兄弟关系，不是继承关系

    @Test
    public void test(){
        int add = calculator.add(1, 3);
        System.out.println("add: " + add);
    }
}
