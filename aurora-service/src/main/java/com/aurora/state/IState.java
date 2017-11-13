package com.aurora.state;

/**
 * Created by zhangjian49 on 2017/7/11.
 */
public interface IState {
    void Handle(StateContext context);
}
