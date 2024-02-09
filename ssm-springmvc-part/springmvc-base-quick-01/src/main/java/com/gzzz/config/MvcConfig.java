package com.gzzz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * className: MvcConfig
 * Package : com.gzzz.config
 * Description:
 *      TODO:
 *             1. controller配置容器
 *             2. 将handlerMapping handlerAdapter 加入到容器
 *
 * @Author gzzz
 * @Create 2024/2/10 1:53
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.gzzz.controller")
public class MvcConfig {
    @Bean
    public HandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public HandlerAdapter handlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }
}
