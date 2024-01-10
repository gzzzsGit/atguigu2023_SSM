package com.gzzz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * className: JavaConfigurarion
 * Package : com.gzzz.config
 * Description:
 * java的配置类，替代xml配置文件
 * 1. 包扫描注解配置
 * 2. 引用外部的配置文件
 * 3. 声明第三方依赖的bean组件
 * <p>
 * 步骤1： 添加@Configuration 代表我们是配置类
 * 步骤2： 实现上面的三个功能注解
 *
 * @Author gzzz
 * @Create 2023/11/30 0:37
 * @Version 1.0
 */

@Configuration()
@PropertySource("classpath:druid.properties")
@ComponentScan(value = "com.gzzz.ioc_01")
public class JavaConfigurarion {
    @Value("${jdbc.user}")
    String username;
    @Value("${jdbc.password}")
    String password;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driver}")
    String driverClassName;


    /**
     * <bean> -> 一个方法
     * <p>
     * 方法的返回值类型 == bean组件的类型或者他的接口和父类
     * 方法的名字 = bean id
     * <p>
     * 方法体可以自定义实现过程
     * 最重要的一步：使用@bean注解会让配置类的方法创建的组件存储到ioc容器当中
     * <p>
     * 问题1： beanName的问题
     * 默认： 方法名
     * 指定： 设置name/ value属性覆盖原方法名
     * 问题2： 周期方法如何指定？
     * 原有注解方案：@PostConstruct + @PreDestroy
     * 设置bean的属性 initMethod / destroyMethod 指定：
     * 问题3： 作用域
     * 和以前还是一样@Scope注解，默认是单例
     * <p>
     * 问题4： 如何引用其他的ioc组件
     * 直接调用对方的bean方法即可
     * 直接形参变量进行引入，要求必须有对应的组件，如果有多个，则让形参名=组件id
     *
     * @return
     */

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "ergouzi")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // JdbcTemplate -> DataSource
    @Bean
    public JdbcTemplate jdbcTemplate() {
        // 需要DataSource 也就是需要ioc容器的其他组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        // 方案1： 如果其他组件也是@Bean方法，可以直接调用 | 从ioc容器中获取组件
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        // 需要DataSource 也就是需要ioc容器的其他组件
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//
//        // 方案2：形参列表声明想要的组件类型，可以是一个也可以是多个，ioc容器会自动注入
//        // 如果没有对应类型的组件会报错
//        // 如果有多个对应类型的组件，可以使用形参名等于其中一个对应的bean id标识，否则也会报错
//        jdbcTemplate.setDataSource(dataSource);
//        return jdbcTemplate;
//    }
}
