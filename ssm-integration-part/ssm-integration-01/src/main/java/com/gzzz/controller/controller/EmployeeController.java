package com.gzzz.controller.controller;

import com.gzzz.pojo.Employee;
import com.gzzz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * className: EmployeeController
 * Package : com.gzzz.controller.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/24 17:29
 * @Version 1.0
 */
@RequestMapping("/emp")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("find")
    public List<Employee> findAll() {
        List<Employee> all = employeeService.findAll();
        return all;
    }
}
