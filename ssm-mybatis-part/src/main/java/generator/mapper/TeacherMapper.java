package generator.mapper;

import generator.com.gzzz.pojo.Teacher;

/**
* @author 15120
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2024-02-07 02:01:14
* @Entity generator.com.gzzz.pojo.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
