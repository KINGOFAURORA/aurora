// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.jstack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/21 上午10:15
 **/
public class MainClass {

    public static Object lock = new Object();

    static class Task implements Runnable {
        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            synchronized (lock){
                calculate();
            }
        }

        public void calculate(){
            int i = 0;
            while(true){
                i++;
            }
        }
    }

    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        pool.execute(new Task());
        pool.execute(new Task());
    }
}
