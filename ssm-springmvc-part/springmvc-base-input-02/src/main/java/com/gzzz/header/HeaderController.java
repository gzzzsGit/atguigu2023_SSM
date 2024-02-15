package com.gzzz.header;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.lang.model.SourceVersion;

/**
 * className: HeaderController
 * Package : com.gzzz.header
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/14 2:46
 * @Version 1.0
 */
@Controller
@RequestMapping("/header")
@ResponseBody
public class HeaderController {
    // 接收请求头需要使用@RequestHeader注解
    // 接收请求头中的Host字段，如果需要接受请求头中的其他字段，只需要将注解的value值设置为其他字段
    @GetMapping("data")
    public String data(@RequestHeader("Host") String host) {
        System.out.println("host = " + host);
        return "host = " + host;
    }
}
