package com.gzzz.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * className: javaBeanFactoryBean
 * Package : com.gzzz.ioc_05
 * Description:
 * 制造JavaBean的工厂Bean对象
 *
 * @Author gzzz
 * @Create 2023/11/26 9:50
 * @Version 1.0
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {
    private String valueName;

    // 使用自己的方式实例化对象并调用对象的setter方法给属性赋值
    @Override
    public JavaBean getObject() throws Exception {
        JavaBean javaBean = new JavaBean();
        javaBean.setName(valueName);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}
