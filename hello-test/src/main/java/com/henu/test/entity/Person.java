package com.henu.test.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

public void init(){
    System.out.println("我出来了");
}

public void destory(){
    System.out.println("我结束了");
}
    private String userName;
    private Integer age;
    private Car car;
    private Map<String,Book> books;
    Properties properties;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Map<String,Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String,Book> books) {
        this.books = books;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", books=" + books +
                ", properties=" + properties +
                '}';
    }
}
