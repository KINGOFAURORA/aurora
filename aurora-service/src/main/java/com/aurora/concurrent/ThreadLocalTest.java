package com.aurora.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    public static void main(String[] args) {
        InnerService service = new InnerService();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,4,500,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
        executor.execute(new InnerTask(service));
        executor.execute(new InnerTask(service));
        executor.execute(new InnerTask(service));
        executor.execute(new InnerTask(service));
        executor.shutdown();
    }

    static class InnerTask implements Runnable {
        private final InnerService service;
        InnerTask(InnerService service){
            this.service = service;
        }
        @Override
        public void run() {
            for(int i=0;i<4;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                service.function();
            }
        }
    }

    static class InnerService{
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        void function(){
            threadLocal.set(threadLocal.get() == null ? 0 : threadLocal.get() + 1);
            System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + "==>" + Thread.currentThread());
        }
//        Integer value = 0;
//        void function(){
//            System.out.println(Thread.currentThread().getName() + "==>" + value++);
//        }
    }
}
