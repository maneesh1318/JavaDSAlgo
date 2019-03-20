package com.practice.swiggyonlinetest;

public class ParkingLotFactory {
    public static ParkingLot getParkingLot(Integer numberOfSlots,Integer numberOfEntryPoint){
        return new ParkingLotImpl(numberOfSlots,numberOfEntryPoint);
    }
}
