package com.practice.thread;

import java.util.concurrent.locks.Lock;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 20/4/18.
 */
public class First implements Runnable {
    public static Object lock = CommonUtil.mLock;

    @Override
    public void run() {
        synchronized (lock) {
            int i = 1;
            while(i<100){
                if(CommonUtil.turn == 0) {
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException ex){}
                    System.out.println(i);
                    i +=3;
                    CommonUtil.turn = 1;
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
