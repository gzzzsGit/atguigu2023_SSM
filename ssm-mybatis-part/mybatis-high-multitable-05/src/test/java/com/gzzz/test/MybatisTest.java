package com.gzzz.test;

import com.gzzz.mapper.CustomerMapper;
import com.gzzz.mapper.OrderMapper;
import com.gzzz.pojo.Customer;
import com.gzzz.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * className: MybatisTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/4 16:54
 * @Version 1.0
 */
public class MybatisTest {
    private SqlSession session;

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    }

    @Test
    public void testToOne(){
        // 查询订单和对应的客户
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order = mapper.queryOrderById(1);
        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void testToMany(){
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        System.out.println(customers);

        for (Customer customer : customers) {
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList: " + orderList);
        }
    }

    @AfterEach
    public void clearup() throws IOException {
        session.commit();
        session.close();
    }
}
