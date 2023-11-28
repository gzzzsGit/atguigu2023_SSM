package com.gzzz.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.gzzz.controller.StudentController;
import com.gzzz.pojo.Student;
import org.junit.jupiter.api.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * className: jabcTemplateTest
 * Package : com.gzzz.jdbc
 * Description:
 *     测试jdbcTemplate如何使用
 * @Author gzzz
 * @Create 2023/11/26 10:34
 * @Version 1.0
 */
public class jabcTemplateTest {
    @Test
    public void testForJava() throws Exception {
        /**
         * jabcTemplate 只是简化数据库的crud  不提供连接池
         * |
         * DruidDataSource 负责连接的创建和数据库驱动的注册等等
         */

        // 0.创建一个连接池对象
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("druid.properties"));
        DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        // 1. 实例化对象即可
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        String sql = "INSERT INTO students(id,name,gender,age,class) VALUES(?,?,?,?,?)";

        // 2. 调用增删改查方法即可
        int res = jdbcTemplate.update(sql, 9, "中秋森", "男", 22, "1311");//DDL DML DCL等非查询语句
//        jdbcTemplate.queryForObject()// DQL 查询单个对象
//        jdbcTemplate.query();// DQL 查询集合
        System.out.println(res);
    }
        
    @Test
    public void testForIoC(){
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2.获取jdbcTemplate组件
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);

        // 3.进行数据库的crud操作
        // 3.1 DML->update
        String sql = "INSERT INTO students(id,name,gender,age,class) VALUES(?,?,?,?,?)";

        /**
         * 参数1： String sql可以带占位符？,占位符只能替代值，不能替代关键字和容器名
         */
        int res = jdbcTemplate.update(sql, 9,"中秋森", "男", 22, "1311");
        System.out.println(res);

        // 3.2查询单条数据
        // 根据id查询学生数据  返回一个对应的实体对象
        sql = "SELECT * FROM students WHERE id = ?;";
        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                // rs 结果集
                // rowNum 行数
                // 结果集中获取列的值，赋值给实体类对象即可
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        }, 5);
        System.out.println("student: " + student);//student: Student{id=5, name='刘七', gender='男', age=19, classes='高中二班'}

        // 3.3 查询所有学生数据
        sql = "SELECT id, name, age, gender, class classes FROM students;";
        // TODO: BeanPropertyRowMapper帮助我们自助映射列和属性值！不用实现RowMapper接口了。要求列名和属性名一致，不一致需要起别名。

        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList: " + studentList);//studentList: [Student{id=1, name='张三', gender='男', age=20, classes='高中一班'}, Student{id=2, name='李四', gender='男', age=19, classes='高中二班'}, Student{id=3, name='王五', gender='女', age=18, classes='高中一班'}, Student{id=4, name='赵六', gender='女', age=20, classes='高中三班'}, Student{id=5, name='刘七', gender='男', age=19, classes='高中二班'}, Student{id=6, name='陈八', gender='女', age=18, classes='高中一班'}, Student{id=7, name='杨九', gender='男', age=20, classes='高中三班'}, Student{id=8, name='吴十', gender='男', age=19, classes='高中二班'}, Student{id=9, name='中秋森', gender='男', age=22, classes='1311'}]
    }

    /**
     * 从ioc容器中获取controller并且调用业务！内部都是ioc容器进行组装
     */
    @Test
    public void testQuerryAll(){
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        // 2.获取组件对象
        StudentController controller = applicationContext.getBean(StudentController.class);

        // 3.使用组件对象
        controller.findAll();

        // 4.关闭容器
        applicationContext.close();
    }
}
