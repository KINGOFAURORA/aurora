package com.aurora.composite;

/**
 * Created by zhangjian49 on 2017/7/24.
 */
public interface Component {
    void add(Component component);
    void remove(Component component);
}
