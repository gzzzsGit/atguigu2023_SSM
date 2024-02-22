package com.gzzz.controller;

import com.gzzz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: UserController
 * Package : com.gzzz.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/20 13:48
 * @Version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    // 接收用户数据，用户有校验注解
    /**
     *  步骤1：实体类属性添加校验注解
     *  步骤2：接收参数需要添加@Validated注解
     *      注意： 如果是param方式传参，则接受参数只需要添加  @Validated
     *            如果是json方式传参，则接收参数需要添加@Validated @RequestBody
     * @param user
     * @return
     */
    @PostMapping("-")
    public User register(@Validated User user) {
        System.out.println("user = " + user);
        return user;
    }

    @GetMapping("data")
    public String data() {
        // 空指针异常
        String name = null;
        name.toString();
        return "ok";
    }

    @GetMapping("data1")
    public String data1() {
        // 算数异常
        int i=1/0; //除零异常
        return "ok";
    }
}
