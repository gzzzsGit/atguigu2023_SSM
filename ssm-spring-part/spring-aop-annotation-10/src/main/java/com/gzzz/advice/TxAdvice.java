package com.gzzz.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;

/**
 * className: TxAdvice
 * Package : com.gzzz.advice
 * Description:
 *      TODO: 使用普通方式进行事物的添加
 * @Author gzzz
 * @Create 2024/1/12 2:08
 * @Version 1.0
 */
@Component
@Aspect
@Order(10) // 指定一个优先级，值越小优先级越高。 优先级高的前置增强先执行，后置后执行
public class TxAdvice {
    @Before("com.gzzz.pointcut.MyPointCut.pc()")
    public void begin(JoinPoint joinPoint) {
        System.out.println("开启事务");
    }

    @AfterReturning(value = "com.gzzz.pointcut.MyPointCut.pc()",returning = "result")
    public void commit(JoinPoint joinPoint,Object result) {
        System.out.println(result+"关闭事务");
    }

    @AfterThrowing(value = "com.gzzz.pointcut.MyPointCut.pc()",throwing = "t")
    public void rollback(JoinPoint joinPoint,Throwable t) {
        System.out.println("事务回滚");
    }
}
