package com.gzzz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * className: MvcConfig
 * Package : com.gzzz.config
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/16 20:19
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.gzzz")
@EnableWebMvc // handlerMapping handlerAdapter 配置json解析器
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // registry可以快速添加前后缀.
        // 实际是字符串拼接操作，前缀+方法返回字符串+后缀
        registry.jsp("/",".jsp");
        // handler -> /index.jsp
    }

    /**
     * TODO: 外部请求通过dispatcherServlet会先查找handlerMapping有没有对应的handler，如果没有再查找静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//开启静态资源查找
    }
}
