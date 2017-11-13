// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.state;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/11 下午4:26
 **/
public class StateContext {
    private IState state;

    public StateContext(IState state){
        this.state = state;
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void request(){
        state.Handle(this);
    }
}
