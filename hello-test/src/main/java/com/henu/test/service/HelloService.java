package com.henu.test.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class HelloService {
   @Resource
    HelloDao dao;

//    public void setHelloDao(HelloDao dao) {
//        this.dao = dao;
//    }
    public void test(){
        System.out.println(dao);
    }
}
