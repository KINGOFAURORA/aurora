// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.innerclass;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/25 下午2:32
 **/
public class OuterClass {

    static{
        System.out.println("Outer Class was Loaded!");
    }

    public static void loadedOuterClass(){
        System.out.println("Init Outer Class");
    }

    public static void loadInnerClass(){
        InnerClass.f();
    }

    private static class InnerClass{
        static {
            System.out.println("Inner Class was Loaded!!");
        }

        public static void f(){
            System.out.println("Inner Class Init");
        }
    }
}
