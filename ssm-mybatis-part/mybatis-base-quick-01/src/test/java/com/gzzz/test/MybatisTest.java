package com.gzzz.test;

import com.gzzz.mapper.EmployeeMapper;
import com.gzzz.pojo.Employee;
import com.gzzz.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * className: MybatisTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/13 12:47
 * @Version 1.0
 */
public class MybatisTest {
    @Test
    public void test1() throws IOException {
        // 1.读取外部配置文件(mybatis-config.xml)
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3.根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完释放)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.获取接口的代理对象，调用代理对象的方法，就会查找mapper接口的方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 内部拼接接口的全限定符符号、方法名，然后调用ibatis的方法查找sql语句标签
        // 代理对象内部判断是crud的哪个方法，然后把拼接好的全限定符+方法名以及1当作参数传入ibatis对应方法，
        // 所以mybatis底层依然调用ibatis
        Employee employee = mapper.queryById(1);
        System.out.println("Employee: " + employee);

        // 5.提交事务(非DQL)和释放资源
//        sqlSession.commit(); //本次没必要，因为是DQL
        sqlSession.close();
    }

    /**
     * 使用ibatis方式进行数据库调用
     */
    @Test
    public void test2() throws IOException {
        // 1.读取外部配置文件(mybatis-config.xml)
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3.根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完释放)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用sqlSession提供的crud方法进行数据库增删改查
            // selectOne  selectList / insert / update / delete 查找对应的sql语句标签，给ibatis执行
            // select两个方法的参数1(字符串)：sql标签对应的标识 = id 或者 namespace.id   参数2(Object)：执行sql语句传入的参数
        Student student= sqlSession.selectOne("kkk", 1);
        // 缺点：1.sql语句标签对应的字符串标识容易写错 2.参数只能传递一个Object，传多个参数需要整合 3.返回值是Object没有提示
        System.out.println("student: "+student);

        // 5.提交事务(非DQL)和释放资源
        //        sqlSession.commit(); //本次没必要，因为是DQL
        sqlSession.close();
    }
}
