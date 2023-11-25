package com.gzzz.ioc_02;

/**
 * className: UserService
 * Package : com.gzzz.ioc_02
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/25 20:20
 * @Version 1.0
 */
public class UserService {
    private UserDao userDao;
    private int age;
    private String name;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService(int age , String name ,UserDao userDao) {
        this.userDao = userDao;
        this.age = age;
        this.name = name;
    }
}
