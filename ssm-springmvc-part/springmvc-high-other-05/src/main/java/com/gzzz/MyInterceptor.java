package com.gzzz;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * className: MyInterceptor
 * Package : com.gzzz
 * Description:
 *      TODO: 拦截器：创建一个类实现HandlerInterceptor
 * @Author gzzz
 * @Create 2024/2/21 12:36
 * @Version 1.0
 */
public class MyInterceptor implements HandlerInterceptor {

    // 执行handler之前调用的拦截方法
    /**
     *  比如可以设置编码格式、登陆保护、权限处理
     * @param request  请求对象
     * @param response  响应对象
     * @param handler   要调用的方法对象
     * @return  true->放行  false->拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler);
        return true;
    }

    // 当handler执行完毕后触发的方法，没有拦截机制
    /**
     *  todo：比如可以对结果进行处理！ 检查敏感词并替换
     * @param request   请求
     * @param response  响应
     * @param handler   handler方法
     * @param modelAndView  返回的视图和共享域数据对象
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle");
    }

    // 整体处理完毕后的调用方法
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex    handler报错情况下的异常对象
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
