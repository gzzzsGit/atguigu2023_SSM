package com.gzzz.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * className: UserController
 * Package : com.gzzz.ioc_03
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 17:18
 * @Version 1.0
 */
@Controller
public class UserController {

    // 使用Autowired注解则不需要设置set方法
    @Autowired  // 相当于<property userService> -> 对应类型的bean装配
    // 自动装配注解(DI) : 1.ioc容器中查找符合类型的组件对象 2.设置给当前属性(di)，通过反射？
    // 默认ioc容器至少要有一个对应的bean组件，可以设置注解的required值为false来佛系装配，即允许没有对应bean组件。但是不推荐，因为调用该bean的时候会出现空指针异常
    @Qualifier(value = "userServiceImpl") // 通过@Qualifier注解指定选择同类的具体bean组件
    private UserService userService;
//    private UserService newUserServiceImpl; // 如果不设置Qualifier注解，也可以通过起首字母小写的bean组件类名来指定同类的具体bean组件

////    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    // 使用JSR注解Resource,需要先导入依赖，不指定name的时候也是优先匹配属性名字
//    @Resource(name = "userServiceImpl")
//    private UserService userService;

    public String show() {
        // 调用业务层的show
        return userService.show();
//        return newUserServiceImpl.show();//NewServiceImpl show...
    }


}
