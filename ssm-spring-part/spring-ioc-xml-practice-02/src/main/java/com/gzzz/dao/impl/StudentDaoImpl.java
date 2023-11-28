package com.gzzz.dao.impl;

import com.gzzz.dao.StudentDao;
import com.gzzz.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * className: UserDaoImpl
 * Package : com.gzzz.dao.impl
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/27 10:50
 * @Version 1.0
 */
public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    // 提供给xml使用依赖注入
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        String sql = "SELECT id,name,gender,age,class classes FROM students";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentDao"+students);
        return students;
    }
}
