package com.gzzz.mapper;

import com.gzzz.pojo.Employee;

/**
 * className: EmployeeMapper
 * Package : com.gzzz.mapper
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/14 1:07
 * @Version 1.0
 */
public interface EmployeeMapper {
    // 根据id查询员工对象
    Employee queryById(Integer id);

}
