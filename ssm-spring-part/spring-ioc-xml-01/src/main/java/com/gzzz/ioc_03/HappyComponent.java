package com.gzzz.ioc_03;

/**
 * className: HappyComponent
 * Package : com.gzzz.ioc_01
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/25 10:57
 * @Version 1.0
 */
public class HappyComponent implements A{

    //默认包含无参数构造函数

    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }
}