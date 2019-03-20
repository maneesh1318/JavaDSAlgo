package com.practice.swiggyonlinetest;

public class SlotImpl implements Slot{
    int id;
    int nearestEntryPoint;
    boolean isOccupied;
    Car car;

    SlotImpl(int id,int nearestEntryPoint){
        this.id = id;
        this.nearestEntryPoint = nearestEntryPoint;
        isOccupied = false;
        car = null;
    }

    public void setOccupied(Car car) {
        this.car = car;
        isOccupied = true;
    }

    public void emptySlot(){
        this.car = null;
        this.isOccupied = false;
    }

    public Car getCar(){
        return car;
    }

    public int getNearestEntryPoint() {
        return nearestEntryPoint;
    }

    public int getId(){
        return id;
    }
}
