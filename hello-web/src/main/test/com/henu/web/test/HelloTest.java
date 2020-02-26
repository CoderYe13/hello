package com.henu.web.test;


import com.henu.dao.area.AreaDao;
import com.henu.entity.Hello;
import com.henu.service.IAreaService;
import com.henu.service.impl.AreaServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class HelloTest {

    @Test
    public void test() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DataSource dataSource = applicationContext.getBean(DataSource.class);

        IAreaService areaDao=applicationContext.getBean(IAreaService.class);

        Hello hello=applicationContext.getBean(Hello.class);
        System.out.println(hello.toString());
       // System.out.println(areaDao.queryAreaById(1));
        System.out.println(areaDao.queryAreaByMap());
    }
}
