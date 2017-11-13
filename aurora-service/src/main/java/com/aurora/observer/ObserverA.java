// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.observer;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午7:32
 **/
public class ObserverA implements IObserver{

    private ISubject subject;

    public ObserverA(ISubject subject){
        this.subject = subject;
    }

    public void update() {
        System.out.println("A");
    }
}
