package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * className: DataSourceJavaConfig
 * Package : config
 * Description:连接池的配置类
 *
 * @Author gzzz
 * @Create 2024/2/23 23:25
 * @Version 1.0
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceJavaConfig {
    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${url}")
    private String url;

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${maxActive}")
    private int maxActive;

    @Value("${initialSize}")
    private int initialSize;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        return dataSource;
    }
}
