package com.gzzz.pojo;

import lombok.Data;

/**
 * className: Order
 * Package : com.gzzz.pojo
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/4 15:01
 * @Version 1.0
 */
@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;

    // 一个订单对应一个客户  一对一
    // 用一个客户对象装对应的客户信息
    private Customer customer;

}
