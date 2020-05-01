package com.henu.test.config;

import com.henu.test.service.Z;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 获取一个接口的所有实现类
 */
@Component
public class ServiceFactory implements ApplicationContextAware {
    static  Map<String, Z> map;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        map=applicationContext.getBeansOfType(Z.class);

       for (Map.Entry<String, Z> entry:map.entrySet()){
           System.out.println("Key: "+entry.getKey()+" ,value:"+entry.getValue());
       }
    }

}
