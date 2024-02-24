package config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.awt.desktop.UserSessionEvent;
import java.util.Properties;

/**
 * className: MapperJavaConfigNew
 * Package : config
 * Description:方式二：不保留mybatis的xml配置文件，所有属性都在代码中设置
 *
 * @Author gzzz
 * @Create 2024/2/24 1:30
 * @Version 1.0
 */
@Configuration
public class MapperJavaConfigNew {
    // sqlSessionFactory 加入ioc容器
    // mybatis -> sqlSessionFactoryBean -> getObject() ->sqlSessionFactory
    // 方式二： 不保留mybatis的xml配置文件，所有属性都在代码中设置
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 指定mybatis的配置文件

        // Configuration存储setting标签下的信息
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // 开启完全resultMap映射
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        // 开启驼峰式映射
        configuration.setMapUnderscoreToCamelCase(true);
        // 设置日志输出
        configuration.setLogImpl(Slf4jImpl.class);
        // 存储对应xml配置文件setting标签下的配置信息
        sqlSessionFactoryBean.setConfiguration(configuration);

        // 别名设置
        sqlSessionFactoryBean.setTypeAliasesPackage("com.gzzz.pojo");

        // 配置插件信息
        // 添加分页插件PageInterceptor，插件的属性通过Properties文件设置
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

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
