package com.gzzz.pojo;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinitions;

/**
 * className: Employee
 * Package : com.gzzz.pojo
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/23 17:07
 * @Version 1.0
 */
@Data
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
