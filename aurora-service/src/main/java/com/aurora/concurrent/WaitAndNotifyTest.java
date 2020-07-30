package com.aurora.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitAndNotifyTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int maxSize = 10;
        Producer p = new Producer(list, maxSize);
        Consumer c = new Consumer(list, maxSize);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,100, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
        executor.execute(p);
        executor.execute(c);
        executor.shutdown();
    }
}

class Producer implements Runnable {

    private List<Integer> queue;
    private int maxSize;

    public Producer(List<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
//        while (true) {
//            synchronized (queue) {
//                while (queue.size() == maxSize) {
//                    try {
//                        System.out.println("Queue is Full");
//                        queue.wait();
//                    } catch (InterruptedException ie) {
//                        ie.printStackTrace();
//                    }
//                }
//                Random random = new Random();
//                int i = random.nextInt();
//                System.out.println("Produce " + i);
//                queue.add(i);
//                queue.notifyAll();
//            }
//        }
        while (true){
            synchronized (queue) {
                while(queue.size() == maxSize){
                    try {
                        System.out.println("full");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("prod -> " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable {

    private List<Integer> queue;
    private int maxSize;

    public Consumer(List<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
//        while (true) {
//            synchronized (queue) {
//                while (queue.isEmpty()) {
//                    System.out.println("Queue is Empty");
//                    try {
//                        queue.wait();
//                    } catch (InterruptedException ie) {
//                        ie.printStackTrace();
//                    }
//                }
//                int v = queue.remove(0);
//                System.out.println("Consume " + v);
//                queue.notifyAll();
//            }
//        }
        while(true){
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("empty");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = queue.remove(0);
                System.out.println("consume -> " + i);
                queue.notifyAll();
            }
        }
    }
}