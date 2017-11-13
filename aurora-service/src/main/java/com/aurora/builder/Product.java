// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.builder;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午3:13
 **/
public class Product {
    private List<IPart> list;

    public List<IPart> getList() {
        return list;
    }

    public void setList(List<IPart> list) {
        this.list = list;
    }

    public Product(){
        list = Lists.newArrayList();
    }

    public Product add(IPart part){
        list.add(part);
        return this;
    }
}
