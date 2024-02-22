package com.gzzz.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className: JspController
 * Package : com.gzzz.jsp
 * Description:
 *      TODO: 快速查找视图
 *              1. 方法的返回值是字符串类型
 *              2. 不能添加@ResponseBody，因为添加注解直接返回字符串给浏览器，不会走视图解析器
 *              3. 返回值 对应中间的视图名称即可
 *
 * @Author gzzz
 * @Create 2024/2/16 23:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/jsp")
public class JspController {
    @GetMapping("index")
    public String index(HttpServletRequest request) {
        request.setAttribute("data", "hello jsp!");
        System.out.println("JspController.index");
        // 返回值对应视图名称
        return "index";
    }

    /**
     * 转发（只能转发到项目下的资源）：
     * 1. 方法的返回值为字符串
     * 2. 不能添加responseBody注解
     * 3. 返回的字符串为 forword:  +  /转发的地址·
     */
    @GetMapping("forward")
    public String forword() {
        return "forward:/jsp/index";
    }

    /**
     * 重定向
     * 1. 方法返回值为字符串类型
     * 2. 不能添加@ResponseBody注解
     * 3. 返回字符串为 redirect: + /重定向的地址
     */
    @GetMapping("redirect")
    public String redirect() {
        System.out.println("JspController.redirect");
        return "redirect:/jsp/index";
    }

    /**
     * 不使用springmvc request response路径问题；
     * 1. 转发只能是项目下的资源跳转，路径: 项目下的地址 /jsp/index 所以忽略部署application context的根路径
     * 2. 重定向项目下的资源可以是项目外的地址  重定向属于二次请求  项目下路径需要写项目下的全地址：根路径/jsp/index  不能忽略application context的地址
     * 使用springmvc路径语法；
     * "forword 路径 | redirect 路径"
     * 此时路径都省略根路径
     */

    @GetMapping("redirect/baidu")
    public String redirectBaidu() {
        System.out.println("JspController.redirectBaidu");
        return "redirect:http://www.baidu.com";
    }
}
