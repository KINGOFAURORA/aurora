// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午7:26
 **/
public class SubjectA implements ISubject {
    private List<IObserver> list = Lists.newArrayList();
    public void addObserver(IObserver observer) {
        list.add(observer);
    }

    public void deleteObserver(IObserver observer) {
        list.remove(observer);
    }

    public void notifyObserver() {
        for(IObserver observer : list){
            observer.update();
        }
    }
}
