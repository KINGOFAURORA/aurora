package com.aurora.concurrent;

import java.util.concurrent.*;

public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(2);
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,10000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
        executor.execute(new SemaphoreTest.InnerTaskMain(semaphore));
        executor.execute(new SemaphoreTest.InnerTaskMain(semaphore));
        executor.execute(new SemaphoreTest.InnerTaskMain(semaphore));
        executor.execute(new SemaphoreTest.InnerTaskMain(semaphore));
        executor.execute(new SemaphoreTest.InnerTaskMain(semaphore));
    }

    private static class InnerTaskMain implements Runnable {
        Semaphore semaphore;
        InnerTaskMain(Semaphore semaphore ){
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "==>" + "Main task waiting");
                semaphore.acquire();
                TimeUnit.MILLISECONDS.sleep(2000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "==>" + "Main task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
