package com.gzzz;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

/**
 * className: Main
 * Package : com.gzzz
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/11 14:12
 * @Version 1.0
 */
public class Main implements WebApplicationInitializer {
    /**
     * Description:
     *             每当web项目启动，就会自动调用该接口的onStartup
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("Main.onStartup");
    }

}
