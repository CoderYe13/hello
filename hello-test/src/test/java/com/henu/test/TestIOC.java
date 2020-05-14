package com.henu.test;


import com.henu.test.config.ServiceFactory;
import com.henu.test.entity.Man;
import com.henu.test.entity.Person;
import com.henu.test.service.A;
import com.henu.test.service.Calculator;
import com.henu.test.service.IndexService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestIOC {


    @Test
    public void test01() {
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext01.xml");
        Person person = ioc.getBean(Person.class);//这种情况会造成出现org.springframework.beans.factory.NoUniqueBeanDefinitionException:No qualifying bean of type 'com.henu.test.entity.Person' available: expected single matching bean but found 2: person,man
        // Person person = (Person) ioc.getBean("person");
        Man man = ioc.getBean(Man.class);
        System.out.println(person);
        System.out.println(man.getBooks());
        System.out.println(man.getClass());
        System.out.println(person.getClass());
        ioc.close();
    }

    @Test
    public void testAspect() {
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext01.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1, 2);
        calculator.div(1, 0);
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(IndexService.class);
    }

    @Test
    public void test03() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
        A a = context.getBean(A.class);
        System.out.println(a.getB());
    }

    @Test
    public void test04() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
        ServiceFactory serviceFactory = context.getBean(ServiceFactory.class);
        System.out.println(serviceFactory);
    }

    @Test
    public void test05() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

    }
}
