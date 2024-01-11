package com.gzzz.statics;

import com.gzzz.Calculator;

/**
 * className: StaticProxyCalculator
 * Package : com.gzzz.statics
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/11 13:34
 * @Version 1.0
 */
// 静态代理（中介），虽然解耦，仍然冗余
public class StaticProxyCalculator implements Calculator {
    private Calculator calculator;

    // 使用构造函数传入目标（房东）
    public StaticProxyCalculator(Calculator target) {
        this.calculator = target;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i +" j = " + j);
        int result = calculator.add(i, j);
        System.out.println("result = " +result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("i = " + i +" j = " + j);
        int result = calculator.sub(i, j);
        System.out.println("result = " +result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("i = " + i +" j = " + j);
        int result = calculator.mul(i, j);
        System.out.println("result = " +result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("i = " + i +" j = " + j);
        int result = calculator.div(i, j);
        System.out.println("result = " +result);
        return result;
    }
}
