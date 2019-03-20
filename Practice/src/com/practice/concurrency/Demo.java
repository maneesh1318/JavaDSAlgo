package com.practice.concurrency;

public class Demo {
    public static void main(String args[]) {
        Object lock = new Object();
        Thread t1 = new Thread(new Thread1(lock));
        Thread t2 = new Thread(new Thread2(lock));
        Thread t3 = new Thread(new Thread3(lock));
        t1.start();
        t2.start();
        t3.start();

    }
}

class Turn{
        public static int turn = 0;
}

class Thread1 implements Runnable{
    Object lock;

    Thread1(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        int i = 1;
        synchronized (lock) {
            try {
                while (true) {
                    if (Turn.turn == 0) {
                        System.out.println(i);
                        i += 3;
                        Turn.turn = 1;
                    }
                    Thread.sleep(100);
                    lock.notifyAll();
                    lock.wait();
                }
            } catch (InterruptedException ex) {

            }
        }


    }
}

class Thread2 implements Runnable{
    Object lock;

    Thread2(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        int i = 2;
        synchronized (lock) {
            try {
                while (true) {
                    if (Turn.turn == 1) {
                        System.out.println(i);
                        i += 3;
                        Turn.turn = 2;
                    }
                    Thread.sleep(100);
                    lock.notifyAll();
                    lock.wait();
                }
            } catch (InterruptedException ex) {

            }
        }


    }
}

class Thread3 implements Runnable{
    Object lock;

    Thread3(Object lock){
        this.lock = lock;
    }
    @Override
    public void run(){
        int i = 3;
        synchronized (lock) {
            try {
                while (true) {
                    if (Turn.turn == 2) {
                        System.out.println(i);
                        i += 3;
                        Turn.turn = 0;
                    }
                    Thread.sleep(100);
                    lock.notifyAll();
                    lock.wait();
                }
            } catch (InterruptedException ex) {

            }
        }

    }
}


