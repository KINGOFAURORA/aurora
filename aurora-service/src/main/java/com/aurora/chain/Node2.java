// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.chain;

import org.springframework.stereotype.Component;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/8/2 下午3:24
 **/
@Component
public class Node2 implements Node<Command> {

    public boolean execute(Command command, ExecuteChain chain) {
        if(command instanceof N2Command){
            System.out.println("Node2");
            return true;
        } else {
            return chain.executeChain(command, chain);
        }
    }
}
