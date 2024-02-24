package com.gzzz.mapper;

import com.gzzz.pojo.Employee;

import java.util.List;

/**
 * className: EmployeeMapper
 * Package : com.gzzz.mapper
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/24 15:22
 * @Version 1.0
 */
public interface EmployeeMapper {
    // 查询全部员工信息
    List<Employee> queryList();
}
