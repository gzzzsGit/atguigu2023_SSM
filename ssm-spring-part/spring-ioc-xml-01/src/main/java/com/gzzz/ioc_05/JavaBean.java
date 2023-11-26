package com.gzzz.ioc_05;

/**
 * className: JavaBean
 * Package : com.gzzz.ioc_05
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/26 9:49
 * @Version 1.0
 */
public class JavaBean {
    public String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
