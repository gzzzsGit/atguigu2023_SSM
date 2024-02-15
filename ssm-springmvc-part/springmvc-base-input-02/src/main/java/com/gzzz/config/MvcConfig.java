package com.gzzz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * className: MvcConfig
 * Package : com.gzzz.config
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/12 18:33
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.gzzz")
@EnableWebMvc // 给handlerAdapter配置了json转化器,并且还会添加RequestMappingHandlerMapping和RequestMappingHandlerAdapter
public class MvcConfig {
//    @Bean
//    public RequestMappingHandlerMapping handlerMapping() {
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    public RequestMappingHandlerAdapter handlerAdapter() {
//        return new RequestMappingHandlerAdapter();
//    }
}
