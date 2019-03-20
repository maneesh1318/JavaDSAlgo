package com.practice.thread;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 20/4/18.
 */
public class Second implements Runnable {
    public static Object lock = CommonUtil.mLock;

    @Override
    public void run() {
        synchronized (lock) {
            int i = 2;
            while(i<100){
                if(CommonUtil.turn == 1) {
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException ex){}
                    System.out.println(i);
                    i +=3;
                    CommonUtil.turn = 2;
                    lock.notifyAll();
                    try {
                        lock.wait();
                    }catch (InterruptedException ex){}
                }
                else{
                    try {
                        lock.wait();
                    }catch (InterruptedException ex){}
                }
            }
        }

    }
}
