package com.gzzz.service;

import com.gzzz.pojo.Student;

import java.util.List;

/**
 * className: StudentService
 * Package : com.gzzz.service
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/27 12:09
 * @Version 1.0
 */
public interface StudentService {
    /**
     * 查询所有学生业务数据
     * @return
     */
    List<Student> findAll();
}
