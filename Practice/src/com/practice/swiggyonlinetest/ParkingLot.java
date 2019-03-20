package com.practice.swiggyonlinetest;

public interface ParkingLot {
    boolean Park(Car car,Integer entryPoint);
    void unPark(Car car);
    void unPark(Integer slotId);
    int getSlotIdforCar(Car car);
    void printCarsWithColour(String color);
    void printSlotWithCarColour(String color);
}
