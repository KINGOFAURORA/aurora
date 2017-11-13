// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.item.impl;

import com.aurora.item.Item;
import org.springframework.stereotype.Service;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/1 下午1:14
 **/
@Service("itemB")
public class ItemB implements Item {
    public void print() {
        System.out.println("B");
    }
}
