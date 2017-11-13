// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.factory;

import com.aurora.item.Item;
import com.aurora.item.impl.ItemA;
import com.aurora.item.impl.ItemB;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/1 下午1:12
 **/
public class DemoFactory {
    public static Item getItem(int i){
        Item item = null;
        switch (i) {
            case 1:
                item = new ItemA();
                break;
            case 2:
                item = new ItemB();
                break;
        }
        return item;
    }
}
