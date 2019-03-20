package com.practice.design;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorSystemDesign {
    public static void main(String args[]){

    }
}

enum Direction{
    UP,DOWN,STATIONARY
}

interface Elevator{
    void stop();
    void moveUp();
    void moveDown();
    Direction getDirection();
}

interface ElevatorSystem{
    void getCar(int floor);
    void start();
    void stop();
    void goToFloor(int floor);
}

interface Input{

}

interface ControlPanel{
    Input readInput();
    void execute(Input input);
}

class ElevatorImpl implements Elevator{
    Direction direction;
    int currentFloor;
    int totalFloor;
    PriorityQueue<Integer> upFloors;
    PriorityQueue<Integer> downFloor;

    ElevatorImpl(int currentFloor,int totalFloor){
        this.direction = Direction.STATIONARY;
        this.currentFloor = currentFloor;
        this.totalFloor = totalFloor;
        upFloors = new PriorityQueue<>();
        downFloor = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }
    @Override
    public void stop() {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }
}

class ControlPanelImpl implements ControlPanel{
    @Override
    public Input readInput() {
        return null;
    }

    @Override
    public void execute(Input input) {

    }
}

class ElevatorSystemImpl implements ElevatorSystem, ControlPanel{
    List<Elevator> elevators;
    ControlPanel controlPanel;


    @Override
    public void getCar(int floor) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void goToFloor(int floor) {

    }

    @Override
    public Input readInput() {
        return controlPanel.readInput();
    }

    @Override
    public void execute(Input input) {
        controlPanel.execute(input);
    }
}


