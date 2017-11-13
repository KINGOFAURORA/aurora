// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.effective;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/10 下午3:51
 **/
public class ClassC extends ClassB {
    static {
        System.out.println("C");
    }

    {
        System.out.println("CC");
    }

    public void test(){}
}
