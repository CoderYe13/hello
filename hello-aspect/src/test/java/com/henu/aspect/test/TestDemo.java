package com.henu.aspect.test;

import com.henu.aspect.web.ControllerAspect;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("aspect-config.xml");

    @Test
    public void testAspect(){
        ControllerAspect calculator=ioc.getBean(ControllerAspect.class);

        System.out.println(calculator);
    }
}
