package com.henu.test.service;



import javax.annotation.Resource;

public class A implements Z{
    @Resource
    private B b;

    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }
}
