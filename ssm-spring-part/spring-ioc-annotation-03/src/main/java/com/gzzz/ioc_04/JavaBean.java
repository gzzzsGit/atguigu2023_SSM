package com.gzzz.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * className: JavaBean
 * Package : com.gzzz.ioc_04
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 18:31
 * @Version 1.0
 */
@Component
public class JavaBean {
    // 直接赋值
    private String name = "二狗子";

    // 注解赋值
    // 这没什么意义，相当于直接赋值
    @Value("22")
    private int age;

    // 读取外部配置，还是先设置xml的context:property-placeholder,然后使用"${}"引用
//    @Value("${password}")
    // 默认值语法 @Value("${key:value默认值}")
    @Value("${password:admin}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
