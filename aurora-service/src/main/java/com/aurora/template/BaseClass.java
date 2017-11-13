// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.template;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/20 上午11:44
 **/
public abstract class BaseClass<T> {
    final T element;
    BaseClass(){
        element = create();
    }
    abstract T create();

    public abstract void f();

    public T getElement() {
        return element;
    }
}
