package com.gzzz.test;

import com.gzzz.mapper.EmployeeMapper;
import com.gzzz.mapper.TeacherMapper;
import com.gzzz.pojo.Employee;
import com.gzzz.pojo.Teacher;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public void test1() throws IOException {
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
        System.out.println("Employee: " + employee);
        Map<String, Object> stringObjectMap = mapper.selectEmpNameAndMaxSalary();
        System.out.println(stringObjectMap);
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //1.读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("myBatis-config.xml");

        //2.创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //3.获取SqlSession对象，默认是关闭自动提交
        // openSession(true) 自动开启事务提交，这种情况下不需要进行sqlSession.commit
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取代理mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        //5.管理资源或提交事务
        Employee employee = new Employee();
        employee.setEmpName("钟楸森");
        employee.setEmpSalary(290.00000);
        System.out.println(employee.getEmpId()); // null
        System.out.println("********************");
        int res = mapper.insertEmp(employee);
        System.out.println("affected rows:"+res);
        System.out.println(employee.getEmpId()); //主键回显
        sqlSession.commit();//DML必须提交事务
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //设置事务自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        // 插入员工
        Teacher teacher = new Teacher();
        // 自己维护主键
//        teacher.settId(UUID.randomUUID().toString().replaceAll("-", ""));

        teacher.settName("肿求椮");
        mapper.insertTeacher(teacher);

        // 关闭资源
        sqlSession.close();
    }
}
