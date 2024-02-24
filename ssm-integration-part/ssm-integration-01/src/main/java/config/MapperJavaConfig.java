package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.beans.JavaBean;

/**
 * className: MapperJavaConfig
 * Package : config
 * Description:持久层配置类：设置连接池，sqlSession，Mapper代理对象
 * TODO:
 *      方式一：如果将dataSource 和 mybatis的组件配置到一起，会有@Value注解不生效的bug
 *             原因：mybatis的组件会优先加载，此时@Value还没有被读取
 *             解决办法：分开配置，写到不同的配置类
 * @Author gzzz
 * @Create 2024/2/23 22:21
 * @Version 1.0
 */
@Configuration
public class MapperJavaConfig {
    // sqlSessionFactory 加入ioc容器
    // mybatis -> sqlSessionFactoryBean -> getObject() ->sqlSessionFactory
    // 方式一： 外部指定mybatis-config.xml
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 指定配置文件等信息
        // 指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 指定外部的mybatis配置文件
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }

    /**
     * Mapper代理对象的FactoryBean
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        // 指定一个包 -> 找到mapper接口 -> sqlSessionFactory -> sqlSession -> getMapper -> 生成mapper代理对象 -> ioc容器
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.gzzz.mapper");
        return mapperScannerConfigurer;
    }
}
