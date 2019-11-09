package com.zhihei.jdk8.defaultmethod.impl;

import com.zhihei.jdk8.defaultmethod.UserService;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-09
 * Time: 17:29:13
 * Description:
 */
class UserServiceImplTest
{

    @Test
    void run()
    {
        UserService.study();
        UserServiceImpl userService = new UserServiceImpl();
        userService.run();
        userService.work();
    }
}