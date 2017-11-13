// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.template;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/20 上午11:48
 **/
public class ExtendClass extends BaseClass<Integer> {
    @Override
    Integer create() {
        return 1;
    }

    @Override
    public void f() {
        System.out.println(element.getClass().getName());
    }
}
