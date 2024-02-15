package com.gzzz.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * className: SpringMvcInit
 * Package : com.gzzz.config
 * Description:
 *      TODO:
 *             目的是可以被web项目加载，会初始化ioc容器，会设置dispatcherServlet的地址
 * @Author gzzz
 * @Create 2024/2/10 18:34
 * @Version 1.0
 */
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // service mapper层的ioc容器的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // springmvc controller层的  设置项目对应的配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 配置springmvc内部自带的servlet的访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
