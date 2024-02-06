package com.gzzz.pojo;

import lombok.Data;

/**
 * className: Employee
 * Package : com.gzzz.pojo
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/13 11:29
 * @Version 1.0
 */

public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

    //getter | setter
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}