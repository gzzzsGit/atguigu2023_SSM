package com.gzzz;

import com.gzzz.dyn.ProxyFactory;
import com.gzzz.statics.StaticProxyCalculator;

/**
 * className: UseAop
 * Package : com.gzzz
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/11 13:33
 * @Version 1.0
 */
public class UseAop {
    public static void main(String[] args) {
        // 目标 房东
        Calculator calculator = new CalculatorPureImpl();

        // 静态代理 中介
        Calculator proxy = new StaticProxyCalculator(calculator);

        // 调用
        System.out.println(proxy.div(8, 2));

        // jdk代理
        ProxyFactory factory = new ProxyFactory(calculator);
        Calculator proxy1 = (Calculator) factory.getProxy();
        proxy1.mul(3, 4);
    }
}
