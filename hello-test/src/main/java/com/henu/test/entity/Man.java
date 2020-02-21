package com.henu.test.entity;

public class Man extends Person{
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Man{" +
                "password='" + password + '\'' +
                '}';
    }
}
