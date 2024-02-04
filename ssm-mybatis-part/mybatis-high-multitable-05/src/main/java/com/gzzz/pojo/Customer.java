package com.gzzz.pojo;

import lombok.Data;

import java.util.List;

/**
 * className: Customer
 * Package : com.gzzz.pojo
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/4 15:00
 * @Version 1.0
 */
@Data
public class Customer {
    private Integer customerId;
    private String customerName;

    // 一个客户对应多个订单: 一对多
    // 对多：装对方类型的集合即可
    private List<Order> orderList;
}
