// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.factory;

import com.aurora.item.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/4 下午7:29
 **/
@Service("iTemBFactory")
public class ItemBFactory implements IFactory {

    @Resource(name="itemB")
    private Item itemB;

    public Item createItem() {
        return itemB;
    }
}
