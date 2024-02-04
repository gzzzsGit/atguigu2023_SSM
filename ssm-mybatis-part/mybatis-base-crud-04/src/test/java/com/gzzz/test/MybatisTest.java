package com.gzzz.test;

import com.gzzz.mapper.UserMapper;
import com.gzzz.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * className: MybatisTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/3 20:31
 * @Version 1.0
 */
public class MybatisTest {
    private SqlSession sqlSession;
    @BeforeEach
    public void init() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testInsert() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("肿求椮");
        user.setPassword("123456");

        int res = mapper.insert(user);
        System.out.println(res==1?"success":"error");
        System.out.println("user.id = "+user.getId());
    }

    @Test
    public void testDelete() throws IOException{
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.delete(11);
        System.out.println(res==1?"success":"error");
    }

    @Test
    public void testUpdate(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(11);
        user.setUsername("中楸森");
        user.setPassword("I am bb");
        int res = mapper.update(user);
        System.out.println(res==1?"success":"error");
    }

    @Test
    public void testSelectOne(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectById(11);
        System.out.println(user);
    }

    @Test
    public void testSecltAll(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectAll();
        for (User user : users
             ) {
            System.out.println(user);
        }
    }
    @AfterEach
    public void cleanup() throws IOException {
        sqlSession.commit();
        sqlSession.close();
    }
}
