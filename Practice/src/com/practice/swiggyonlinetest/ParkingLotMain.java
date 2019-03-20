package com.practice.swiggyonlinetest;

public class ParkingLotMain {
    public static void main(String args[]){
        int numberofSlots = 6;
        int entry = 3;
        ParkingLot parkingLot = ParkingLotFactory.getParkingLot(numberofSlots,entry);
        Car car0 = new CarImpl("KA-01-HH-1230","White");
        Car car1 = new CarImpl("KA-01-HH-1231","White");
        Car car2 = new CarImpl("KA-01-HH-1232","White");
        Car car3 = new CarImpl("KA-01-HH-1233","Blue");
        Car car4 = new CarImpl("KA-01-HH-1234","Blue");
        Car car5 = new CarImpl("KA-01-HH-1235","Blue");
        Car car6 = new CarImpl("KA-01-HH-1236","Blue");
        parkingLot.Park(car0,0);
        parkingLot.Park(car1,1);
        parkingLot.Park(car2,2);
        parkingLot.Park(car3,2);
        parkingLot.Park(car4,1);
        parkingLot.Park(car5,0);
        parkingLot.Park(car6,0);
        System.out.println("-------");
        parkingLot.printCarsWithColour("White");
        System.out.println("-------");
        parkingLot.unPark(car0);
        System.out.println("-------");
        parkingLot.printCarsWithColour("White");
        System.out.println("-------");
        parkingLot.Park(car6,0);
        parkingLot.Park(car1,1);
        parkingLot.printSlotWithCarColour("Blue");
        parkingLot.printSlotWithCarColour("White");
        System.out.println("Slot ID is "+ parkingLot.getSlotIdforCar(car6));


    }

}
