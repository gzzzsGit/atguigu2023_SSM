package com.gzzz.mapper;

import com.gzzz.pojo.Employee;

import java.util.List;

/**
 * className: EmployeeMapper
 * Package : com.gzzz.mapper
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/6 18:28
 * @Version 1.0
 */
public interface EmployeeMapper {
    List<Employee> queryList();
}
