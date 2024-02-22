package com.gzzz.config;


import com.gzzz.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * className: MvcConfig
 * Package : com.gzzz.config
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/20 14:10
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.gzzz")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    /**
     *  开启静态资源查找
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置方案1： 拦截全部请求
//        registry.addInterceptor(new MyInterceptor());

        // 配置方案2：指定地址拦截
        // 可以使用通配符 *匹配任意一层字符串，**匹配任意多层字符串
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/interceptor/method1");

        // 配置方案3：排除指定地址
        // 排除的地址应该在拦截地址内部
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("interceptor/*").excludePathPatterns("/interceptor/method2");

    }
}
