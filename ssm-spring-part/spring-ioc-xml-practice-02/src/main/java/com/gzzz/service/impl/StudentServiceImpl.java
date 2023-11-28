package com.gzzz.service.impl;

import com.gzzz.dao.StudentDao;
import com.gzzz.pojo.Student;
import com.gzzz.service.StudentService;
import java.util.List;

/**
 * className: StudentServiceImpl
 * Package : com.gzzz.service.impl
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/27 12:14
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 查询所有学员数据业务
     * @return
     */
    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentList"+studentList);
        return studentList;
    }
}
