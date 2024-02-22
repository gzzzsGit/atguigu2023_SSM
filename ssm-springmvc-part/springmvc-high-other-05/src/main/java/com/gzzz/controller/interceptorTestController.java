package com.gzzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: interceptorTestController
 * Package : com.gzzz.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/22 2:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/interceptor")
public class interceptorTestController {

    @RequestMapping("method1")
    public String method1() {
        System.out.println("interceptorTestController.method1");
        return "interceptorTestController.method1";
    }

    @RequestMapping("method2")
    public String method2() {
        System.out.println("interceptorTestController.method2");
        return "interceptorTestController.method2";
    }
}
