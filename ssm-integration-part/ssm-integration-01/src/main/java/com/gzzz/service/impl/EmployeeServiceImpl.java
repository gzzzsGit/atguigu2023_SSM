package com.gzzz.service.impl;

import com.gzzz.mapper.EmployeeMapper;
import com.gzzz.pojo.Employee;
import com.gzzz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className: EmployeeServiceImpl
 * Package : com.gzzz.service.impl
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/24 16:16
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper; // 从代理对象自动获取
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeMapper.queryList();
        return employees;
    }
}
