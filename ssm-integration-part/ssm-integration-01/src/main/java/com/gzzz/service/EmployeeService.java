package com.gzzz.service;

import com.gzzz.pojo.Employee;

import java.util.List;

/**
 * className: EmployeeService
 * Package : com.gzzz.service
 * Description:业务层
 *
 * @Author gzzz
 * @Create 2024/2/24 16:15
 * @Version 1.0
 */
public interface EmployeeService {
    public List<Employee> findAll();
}
