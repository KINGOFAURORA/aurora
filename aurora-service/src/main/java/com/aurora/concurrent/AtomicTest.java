package com.aurora.concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest {
    public static void main(String[] args) {
        AtomicLong al = new AtomicLong(0);
        System.out.println(al.addAndGet(100));
        System.out.println(al.incrementAndGet());
        System.out.println(al.decrementAndGet());
    }
}
