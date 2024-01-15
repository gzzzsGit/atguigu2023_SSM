package com.gzzz.mapper;

import com.gzzz.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    // dml语句(插入 修改 删除)
    int deleteById(Integer id);

    // 根据id查询员工工资
    Double querySalaryById(Integer id);

    // 根据员工id查询姓名
    String queryNameById(Integer id);

    Employee queryById(Integer id);

    // 返回部门的最高工资和平均工资
    Map<String, Object> selectEmpNameAndMaxSalary();

    // 插入员工数据
    int insertEmp(Employee employee);
}