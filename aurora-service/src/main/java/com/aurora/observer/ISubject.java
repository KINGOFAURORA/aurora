package com.aurora.observer;

/**
 * Created by zhangjian49 on 2017/7/5.
 */
public interface ISubject {
    void addObserver(IObserver observer);
    void deleteObserver(IObserver observer);
    void notifyObserver();
}
