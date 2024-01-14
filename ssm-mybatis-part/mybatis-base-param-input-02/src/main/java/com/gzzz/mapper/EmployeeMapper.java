package com.gzzz.mapper;

import com.gzzz.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    int deleteById(Integer id);

    List<Employee> queryBySalary(Double salary);

    // 插入员工数据——传入复杂数据
    int insertEmp(Employee employee);

    // 根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(@Param("a") String name,@Param("b") Double salary);
}
