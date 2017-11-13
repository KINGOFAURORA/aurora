// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.adapter;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/14 下午7:02
 **/
public class ClassCAdapter implements IClassCommon {

    private ClassCommonC c = new ClassCommonC();

    public void f1() {
        c.f3();
    }

    public void f2() {
        c.f4();
    }
}
