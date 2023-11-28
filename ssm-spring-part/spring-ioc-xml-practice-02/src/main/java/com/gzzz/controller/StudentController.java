package com.gzzz.controller;

import com.gzzz.pojo.Student;
import com.gzzz.service.StudentService;

import java.util.List;

/**
 * className: StudentController
 * Package : com.gzzz.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/27 12:19
 * @Version 1.0
 */
public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll() {
        List<Student> all = studentService.findAll();
        System.out.println("最终学员数据"+all);
    }
}
