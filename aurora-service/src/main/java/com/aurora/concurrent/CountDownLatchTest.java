package com.aurora.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    private static CountDownLatch latch = new CountDownLatch(4);
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,10000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
        executor.execute(new InnerTaskMain(latch));
        executor.execute(new InnerTaskSub(latch));
        executor.execute(new InnerTaskSub(latch));
        executor.execute(new InnerTaskSub(latch));
        executor.execute(new InnerTaskSub(latch));

        executor.execute(new InnerTaskMain(latch));
        executor.execute(new InnerTaskSub(latch));
        executor.execute(new InnerTaskSub(latch));
        executor.execute(new InnerTaskSub(latch));
        executor.execute(new InnerTaskSub(latch));
        executor.shutdown();
    }

    private static class InnerTaskMain implements Runnable {
        CountDownLatch latch;
        InnerTaskMain(CountDownLatch latch ){
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Main task waiting");
                latch.await();
                System.out.println("Main task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class InnerTaskSub implements Runnable {
        CountDownLatch latch;
        InnerTaskSub(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Sub task doing");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sub task completed!");
            latch.countDown();
        }
    }
}
