package com.gzzz.pojo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * className: User
 * Package : com.gzzz.pojo
 * Description:
 *      TODO:
 *            1. name 不为null和空字符串
 *                 字符串 @NotBlank  集合 @NotEmpty  包装类 @NotNull
 *            2. password 长度大于6
 *            3. age 必须 >= 1
 *            4. email 邮箱格式的字符串
 *            5. birthday 过去时间
 * @Author gzzz
 * @Create 2024/2/22 15:17
 * @Version 1.0
 */
public class User {
    @NotBlank
    private String name;
    @Length(min = 6)
    private String password;
    @Min(1)
    private int age;
    @Email
    private String email;
    @NotBlank
    private Date birthday;

}
