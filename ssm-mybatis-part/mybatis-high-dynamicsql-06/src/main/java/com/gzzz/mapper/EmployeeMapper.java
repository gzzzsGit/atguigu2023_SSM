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
 * @Create 2024/2/5 2:42
 * @Version 1.0
 */
public interface EmployeeMapper {
    // 根据员工的姓名和工资查询员工的信息
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);
    List<Employee> queryTrim(@Param("name") String name, @Param("salary") Double salary);


    // 根据员工id更新员工的数据，要求传入的name和salary不为null
    int update(Employee employee);
    int updateTrim(Employee employee);

    // 根据两个条件查询，如果姓名不为null使用姓名查询，如果姓名为null，薪水不为空就用薪水查询。都为null就查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    // 根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 根据id批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);

    int insertBatch(@Param("list") List<Employee> employees);

    int updateBatch(@Param("list") List<Employee> employees);
}
