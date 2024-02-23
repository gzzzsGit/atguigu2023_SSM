package generator.mapper;

import generator.com.gzzz.pojo.User;

/**
* @author 15120
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-02-07 02:01:14
* @Entity generator.com.gzzz.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
