package com.gzzz.share;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * className: ShareController
 * Package : com.gzzz.share
 * Description:
 *      TODO: 获取共享域对象
 * @Author gzzz
 * @Create 2024/2/16 2:04
 * @Version 1.0
 */
@Controller
@RequestMapping("/share")
@ResponseBody
public class ShareController {
    // 原生api
    @Autowired
    private ServletContext servletContext;
    public void data(HttpServletRequest request, HttpSession session) {
        request.setAttribute("key","value");//request
    }

    // springmvc提供的方法: 形参列表添加 Model ModelMap Map ModelAndView
    public void data1(Model model) {
        model.addAttribute("key", "value");//request
    }

    public void data2(ModelMap modelmap) {
        modelmap.addAttribute("key", "value");//request
    }

    public void data3(Map map) {
        map.put("key", "value");//request
    }

    public ModelAndView data4() {
        ModelAndView modelAndView = new ModelAndView();
        // 存入模型数据
        modelAndView.addObject("key", "value");
        //设置视图名称
        modelAndView.setViewName("视图名 页面名称");
        return modelAndView;
    }
}
