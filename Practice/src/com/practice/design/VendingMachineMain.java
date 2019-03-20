package com.practice.design;

import java.util.List;
import java.util.Map;

public class VendingMachineMain {
    public static void main(String args[]){

    }
}

abstract class Product{
    int id;
    String name;
    double price;

    Product(int id,String name,double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class SampleProduct1 extends Product{
    SampleProduct1(int id,String name, double price){
        super(id,name,price);
    }
}

class SamleProduct2 extends Product{
    SamleProduct2(int id,String name, double price){
        super(id,name,price);
    }
}

interface VendingMachineState{
    void execute(VendingMachineAbstract vendingMachine);
}

class SelectProductState implements  VendingMachineState{
    @Override
    public void execute(VendingMachineAbstract vendingMachine) {

    }
}

class MakePaymentStateState implements  VendingMachineState{
    @Override
    public void execute(VendingMachineAbstract vendingMachine) {

    }
}

class DispenseProductState implements  VendingMachineState{
    @Override
    public void execute(VendingMachineAbstract vendingMachine) {

    }
}


interface VendingMachine{
    void reset();
    void start();
    void stop();
}

abstract class VendingMachineAbstract  implements  VendingMachine,VendingMachineState{
    Map<Product,Integer> inventory;
    List<VendingMachineState> states;
    int currState;

    VendingMachineAbstract(Map<Product,Integer> inventory,List<VendingMachineState> states){
        this.inventory = inventory;
        this.states = states;
        currState = 0;
    }

    VendingMachineState getCurrentState(){
        return states.get(currState);
    }

    void nextState(){
        currState++;
    }

    void prevState(){
        currState--;
    }
}

class VendingMachineImpl extends VendingMachineAbstract{

    VendingMachineImpl(Map<Product,Integer> inventory,List<VendingMachineState> states){
        super(inventory,states);
    }

    @Override
    public void execute(VendingMachineAbstract vendingMachine) {
        states.get(currState).execute(vendingMachine);
    }

    @Override
    public void reset() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

}

class VendingMachineFactory{
    public static VendingMachineAbstract getVendingMachine(Map<Product,Integer> inventory,List<VendingMachineState> states){
        return new VendingMachineImpl(inventory,states);
    }
}







