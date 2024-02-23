package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * className: WebMvcJavaConfig
 * Package : config
 * Description:控制层的配置类
 * TODO:
 *      1. controller
 *      2. 全局异常处理器
 *      3. handlerMapping handlerAdapter
 *      4. 静态资源处理
 *      5. jsp 视图解析器前后缀
 *      6. json转换器
 *      7. 拦截器
 * @Author gzzz
 * @Create 2024/2/23 17:16
 * @Version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.gzzz.controller","com.gzzz.exceptionhandler"})
public class WebMvcJavaConfig implements WebMvcConfigurer {
    // 配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", "jsp");
    }

    // 静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor()
    }
}
