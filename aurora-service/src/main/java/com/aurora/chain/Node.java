package com.aurora.chain;

/**
 * Created by zhangjian49 on 2017/8/2.
 */
public interface Node<T extends Command> {
    boolean execute(T command, ExecuteChain chain);
}
