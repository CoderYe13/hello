package com.henu.test.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component(value = "aFactoryBean")
public class AFactoryBean implements FactoryBean<A> {

    @Override
    public A getObject() throws Exception {

        return new A();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
