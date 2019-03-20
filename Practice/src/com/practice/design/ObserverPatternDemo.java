package com.practice.design;

import java.util.Observable;
import java.util.Observer;

public class ObserverPatternDemo {
    public static void main(String args[]){
        Subject subject = new Subject();
        subject.setState(1);
        subject.setState(2);
        subject.setState(3);

    }
}

class Subject extends Observable{
    int state;

    Subject(){
        state = 0;
        addObserver(new Observer1());
        addObserver(new Observer2());
        addObserver(new Observer3());
    }

    int getState(){
        return state;
    }

    void setState(int state){
        this.state = state;
        setChanged();
        notifyObservers();
        clearChanged();
    }


}

class Observer1 implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer 1 is called");
    }
}


class Observer2 implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer 2 is called");
    }
}

class Observer3 implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer 3 is called");
    }
}