package com.gzzz.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className: PathController
 * Package : com.gzzz.path
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/13 12:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/path")
@ResponseBody
public class PathController {
    // 访问url： path/账号/密码
    // 动态路径  {key} 作用类似于*通配符，用于在形参列表接受传入的参数
    // 形参必须使用@PathVariable注解
    @RequestMapping("{account}/{password}")
    public String login(@PathVariable String account,@PathVariable String password) {
        System.out.println("account = " + account+" password = "+ password);
        return "account = "+account+" password = "+password;
    }
}
