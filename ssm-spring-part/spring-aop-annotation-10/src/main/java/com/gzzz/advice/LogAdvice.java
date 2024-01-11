package com.gzzz.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * className: LogAdvice
 * Package : com.gzzz.advice
 * Description:
 *      TODO: 实现增强类
 *          1.定义方法存储增强代码
 *              具体定义几个方法，根据需要插入的位置决定
 *          2.使用注解配置 指定插入目标方法的位置
 *              前置  @Before
 *              后置  @AfterReturning
 *              异常  @AfterThrowing
 *              最后  @After
 *              环绕  @Aroud
 *             try{
 *               前置
 *               目标方法执行
 *               后置
 *             }catch(){
 *                 异常
 *             }finally{
 *                 最后
 *             }
 *           3.配置切点表达式[选中插入的方法 切点]
 *           4.补全注解
 *                加入ioc容器 @Component
 *                配置切面 @Aspect = 切点+增强类
 *           5.开启aspect注解的支持
 *
 *
 * @Author gzzz
 * @Create 2024/1/11 18:11
 * @Version 1.0
 */

@Component
@Aspect
public class LogAdvice {

    /**
     * TODO: 切点表达式
     *       固定语法： execution(1 2 3.4.5(6))
     *       1.访问修饰符
     *          public / private
     *       2.方法的返回参数类型
     *          void / String
     *          如果不考虑访问修饰符和返回值！这两位（1和2）整合成一起写*
     *          注意：必须两个都不考虑才能写成*
     *       3.包的位置
     *          具体包：com.gzzz.service.impl
     *          单层模糊：com.gzzz.service.*   *代表单层模糊
     *          多层模糊：com..impl    ..代表任意层模糊
     *          细节： 多层模糊..不能开头
     *          如找所有impl包： 必须写*..impl 不能写..impl
     *       4.类的名称
     *           具体：CalculatorPureImpl
     *           模糊：*
     *           部分模糊：*Impl  表示以Impl结尾的类
     *       5.方法名 语法和类名一致
     *       6. (6)形参数列表
     *          没有参数：()
     *          有具体参数：(String,int)
     *          模糊参数：(..) 有没有、有多少个参数都可以
     *                  (String..) 第一个参数是String，后面无所谓
     *                  (..int) 最后一个参数是int，前面的无所谓
     *                  (String..int) 第一个参数是String 最后一个参数是int,中间无所谓
     *
     */


    /**
     * TODO: 切点表达式的提取和复用
     *       1. 当前类中提取
     *          定义一个空方法 public void
     *          加上注解 @Pointcut, value属性设置为切点表达式
     *          增强注解中引用该方法即可
     *       2. 创建一个存储切点的类
     *          单独维护切点表达式
     *          其他类的切点方法: 类的全限定符.方法名()
     */

    // 方式一：当类中提取
    @Pointcut("execution(* com.gzzz.service.impl.*.*(..))")
    public void pc() {}

    @Before("pc()")
    public void start() {
        System.out.println("方法开始了");
    }

    // 方式二:创建一个存储切点的类,使用类的全限定符.方法名()
    @After("com.gzzz.pointcut.MyPointCut.pc()")
    public void end() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("com.gzzz.pointcut.MyPointCut.pc()")
    public void error() {
        System.out.println("方法报错了");
    }
}
