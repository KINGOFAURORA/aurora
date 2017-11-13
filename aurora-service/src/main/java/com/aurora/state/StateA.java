// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.state;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/11 下午4:34
 **/
public class StateA implements IState{
    public void Handle(StateContext context) {
        context.setState(new StateB());
        System.out.println("State A");
    }
}
