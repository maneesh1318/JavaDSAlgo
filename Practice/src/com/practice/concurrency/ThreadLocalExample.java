package com.practice.concurrency;

public class ThreadLocalExample {
    public static void main(String args[]){
        Runnable sharedRunnableInstance =  new T1();
        Thread t1 = new Thread(sharedRunnableInstance);
        Thread t2 = new Thread(sharedRunnableInstance);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException ex){

        }


    }


}

class T1 implements Runnable{
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100));
        try {
            Thread.sleep(100);
        }catch (InterruptedException ex){

        }
        System.out.println(threadLocal.get());

    }
}
