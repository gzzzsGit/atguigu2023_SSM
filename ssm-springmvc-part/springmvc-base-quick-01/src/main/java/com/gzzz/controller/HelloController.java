package com.gzzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className: HelloController
 * Package : com.gzzz.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/10 1:46
 * @Version 1.0
 */
@Controller
public class HelloController {
    // 定义handler方法  -> springmvc/hello  return "hello springmvc"
    @RequestMapping("/springmvc/hello")// 对外访问的地址， 到handlerMapping 注册的注解
    @ResponseBody
    public String hello() {
        System.out.println("HelloController.hello");
        //返回给前端
        return "hello springmvc";
    }
}
