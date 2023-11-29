package com.gzzz.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * className: JavaConfigurarion
 * Package : com.gzzz.config
 * Description:
 * java的配置类，替代xml配置文件
 * 1. 包扫描注解配置
 * 2. 引用外部的配置文件
 * 3. 生命第三方依赖的bean组件
 * <p>
 * 步骤1： 添加@Configuration 代表我们是配置类
 * 步骤2： 实现上面的三个功能注解
 *
 * @Author gzzz
 * @Create 2023/11/30 0:37
 * @Version 1.0
 */

@Configurable()
@PropertySource("classpath:druid.properties")
@ComponentScan(value = "com.gzzz.ioc_01")
public class JavaConfigurarion {

}
