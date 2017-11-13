// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/14 下午3:48
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeforeInitialization bean name --->" + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("AfterInitialization bean name --->" + s);
        return o;
    }
}
