package com.practice.swiggyonlinetest;

public interface Slot {
    void setOccupied(Car car);
    void emptySlot();
    Car getCar();
    int getNearestEntryPoint();
    int getId();
}
