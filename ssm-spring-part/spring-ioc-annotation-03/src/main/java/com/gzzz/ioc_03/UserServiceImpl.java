package com.gzzz.ioc_03;

import org.springframework.stereotype.Service;

/**
 * className: UserServiceImpl
 * Package : com.gzzz.ioc_03
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 17:19
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public String show() {
        return "UserServiceImpl show...";
    }

}
