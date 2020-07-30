package com.aurora.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread Running");
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(thread.getState());
    }
}
