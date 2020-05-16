package com.henu.test.proxy.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("------Around log-----");
       Object ret= methodInvocation.proceed();
        return ret;
    }
}
