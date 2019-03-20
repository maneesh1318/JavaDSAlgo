package com.practice.swiggyonlinetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class ParkingLotImpl implements ParkingLot {
    List<Slot> slots;
    List<Stack<Slot>> availableSlots;
    int numberOfEntryPoints;

    ParkingLotImpl(int numberOfSlots,int numberOfEntryPoints){
        this.numberOfEntryPoints = numberOfEntryPoints;
        this.availableSlots = new ArrayList<>(numberOfEntryPoints);
        slots = new ArrayList<>(numberOfSlots);
        for(int i = 0;i< numberOfEntryPoints;i++){
            availableSlots.add(new Stack());
        }
        for(int i =0 ;i < numberOfSlots;i++){
            Random random = new Random();
            int nearestEntryPoint = random.nextInt(numberOfEntryPoints);
            availableSlots.get(nearestEntryPoint).push(new SlotImpl(i,nearestEntryPoint));
        }
    }
    @Override
    public boolean Park(Car car, Integer entryPoint) {
        if(!availableSlots.get(entryPoint).isEmpty()){
            Slot slot = availableSlots.get(entryPoint).pop();
            slot.setOccupied(car);
            slots.add(slot);
            System.out.println("Allocated Slot Number " + slot.getId());
            return true;
        }
        for(int i =0;i < numberOfEntryPoints; i++){
            if(!availableSlots.get(i).isEmpty()){
                Slot slot = availableSlots.get(i).pop();
                slot.setOccupied(car);
                slots.add(slot);
                System.out.println("Allocated Slot Number " + slot.getId());
                return true;
            }
        }
        System.out.println("Sorry, parking lot is full");
        return false;
    }

    public void unPark(Car car){
        for(int i = 0;i< slots.size();i++){
            Slot slot = slots.get(i);
            int ind = -1;
            if(car.getRegistrationNumber().equals(slot.getCar().getRegistrationNumber())){
                slots.remove(slot);
                slot.emptySlot();
                availableSlots.get(slot.getNearestEntryPoint()).push(slot);
            }
        }
    }

    public void unPark(Integer slotId){
        for(int i = 0;i< slots.size();i++){
            Slot slot = slots.get(i);
            int ind = -1;
            if(slot.getId() == slotId){
                slots.remove(slot);
                slot.emptySlot();
                availableSlots.get(slot.getNearestEntryPoint()).push(slot);
            }
        }
    }

    public int getSlotIdforCar(Car car){
        for(int i = 0;i< slots.size();i++){
            Slot slot = slots.get(i);
            if(car.getRegistrationNumber().equals(slot.getCar().getRegistrationNumber())){
                return slot.getId();
            }
        }
        return -1;
    }

    public void printCarsWithColour(String color){
        System.out.println("No\tRegistration\tslot\tColor");
        int id = 0;
        for(int i = 0;i< slots.size();i++){
            Slot slot = slots.get(i);
            if(slot.getCar().getColor().equals(color)){
                System.out.println(id++ + "\t" + slot.getCar().getRegistrationNumber() + "\t" + slot.getId() + "\t" + slot.getCar().getColor());
            }
        }
    }

    public void printSlotWithCarColour(String color){
        System.out.println("No\tRegistration\tslot\tColor");
        int id = 0;
        for(int i = 0;i< slots.size();i++){
            Slot slot = slots.get(i);
            if(slot.getCar().getColor().equals(color)){
                System.out.println(id++ + "\t" + slot.getCar().getRegistrationNumber() + "\t" + slot.getId() + "\t" + slot.getCar().getColor());
            }
        }
    }
}
