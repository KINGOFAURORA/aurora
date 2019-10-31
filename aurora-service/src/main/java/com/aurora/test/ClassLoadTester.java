package com.aurora.test;

public class ClassLoadTester {

    public static int a = 1;

    static {
        System.out.println("a=" + a);
    }

    public static int b = 2;

    static {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public ClassLoadTester(){
        System.out.println("a1=" + a);
        System.out.println("b1=" + b);
        a = 100;
        b = 200;
    }
}
