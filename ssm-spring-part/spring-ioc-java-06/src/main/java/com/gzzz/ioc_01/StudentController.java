package com.gzzz.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * className: StudentController
 * Package : com.gzzz.ioc_01
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/30 0:35
 * @Version 1.0
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
}
