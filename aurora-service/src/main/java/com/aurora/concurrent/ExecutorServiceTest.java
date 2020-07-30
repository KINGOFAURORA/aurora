package com.aurora.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ThreadFactory factory = new CustomizableThreadFactory("aurora-pool-thread-");
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 100,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10),factory, new ThreadPoolExecutor.AbortPolicy());
        int i =0;
        while(i<4) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        TimeUnit.MILLISECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            i++;
        }
        executorService.shutdown();
    }
}
