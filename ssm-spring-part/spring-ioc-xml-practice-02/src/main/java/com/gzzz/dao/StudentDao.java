package com.gzzz.dao;

import com.gzzz.pojo.Student;

import java.util.List;

/**
 * className: Student
 * Package : com.gzzz.dao
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/27 10:49
 * @Version 1.0
 */
public interface StudentDao {
    /**
     * 数据库查询全部的学生数据
     * @return
     */
    List<Student> queryAll();
}
