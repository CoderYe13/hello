package com.henu.test.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 获取一个接口的所有实现类
 */
@Component
public class ServiceFactory implements ApplicationContextAware{

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

}
