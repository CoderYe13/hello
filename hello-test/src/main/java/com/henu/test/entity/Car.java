package com.henu.test.entity;

public class Car {
    public Car() {
    }

    private Integer price;
    private String CarName;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", CarName='" + CarName + '\'' +
                '}';
    }
}
