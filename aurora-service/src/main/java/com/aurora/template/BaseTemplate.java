// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.template;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午12:09
 **/
public abstract class BaseTemplate {

    public void templateMethod(){
        funA();
        System.out.println("templateMethod");
    }

    abstract void funA();
}
