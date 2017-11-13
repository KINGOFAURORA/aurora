// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.effective;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/10 下午3:54
 **/
public class ClassD extends ClassC {
    static {
        System.out.println("D");
    }

    {
        System.out.println("DD");
    }

    public static void f(){}

}
