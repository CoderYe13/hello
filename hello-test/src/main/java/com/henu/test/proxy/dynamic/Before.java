package com.henu.test.proxy.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {
    /**
     * 作用：需要吧运行在原始方法执行之前的功能书写在before中
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName());
        System.out.println("-----method before advice log----");
    }
}
