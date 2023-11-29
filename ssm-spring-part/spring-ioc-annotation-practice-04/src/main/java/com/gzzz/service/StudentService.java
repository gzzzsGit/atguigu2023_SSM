package com.gzzz.service;

import com.gzzz.pojo.Student;

import java.util.List;

/**
 * className: StudentService
 * Package : com.gzzz.service
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 20:51
 * @Version 1.0
 */
public interface StudentService {

    /**
     * 查询全部学员业务
     * @return
     */
    List<Student> findAll();

}
