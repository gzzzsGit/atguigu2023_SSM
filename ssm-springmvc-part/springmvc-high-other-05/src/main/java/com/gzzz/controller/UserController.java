package com.gzzz.controller;

import com.gzzz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * className: UserController
 * Package : com.gzzz.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/20 13:48
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    // 接收用户数据，用户有校验注解
    /**
     *  步骤1：实体类属性添加校验注解
     *  步骤2：接收参数需要添加@Validated注解
     *      注意： 如果是param方式传参，则接受参数只需要添加  @Validated
     *            如果是json方式传参，则接收参数需要添加@Validated @RequestBody
     *
     *  TODO:
     *       目前，不符合校验规则将会直接给前端抛出异常，这是不可接受的
     *       需要接受错误绑定信息，自定义返回结果！ 约定不同参数代表不同错误 -> {code:400}
     *       需要捕捉错误绑定错误信息：
     *          1. handler(校验对象，BirthdayResult result)  要求：bindingResult必须紧挨着校验对象
     *          2. bindingResult获取绑定错误
     * @param user
     * @return
     */
    @PostMapping("register")
    public Object register(@Validated @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            HashMap data = new HashMap<>();
            data.put("code", 400);
            data.put("msg", "参数校验异常");
            return data;
        }
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
