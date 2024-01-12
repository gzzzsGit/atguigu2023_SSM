package com.gzzz.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * className: TxAroundAdvice
 * Package : com.gzzz.advice
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/12 2:14
 * @Version 1.0
 */

//@Component
//@Aspect
public class TxAroundAdvice {
    /**
     *  环绕通知，需要在通知中，定义目标方法的执行
     */

    @Around("com.gzzz.pointcut.MyPointCut.myPc()")
    public Object transaction(ProceedingJoinPoint joinPoint) {
        // 保证目标方法的执行
        Object[] args = joinPoint.getArgs();
        Object res = null;
        try {
            // 增强代码 -》 before
            System.out.println("开启事务");
            res = joinPoint.proceed(args);
            System.out.println("关闭事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            // 必须抛出异常,否则调用者拿不到异常
            throw new RuntimeException(e);
        }finally {
            System.out.println("最终结束了，释放资源");
        }
        return res;
    }
}
