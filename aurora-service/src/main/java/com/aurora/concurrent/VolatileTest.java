package com.aurora.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    public static int  stop = 0;
    public static void main(String args[]) throws InterruptedException {
        Thread testThread = new Thread(){
            @Override
            public void run(){
                int i = 1;
                while(stop == 0){
//                    System.out.println("in thread: " + Thread.currentThread() + " i: " + i);
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    i++;
                }
                System.out.println("Thread stop i="+ i);
            }
        };
        testThread.start();
        Thread.sleep(1);
        stop = 1;
        System.out.println("now, in main thread stop is: " + stop);
        while(!testThread.getState().equals(Thread.State.TERMINATED)){
            System.out.println(testThread.getState());
//            if(testThread.getState().equals(Thread.State.TIMED_WAITING)
//            || testThread.getState().equals(Thread.State.WAITING)){
//                System.out.println(testThread.getState());
//            }
        }
//        testThread.join();
    }

}
