package com.gzzz.api;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className: ApiController
 * Package : com.gzzz.api
 * Description:
 *      TODO:
 *          原生对象的获取-> 调用原生api
 * @Author gzzz
 * @Create 2024/2/15 2:29
 * @Version 1.0
 */
@Controller
@RequestMapping("/api")
@ResponseBody
public class ApiController {
    // 方案二： ServletContext 会自动装入到ioc容器，直接使用@Autowired注解自动装配就可以
    @Autowired
    private ServletContext servletContext;
    public void data(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        // ServletContext ->应用域对象
        // ServletContext 可以获取1.web应用域的配置文件信息 <context-param> 2.全局最大共享域 get/setAttribute 3.核心api getRealPath
        // 方案一：request获取  session获取
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = session.getServletContext();
    }

    @GetMapping("/data")
    public String getData() {
        String value = servletContext.getInitParameter("key");
        servletContext.setAttribute("username", "admin");
        String username = (String) servletContext.getAttribute("username");
        return "value = " + value+ " username = " + username; //value = value username = admin
    }
}
