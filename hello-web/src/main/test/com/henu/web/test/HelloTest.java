package com.henu.web.test;

import com.henu.dao.AreaDao;
import com.henu.entity.Hello;
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

        AreaDao areaDao=applicationContext.getBean(AreaDao.class);

        Hello hello=applicationContext.getBean(Hello.class);
        System.out.println(hello.toString());
        System.out.println(areaDao.queryAreaById(1));
    }
}
