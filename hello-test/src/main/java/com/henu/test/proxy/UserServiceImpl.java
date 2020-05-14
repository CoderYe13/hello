package com.henu.test.proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void register(User user) {
        System.out.println("userServiceimpl.register 业务运算+DAO");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("userserviceimpl.login");
        return true;
    }
}
