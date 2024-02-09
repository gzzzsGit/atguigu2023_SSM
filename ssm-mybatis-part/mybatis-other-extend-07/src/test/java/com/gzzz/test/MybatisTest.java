package com.gzzz.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.lang.invoke.VarHandle;
import java.util.List;

/**
 * className: MybatisTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/6 19:55
 * @Version 1.0
 */
public class MybatisTest {
    private SqlSession sqlSession;
    @BeforeEach
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 测试if where 标签
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 调用之前，先设置分页数据，即当前是第几页，每页显示多少个
        PageHelper.startPage(1, 2);

        // 正常调用
        // TODO: 注意不能将两条查询装到一个分页区，必须重新再写一个startPage下再查询，再写一个Pageinfo接收
        List<Employee> list = mapper.queryList();

        // 将查询数据封装到PageInfo的分页实体类（一共有多少页，一共有多少条）
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        // PageInfo 获取分页的数据
        // 当前页的数据
        List<Employee> list1 = pageInfo.getList();
        System.out.println("list1 = " + list1);
        // 获取总条数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        // 获取总页数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        // 获取当前页数
        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        // 获取页容量
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);
    }

    @AfterEach
    public void cleanup() throws IOException {
        sqlSession.commit();
        sqlSession.close();
    }
}
