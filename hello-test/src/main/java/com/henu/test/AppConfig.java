package com.henu.test;

import com.henu.test.service.A;
import com.henu.test.service.CImportSelector;
import com.henu.test.service.DBeanDefinitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.henu.test.service")
//@Import(value = {A.class, B.class})
//@Import(value ={CImportSelector.class})
@Import(value = {DBeanDefinitionRegistrar.class})
public class AppConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public A a(){
        return new A();
    }
}
