package com.gzzz.ioc_04;

/**
 * className: JavaBean
 * Package : com.gzzz.ioc_04
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/26 0:35
 * @Version 1.0
 */
public class JavaBean {
    /**
     *  回调方法必须是public void 组合
     *  参数列表必须为空，因为bean标签找init-mnethod默认是找这种情况
     *  命名无所谓，可以叫init也能叫aaa
     */
    public void init() {
        System.out.println("初始化方法...");
    }

    /**
     * 销毁方法
     */
    public void destroy() {
        System.out.println("销毁方法...");
    }
}
