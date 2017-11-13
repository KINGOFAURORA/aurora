// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.chain;

import com.google.common.collect.Lists;
import org.reflections.Reflections;

import java.util.List;
import java.util.Set;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/8/2 下午5:35
 **/
public class ConcreteChainHandler implements ChainHandler {
    private ExecuteChain chain;

    {
        List<Node<Command>> list = Lists.newArrayList();

        Reflections reflections = new Reflections("com.aurora.chain");
        Set<Class<? extends Node>> subTypes = reflections.getSubTypesOf(Node.class);
        for (Class<? extends Node> klass : subTypes) {
            Node<Command> node = SpringContextUtil.getBean(klass);
            list.add(node);
        }

        chain = new ExecuteChain(list);
    }

    public boolean executeChain(Command command) {
        return chain.executeChain(command, chain);
    }
}
