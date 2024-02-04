package com.gzzz.mapper;


import com.gzzz.pojo.Order;

/**
 * className: OrderMapper
 * Package : com.gzzz.mapper
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/4 15:24
 * @Version 1.0
 */
public interface OrderMapper {
    // 根据id查询订单信息和订单对应的客户
    Order queryOrderById(Integer id);

}
