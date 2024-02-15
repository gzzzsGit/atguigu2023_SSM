package com.gzzz.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * className: UserController
 * Package : com.gzzz.requestmapping
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/11 17:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * @RequestMapping:
     *        1. 精准地址 单个地址直接写，多个地址用{"地址1"，"地址2"}
     *        2. 模糊匹配 *可以匹配一层字符串  **可以匹配人一层字符串
     *                   /user/*  可以匹配 user/a  user/a/b不行
     *                   /user/** 可以匹配 user/a/b user/a
     *        3. 类上和方法上添加@RequestMapping的区别：
     *                   类上提取通用的访问地址（可以没有）
     *                   方法上是具体的handler地址(必须要有)
     *                   访问：类地址+方法地址
     *        4. 指定请求方式
     *                   外部访问流程：客户端 -> http (get|post|put|delete) -> dispatcherServlet -> handler
     *                   默认清空：@RequestMapping("login") 只要地址正确，任何请求方式都可以访问
     *                   指定请求方式：设置method属性，@@RequestMapping("login",RequestMethod.POST)：
     *                              此时如果不是post请求方式访问，会报405异常
     *        5. 其他注解(只能用在方法上，不能用在类上)
     *                  @GetMapping = @RequestMapping(xxx,RequestMethod.Get)
     *                  @PostMapping = @RequestMapping(xxx,RequestMethod.POST)
     *                  @PutMapping = @RequestMapping(xxx,RequestMethod.PUT)
     *                  @DeleteMapping = @RequestMapping(xxx,RequestMethod.DELETE)
     */
    // handler -> handlerMapping  指定访问地址
    @RequestMapping(value = "/login",method = RequestMethod.PUT) //将handler注册到handlerMapping
    public String login() {
        return "LOG IN";
    }

    @GetMapping("register")
    public String register() {
        return "REGISTER";
    }
}
