// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.aop;

import org.springframework.stereotype.Component;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/19 下午7:31
 **/
@Component
public class TargetClass {

    @MyAnnotation
    public void function(){
        System.out.println("111");
    }
}
