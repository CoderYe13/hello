package com.henu.test.proxy.cglib;

import com.henu.test.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib动态代理
 */
public class CGLIBProxyTest {
    public static void main(final String[] args) {
        final UserService userService=new UserService();

        Enhancer enhancer=new Enhancer();
        enhancer.setClassLoader(CGLIBProxyTest.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("-----这里是proxy log------");
                Object ret=method.invoke(userService,objects);
                return ret;
            }
        });
        UserService service=(UserService) enhancer.create();

        service.login("hello","123456");
        service.register(new User());
    }
}
