package com.gzzz.mapper;

import com.gzzz.pojo.Customer;

import java.util.List;

/**
 * className: CustomerMapper
 * Package : com.gzzz.mapper
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/4 20:44
 * @Version 1.0
 */
public interface CustomerMapper {
    // 查询所有客户信息以及客户对应的订单信息
    List<Customer> queryList();
}
