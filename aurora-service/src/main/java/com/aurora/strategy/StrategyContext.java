// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.strategy;

import com.aurora.item.Item;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/1 下午2:11
 **/
public class StrategyContext {
    private Item item;

    public StrategyContext(Item item){
        this.item = item;
    }

    public void print(){
        item.print();
    }
}
