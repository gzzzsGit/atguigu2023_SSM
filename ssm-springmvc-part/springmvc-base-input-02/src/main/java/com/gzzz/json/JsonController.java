package com.gzzz.json;

import com.gzzz.pojo.Person;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * className: JsonController
 * Package : com.gzzz.json
 * Description:
 *

 * @Author gzzz
 * @Create 2024/2/13 13:32
 * @Version 1.0
 */
@RequestMapping("/json")
@Controller
@ResponseBody
public class JsonController {

    @PostMapping("data")
    // 需要使用post方法 在请求体中传入json数据
    // 如果前端直接传递json会报415错 不支持的数据类型。 因为java原生的api只支持路径参数和param参数，不支持json
    // TODO: 1. 导入json处理的依赖 2.handlerAdapter配置json转化器  @EnableWebMvc
    public String data(@RequestBody Person person) {
        System.out.println("person = " + person);
        return person.toString();
    }
}
