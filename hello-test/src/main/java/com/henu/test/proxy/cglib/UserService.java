package com.henu.test.proxy.cglib;

import com.henu.test.proxy.User;

public class UserService {

    public void register(User user) {
        System.out.println("userServiceimpl.register 业务运算+DAO");
    }


    public boolean login(String name, String password) {
        System.out.println("userserviceimpl.login");
        return true;
    }
}
