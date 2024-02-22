package com.gzzz.json;

import com.gzzz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * className: JsonController
 * Package : com.gzzz.json
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/17 23:19
 * @Version 1.0
 */

/**
 *  TODO: @ResponseBody表示数据直接放入响应体返回，不走视图解析器
 *        所以快速查找视图，转发和重定向都不会生效
 */
@RestController// 等于@Controller+@ResponseBody
@RequestMapping("/json")
public class JsonController {
    @GetMapping("data1")
//    @ResponseBody
    public User data1() {
        User user = new User();
        user.setName("two dogs!");
        user.setAge(3);
        return user; //user -> handlerAdapter解析成 json -> @ResponseBody -> 返回json
    }

    @GetMapping("data2")
//    @ResponseBody
    public List<User> data2() {
        User user = new User();
        user.setName("two dogs!");
        user.setAge(3);

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
}
