package com.gzzz.ioc_03;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * className: NewUserServiceImpl
 * Package : com.gzzz.ioc_03
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/29 17:50
 * @Version 1.0
 */
@Service
public class NewUserServiceImpl implements UserService {
    @Override
    public String show() {
        return "NewServiceImpl show...";
    }
}
