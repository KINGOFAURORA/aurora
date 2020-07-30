package com.aurora.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionTest.Producer producer = new Producer(list, 10, lock, condition);
        ConditionTest.Consumer consumer = new Consumer(list, 10, lock, condition);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        executor.execute(producer);
        executor.execute(consumer);
        executor.shutdown();
    }

    static class Producer implements Runnable {

        private List<Integer> queue;
        private int maxSize;
        private Lock lock;
        private Condition condition;

        public Producer(List<Integer> queue, int maxSize, Lock lock, Condition condition) {
            this.queue = queue;
            this.maxSize = maxSize;
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock ();
                    while (queue.size() == maxSize) {
                        try {
                            System.out.println("full");
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("prod -> " + i);
                    queue.add(i);
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private List<Integer> queue;
        private int maxSize;
        private Lock lock;
        private Condition condition;

        public Consumer(List<Integer> queue, int maxSize, Lock lock, Condition condition) {
            this.queue = queue;
            this.maxSize = maxSize;
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("empty");
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = queue.remove(0);
                    System.out.println("consume -> " + i);
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
