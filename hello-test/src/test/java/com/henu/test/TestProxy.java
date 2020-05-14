package com.henu.test;

import com.henu.test.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {
    /**
     * 用于测试静态代理
     */
    @Test
    public void test() {
        UserService userService=new UserServiceProxy();
        userService.login("hello","123456");
        userService.register(new User());
        System.out.println("---------");
        OrderService orderService=new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 测试动态代理
     */
    @Test
    public void test01() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        userService.login("hello","123456");
        userService.register(new User());
    }

    @Test
    public void test02() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.showOrder();
    }
}
