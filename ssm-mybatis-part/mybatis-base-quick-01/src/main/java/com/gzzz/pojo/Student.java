package com.gzzz.pojo;

/**
 * className: Student
 * Package : com.gzzz.pojo
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/13 14:03
 * @Version 1.0
 */
public class Student {
    private Integer sid;
    private String sname;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
