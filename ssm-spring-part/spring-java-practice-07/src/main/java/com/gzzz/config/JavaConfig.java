package com.gzzz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * className: JavaConfig
 * Package : gzzz.config
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/11 0:31
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.gzzz")
@PropertySource(value = "classpath:druid.properties")
public class JavaConfig {

    @Bean
    public DataSource dataSource(@Value("${driverClassName}") String driverName, @Value("${url}") String url,@Value("${db.username}") String username,@Value("${db.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    // 只有一个DataSource类型的Bean方法，形参名可以随意
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
        return jdbcTemplate;
    }


}
