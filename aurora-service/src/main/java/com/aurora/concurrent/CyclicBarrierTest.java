package com.aurora.concurrent;

import java.util.concurrent.*;

public class CyclicBarrierTest {
    private static CyclicBarrier barrier = new CyclicBarrier(4);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,10000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
        executor.execute(new CyclicBarrierTest.InnerTaskMain(barrier));
        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));
        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));
//        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));
//        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));
//
//        executor.execute(new CyclicBarrierTest.InnerTaskMain(barrier));
//        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));
//        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));
//        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));
//        executor.execute(new CyclicBarrierTest.InnerTaskSub(barrier));

        executor.shutdown();
    }

    private static class InnerTaskMain implements Runnable {
        CyclicBarrier barrier;
        InnerTaskMain(CyclicBarrier barrier ){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Main task waiting");
                barrier.await();
                System.out.println("Main task completed");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    private static class InnerTaskSub implements Runnable {
        CyclicBarrier barrier;
        InnerTaskSub(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Sub task doing");
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                barrier.await();
                System.out.println("Sub task completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
