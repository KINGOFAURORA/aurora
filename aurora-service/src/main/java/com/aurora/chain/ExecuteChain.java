// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.chain;

import java.util.List;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/8/2 下午5:20
 **/
public class ExecuteChain {

    private int index = 0;

    private List<Node<Command>> nodes;

    public ExecuteChain(List<Node<Command>> nodes){
        this.nodes = nodes;
    }

    public boolean executeChain(Command command, ExecuteChain chain){
        if(index >= nodes.size()){
            return false;
        }
        return nodes.get(index++).execute(command, chain);
    }

}
