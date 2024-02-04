package com.gzzz.mapper;

import com.gzzz.pojo.Teacher;

/**
 * className: TeacherMapper
 * Package : com.gzzz.mapper
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/16 1:00
 * @Version 1.0
 */
public interface TeacherMapper {
    int insertTeacher(Teacher teacher);

    Teacher queryById(String tId);
}
