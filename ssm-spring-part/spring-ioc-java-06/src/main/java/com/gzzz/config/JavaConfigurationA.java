package com.gzzz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * className: JavaConfigurationA
 * Package : com.gzzz.config
 * Description:
 *
 * @Author gzzz
 * @Create 2024/1/10 2:05
 * @Version 1.0
 */

// 把配置B整合到配置A
@Import(JavaConfigurationB.class)
@Configuration
public class JavaConfigurationA {

}
