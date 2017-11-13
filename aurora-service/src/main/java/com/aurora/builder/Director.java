// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.builder;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午3:25
 **/
public class Director {

    private BaseBuilder builder;

    public Director(BaseBuilder builder){
        this.builder = builder;
    }

    public Product construct(){
        builder.buildA();
        builder.buildB();
        return builder.getProduct();
    }
}
