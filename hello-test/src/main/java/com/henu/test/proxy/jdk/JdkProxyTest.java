package com.henu.test.proxy.jdk;

import com.henu.test.proxy.User;
import com.henu.test.proxy.UserService;
import com.henu.test.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        //1 创建原始对象
        final UserService userService=new UserServiceImpl();
        //2 JDK创建动态代理
        UserService service=(UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(proxy.getClass().getName());
                        System.out.println("-----这里是proxy log------");
                        Object ret=method.invoke(userService,args);
                        return ret;
                    }
                });
        service.login("hello","123456");
        service.register(new User());
    }
}
