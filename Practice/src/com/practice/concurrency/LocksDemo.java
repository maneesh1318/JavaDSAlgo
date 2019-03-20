package com.practice.concurrency;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class LocksDemo {
    public static void main(String args[]){
        T t = new T();
        Thread T1 = new Thread(t);
        Thread T2 = new Thread(t);
        T1.setName("first");
        T2.setName("second");
        T1.start();
        T2.start();

    }



}

class T implements Runnable{
    int counter = 0;
    private Lock lock = new Lock();

    @Override
    public void run() {
        while (counter < 10) {
            try {
                //lock.lock();
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + " is updating the counter");
                counter++;
                Thread.sleep(1000);
                System.out.println("Counter = " + counter);
                //lock.unlock();
            } catch (InterruptedException ex) {

            }
        }

    }
}

class Lock{

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}

class RentrantLock{
    private boolean isLocked = false;
    private int counter = 0;
    Thread t  = null;

    public synchronized void lock() throws InterruptedException{
        while (isLocked && Thread.currentThread() != t)
            wait();
        counter++;
        t = Thread.currentThread();

    }

    public synchronized void unlock(){
        if(t == Thread.currentThread())
            counter--;
        if(counter == 0){
            isLocked = false;
            notify();
        }
    }
}


