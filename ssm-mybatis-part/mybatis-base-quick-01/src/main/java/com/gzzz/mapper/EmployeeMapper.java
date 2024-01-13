package com.gzzz.mapper;

import com.gzzz.pojo.Employee;

/**
 * className: EmployeeMapper
 * Package : com.gzzz.mapper
 * Description:
 *      TODO: 在Mapper中不能方法重载
 *              因为xml配置文件根据id识别方法名，无法识别重载
 * @Author gzzz
 * @Create 2024/1/13 11:27
 * @Version 1.0
 */
public interface EmployeeMapper {
    //根据id查询员工信息
    Employee queryById(Integer id);

    //根据id删除员工信息
    int deleteById(Integer id);

}
