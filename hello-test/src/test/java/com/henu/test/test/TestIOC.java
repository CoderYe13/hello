package com.henu.test.test;


import com.henu.test.entity.Man;
import com.henu.test.entity.Person;
import com.henu.test.service.Calculator;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestIOC {
    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext01.xml");

    @Test
    public void test01() {
       //Person person = ioc.getBean(Person.class);//这种情况会造成出现org.springframework.beans.factory.NoUniqueBeanDefinitionException:No qualifying bean of type 'com.henu.test.entity.Person' available: expected single matching bean but found 2: person,man
        Person person = (Person) ioc.getBean("person");
        Man man=ioc.getBean(Man.class);
        System.out.println(person);
        System.out.println(man.getBooks());
        System.out.println(man.getClass());
        System.out.println(person.getClass());
        ioc.close();
    }

    @Test
    public void testAspect(){
        Calculator calculator=ioc.getBean(Calculator.class);
        calculator.add(1,2);

        //calculator.div(1,0);
    }
}
