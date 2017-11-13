// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.effective;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/10 下午3:49
 **/
public class ClassB {

    static {
        System.out.println("B");
    }

    {
        System.out.println("BB");
    }

    public void test(){}
}
