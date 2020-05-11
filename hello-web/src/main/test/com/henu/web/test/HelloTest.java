package com.henu.web.test;


import com.henu.dao.area.AreaDao;
import com.henu.entity.Area;
import com.henu.entity.Hello;
import com.henu.service.IAreaService;
import com.henu.service.impl.AreaServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelloTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    @Test
    public void testBunchInsertArea() {
        AreaDao areaDao=applicationContext.getBean(AreaDao.class);
        List<Area> areas=new ArrayList<>();
        for (int i = 3422; i < 3424; i++) {
            Area area=new Area();
            area.setAreaName(i+"苑");
            area.setPriority(i/3418+1);
            areas.add(area);
        }
        System.out.println(areaDao.batchInsertArea(areas));
    }
    @Test
    public void test() throws SQLException {

        DataSource dataSource = applicationContext.getBean(DataSource.class);

        IAreaService areaDao=applicationContext.getBean(IAreaService.class);

        Hello hello=applicationContext.getBean(Hello.class);
        System.out.println(hello.toString());
       // System.out.println(areaDao.queryAreaById(1));
        System.out.println(areaDao.queryAreaByMap());
    }

    @Test
    public void test01() {
        IAreaService areaService=applicationContext.getBean(IAreaService.class);

        System.out.println(areaService.getAreaList(1,2));
    }
    @Test
    public void test02() {
        AreaDao areaDao=applicationContext.getBean(AreaDao.class);

        System.out.println(areaDao.getList());
    }
}
