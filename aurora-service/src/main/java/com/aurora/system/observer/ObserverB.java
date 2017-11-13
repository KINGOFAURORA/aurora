// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.system.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午7:55
 **/
public class ObserverB implements Observer {
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    public void update(Observable o, Object arg) {
        System.out.println("ObserverB");
    }
}
