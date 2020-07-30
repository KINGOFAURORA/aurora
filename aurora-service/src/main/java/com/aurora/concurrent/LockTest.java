package com.aurora.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        ServiceT st = new ServiceT();
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for(int i=0; i<20;i++){
            final int j =i;
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    st.function(j);
                }
            });
        }
        exec.shutdown();
    }
}

class ServiceT {
    Lock lock = new ReentrantLock();
    public void function(int val){
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(val);
    }
}