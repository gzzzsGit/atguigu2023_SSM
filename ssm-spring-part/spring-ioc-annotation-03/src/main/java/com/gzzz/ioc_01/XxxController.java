package com.gzzz.ioc_01;

import org.springframework.stereotype.Controller;

/**
 *
 * description: controller类型组件
 */
@Controller(value = "controller1")// 覆盖默认的bean id，默认就是首字母小写的类名
public class XxxController {
}
