package com.practice.swiggyonlinetest;

public class CarImpl implements  Car{
    String registrationNo;
    String color;

    CarImpl(String registrationNo,String color){
        this.registrationNo = registrationNo;
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNo;
    }
}
