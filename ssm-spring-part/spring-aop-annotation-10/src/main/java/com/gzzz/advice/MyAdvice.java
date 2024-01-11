package com.gzzz.advice;

import com.alibaba.druid.sql.ast.statement.SQLPrivilegeItem;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * className: MyAdvice
 * Package : com.gzzz.advice
 * Description:
 *      定义四个增强方法，获取目标方法的信息  返回值  异常对象
 *
 *      1.定义方法-增强代码
 *      2.使用注解指定对应的位置
 *      3.配置切点表达式选中方法
 *      4.切面和ioc的配置
 *      5.开启aspectj注解的支持
 *TODO:
 *      增强方法中获取目标方法信息
 *      1.全部增强方法中，获取目标的信息(方法名，参数，访问修饰符，所属的类的信息)
 *          形参添加(JoinPoint joinPoint)
 *          joinPoint包含目标方法的信息！
 *      2.返回的结果 - @AfterReturning
 *          形参添加(Object result) 接收返回结果
 *          @AfterReturning(value="execution(* com..impl.*.*(..))",returning = "result")
 *      3.异常的信息 - @AfterThrowing
 *          形参添加(Throwable throwable) 接收异常信息
 *          @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "形参名")
 * @Author gzzz
 * @Create 2024/1/11 19:19
 * @Version 1.0
 */

@Component
@Aspect
public class MyAdvice {
    @Before("com.gzzz.pointcut.MyPointCut.myPc()")
    public void before(JoinPoint joinPoint) {
        //1.获取方法属于的类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();

        //2.获取方法名称
        String methodName = joinPoint.getSignature().getName();//获取方法名
        int modifiers = joinPoint.getSignature().getModifiers();// 获取访问修饰符
        String modifier = Modifier.toString(modifiers);

        //3.获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("simpleName:" + simpleName+" methodName:" + methodName+" modifiers:"+modifier);//simpleName:CalculatorPureImpl methodName:add modifiers:public abstract
    }

    @AfterReturning(value = "com.gzzz.pointcut.MyPointCut.myPc()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){

    }

    @After("com.gzzz.pointcut.MyPointCut.myPc()")
    public void after(JoinPoint joinPoint) {

    }

    @AfterThrowing(value = "com.gzzz.pointcut.MyPointCut.myPc()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable) {

    }
}
