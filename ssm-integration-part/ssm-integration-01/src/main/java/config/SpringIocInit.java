package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * className: SpringIocInit
 * Package : config
 * Description:spring的初始化类
 *
 * @Author gzzz
 * @Create 2024/2/24 15:11
 * @Version 1.0
 */
public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // rootIoC容器的初始化
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceJavaConfig.class, MapperJavaConfigNew.class, ServiceJavaConfig.class};
    }

    // webIoC容器的初始化
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    // dispatcherServlet的拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
