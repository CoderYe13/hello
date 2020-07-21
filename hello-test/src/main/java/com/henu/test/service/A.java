package com.henu.test.service;



import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class A implements Z, InitializingBean, DisposableBean {
    @Resource
    private B b;

    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }
    @PostConstruct
   public void init(){
       System.out.println("-----init------");
   }
   @PreDestroy
   public void destroy(){
       System.out.println("-----destroy------");
   }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-----init------");
    }
}
