// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.template;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/20 上午11:52
 **/
public class ExtendClass2 extends BaseClass<Double> {
    @Override
    Double create() {
        return 2d;
    }

    @Override
    public void f() {
        System.out.println(element.getClass().getName());
    }
}
