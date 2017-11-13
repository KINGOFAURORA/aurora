// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.state;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/11 下午4:36
 **/
public class StateB implements IState {
    public void Handle(StateContext context) {
        context.setState(new StateA());
        System.out.println("State B");
    }
}
