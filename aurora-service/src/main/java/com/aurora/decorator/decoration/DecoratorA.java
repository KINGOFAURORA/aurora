// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.decorator.decoration;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/3 下午7:12
 **/
public class DecoratorA extends IServiceDecorator {
    public void functionA() {
        service.functionA();
        System.out.println("DecoratorA");
    }
}
