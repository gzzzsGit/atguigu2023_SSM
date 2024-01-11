package com.gzzz.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * className: MyPointCut
 * Package : com.gzzz
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/12 1:15
 * @Version 1.0
 */
@Component
public class MyPointCut {
    @Pointcut("execution(* com.gzzz.service.impl.*.*(..))")
    public void pc() {}

    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc() {}
}
