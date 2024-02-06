package test;

import com.gzzz.mapper.EmployeeMapper;
import com.gzzz.pojo.Employee;
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

    /**
     * 测试if where 标签
     * @throws IOException
     */
    @Test
    public void testInsert() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> res = mapper.query(null, 100.0);
        System.out.println(res);
    }

    @AfterEach
    public void cleanup() throws IOException {
        sqlSession.commit();
        sqlSession.close();
    }
}
