package com.gzzz.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * className: GlobalExceptionHandler
 * Package : com.gzzz.error
 * Description:
 *      全局异常处理器
 * @Author gzzz
 * @Create 2024/2/20 19:40
 * @Version 1.0
 */
//@ControllerAdvice  // 返回逻辑视图，可以转发和重定向
@RestControllerAdvice // 等于@ControllerAdvicer + @ResponseBody 直接返回json字符串
public class GlobalExceptionHandler {
    // 发生异常-> ControlllerAdvice注解的类型 -> @ExceptionHandler(指定的异常) -> handler
    // 指定的异常没有查找到会查找父异常
    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e) {
        String message = e.getMessage();
        System.out.println("message: " + message);
        return message;
    }

    @ExceptionHandler(Exception.class)
    public Object ArithmeticExceptionHandler(Exception e) {
        String message = e.getMessage();
        System.out.println("message: " + message);
        return message;
    }
}
