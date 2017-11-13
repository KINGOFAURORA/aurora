// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.command;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/8/1 下午4:35
 **/
public class Invoker {
    private List<Command> list = Lists.newArrayList();

    public void addCommand(Command command){
        list.add(command);
    }

    public void execude(){
        list.get(0).excude();
    }
}
