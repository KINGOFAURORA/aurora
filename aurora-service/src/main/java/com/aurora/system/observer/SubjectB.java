// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.system.observer;

import java.util.Observable;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午8:14
 **/
public class SubjectB extends Observable {
    public void setMessage(){
        super.setChanged();
        super.notifyObservers();
    }
}
