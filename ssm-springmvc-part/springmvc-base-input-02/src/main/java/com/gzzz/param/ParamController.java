package com.gzzz.param;

import com.gzzz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * className: ParamController
 * Package : com.gzzz.param
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/12 17:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    // 直接接收
    // 比如访问url为  /param/data?name=root&age=20
    // 1.需要方法形参和传递的参数名称一致  2.如果前端没传来参数 也不会报错
    @RequestMapping("/data1")
    @ResponseBody
    public String data1(String name, Integer age) {
        if (name == null) {
            name = "default";
        }
        System.out.println("name= " + name + " age= " + age);
        return "name: " + name + " age: " + age;
    }

    // /param/data?account=root&page=20
    // 想要account必须传递，page可以不传递
    /**
     * @RequestParam -> 指定请求参数名，默认必须传递，或者修改required属性为可以不传递。
     *                  用法：@RequestParam(value= "指定请求参数名，如果不设置，则与形参名相同"，
     *                  required = false, //默认是必须传，不传则报400异常
     *                  defaultValue = "默认值" //当设置了不必须传递时，可以设置默认值)
     */
    @RequestMapping("data2")
    @ResponseBody
    public String data2(@RequestParam(value = "account") String username, @RequestParam(required = false, defaultValue = "1") Integer page) {
        System.out.println("username = " + username+"page = "+page);
        return "username = "+username+"page = "+page;
    }

    // 特殊值
    // 一名多值 key=1&key=2 直接使用集合接值
    // 如访问/param/data3?hbs=吃&hbs=玩
    @GetMapping("data3")
    @ResponseBody
    // 如果使用集合当形参，必须添加@RequestParam注解，否则会将hbs对应的一个字符串直接赋值给集合，报错
    public String data3(@RequestParam List<String> hbs) {
        System.out.println("hbs = "+hbs);
        return "ok";
    }

    // 使用实体对象接值
    // 如用户注册  需要将对应的实体类插入到数据库
    // /param/data4?name=二狗子&age=19
    // 需要准备一个实体类，设置对应属性的get|set方法，形参列表类型为该实体类
    // 需要传的参数名和属性名一致,传没有的属性不会有影响
    @RequestMapping("/data4")
    @ResponseBody
    public String data4(User user) {
        System.out.println("user: " + user);
        return user.toString();
    }
}
