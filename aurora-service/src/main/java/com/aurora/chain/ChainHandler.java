package com.aurora.chain;

/**
 * Created by zhangjian49 on 2017/8/2.
 */
public interface ChainHandler {
    boolean executeChain(Command command);
}
