package com.gzzz.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * className: JavaBean
 * Package : com.gzzz.ioc_02
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 16:50
 * @Version 1.0
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class JavaBean {
    @PostConstruct
    public void init() {
        System.out.println("JavaBean init...");//多例模式下会调用多次
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JavaBean destroy...");// 多例模式下不会进行destroy
    }
}
