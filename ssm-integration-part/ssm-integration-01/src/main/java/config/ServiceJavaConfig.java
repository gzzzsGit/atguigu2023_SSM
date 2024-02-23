package config;

import jakarta.servlet.http.PushBuilder;
import org.aspectj.weaver.ast.Var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * className: ServiceJavaConfig
 * Package : config
 * Description:业务层配置类
 * TODO:
 *      1.service
 *      2.开始aop注解的支持aspect:  @Before @After @AfterReturning  @AfterThrowing @Around @Aspect @Order
 *      3.tx声明式事务管理： ①.对应的事务管理器实现 TransactionManager [DatasourceTransactionManager  HibernateTransactionManager... Jpa...]
 *                         ②.开启事务注解支持 @EnableTransactionManagement   @Transactional
 * @Author gzzz
 * @Create 2024/2/23 17:54
 * @Version 1.0
 */

@Configuration
@EnableTransactionManagement //开始事务注解支持
@EnableAspectJAutoProxy
public class ServiceJavaConfig {

    // 返回一个DataSourceTransactionManager事务管理器，mybatis是使用这个事务管理器
    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
