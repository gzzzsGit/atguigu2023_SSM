package com.gzzz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * className: JavaConfig
 * Package : com.gzzz.service.com.gzzz.config
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/11 18:00
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.gzzz")
@EnableAspectJAutoProxy //开启aspectj的注解
public class JavaConfig {
}
