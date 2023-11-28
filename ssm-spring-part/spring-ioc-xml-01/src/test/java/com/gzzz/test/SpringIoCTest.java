package com.gzzz.test;

import com.gzzz.ioc_03.HappyComponent;
import com.gzzz.ioc_04.JavaBean2;
import com.gzzz.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * className: SpringIoCTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/25 22:48
 * @Version 1.0
 */
public class SpringIoCTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        Object happyComponent1 = applicationContext.getBean("happyComponent1");
        Object happyComponent2 = applicationContext.getBean("happyComponent2");
        System.out.println(happyComponent1==happyComponent2);//false
    }
    /**
     * 讲解如何创建ioc容器并读取配置文件
     */
    @Test
    public void createIoC() {
        // 创建容器 选择合适的容器实现即可
        /**
         * 接口
         *    BeanFactory
         *    ApplicationContext
         *
         * Application的实现类: 可以直接通过构造函数实例化
         *    ClassPathXmlApplicationContext       读取类路径下的xml配置方式  编译后的classes路径下
         *    FileSystemApplicationContext         读取指定文件位置的xml配置
         *    AnnotationConfigApplicationContext   读取配置类方式的ioc容器
         *    WebApplicationContext                web项目专属的配置容器
         *
         */

        // 方式一：直接创建容器并且指定配置文件即可(推荐)
        // 构造函数(String...配置文件) 可以填写一个或者多个
        // IoC  DI
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // 方式二: 先创建ioc容器对象，在指定配置文件，再刷新使生效
        // 这也是方式一源码的配置过程！
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();

        classPathXmlApplicationContext.setConfigLocations("spring-03.xml");
        classPathXmlApplicationContext.refresh();//调用ioc和di的流程，这里才是触发ioc和di的动作

    }

    /**
     *  讲解如何在IoC容器中获取组件Bean
     */
    @Test
    public void getBeanFromIoC() {
        // 1.创建ioc容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        applicationContext.refresh();//调用ioc和di的流程，这里才是触发ioc和di的动作

        // 2.读取ioc容器的组件
        // 方案一： 直接根据beanID获取即可, 当是这种方式返回的类型是Object，需要强制转换，不推荐
        HappyComponent happyComponent1 = (HappyComponent) applicationContext.getBean("happyComponent");
        // 方案二：根据beanID，同时指定bean的类型Class，这样就不用强制类型转换了
        HappyComponent happyComponent2 = applicationContext.getBean("happyComponent", HappyComponent.class);

        // 方案三：直接根据类型获取
        // 这种方式需要在ioc容器中，同一个类型只有一个bean，如果有多个，则会出现NoUniqueBeanDefinitionException
        HappyComponent happyComponent3 = applicationContext.getBean(HappyComponent.class);
        // TODO: ioc的配置虽然一定是实现类，但是getBean可以根据接口类型获取对象
//        HappyComponent happyComponent3 = applicationContext.getBean(A.class);

        happyComponent1.doWork();

        // 因为Bean标签没有设置scope属性，默认为单例，所以只声明了一个对象，只是取了三次同一个对象
        System.out.println(happyComponent1==happyComponent2 && happyComponent1==happyComponent3);//true
    }
    
    @Test
    public void test_04(){
        // 1.创建ioc容器，就会进行组件对象的实例化
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");//初始化方法...

        // 测试多例模式
        JavaBean2 bean1 = applicationContext.getBean(JavaBean2.class);
        JavaBean2 bean2 = applicationContext.getBean(JavaBean2.class);
        System.out.println(bean2==bean1);//false

        // 如果没有以下步骤，destroy方法不会被调用，因为test_04程序执行完弹出栈ioc容器就释放了，没来得及调用
        // 2.正常结束ioc容器
        applicationContext.close();//销毁方法
    }
    
    @Test
    public void test_05(){
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        // 2.读取组件
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println("JavaBean: " + javaBean);//JavaBean: com.gzzz.ioc_05.JavaBean@4cc8eb05

        // TODO：FactoryBean工厂也会加入ioc容器，name 为 &id(id是所创建bean对象的id)
        Object factoryBean = applicationContext.getBean("&javaBean");
        System.out.println("factoryBean: " + factoryBean);//factoryBean: com.gzzz.ioc_05.JavaBeanFactoryBean@51f116b8

        System.out.println(javaBean.toString());//JavaBean{name='二狗子'}

        // 3.正常结束ioc容器
        applicationContext.close();
    }
}
