// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.factory;

import com.aurora.annotation.MyAnnotation;
import com.aurora.item.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/4 下午7:27
 **/
@Service("itemAFactory")
public class ItemAFactory implements IFactory {

    @Resource(name="itemA")
    private Item itemA;

    @MyAnnotation(name="pppp1")
    public Item createItem() {
        System.out.println("oooook");
        return itemA;
    }

    @MyAnnotation(name="pppp")
    public void print(){
        System.out.println("oooook");
    }
}
