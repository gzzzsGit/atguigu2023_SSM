package com.gzzz.test;

import com.gzzz.mapper.EmployeeMapper;
import com.gzzz.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * className: MyBatisTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/14 2:12
 * @Version 1.0
 */
public class MyBatisTest {
    @Test
    public void test() throws IOException {
        //1.读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("myBatis-config.xml");

        //2.创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //3.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取代理mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        //5.管理资源或提交事务
        Employee employee = mapper.queryById(1);
        System.out.println("employee: " + employee);
        sqlSession.close();
    }
}
