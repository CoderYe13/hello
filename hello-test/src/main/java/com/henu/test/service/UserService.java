package com.henu.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IndexService indexService;
    public UserService(){
        System.out.println("UserService create");
    }
}
