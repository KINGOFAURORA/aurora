// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhangjian49
 * @version 1.0
 * @created 2017/4/27 下午12:21
 **/
public class TestEntity implements InitializingBean, DisposableBean{

    private String property1;

    public TestEntity(){
        System.out.println("这里调用TestEntity的构造函数");
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        System.out.println("这里设置了属性property1");
        this.property1 = property1;
    }

    public void myInit(){
        System.out.println("=========myInit");
    }

    public void myDestroy(){
        System.out.println("=========myDestroy");
    }

    @PostConstruct
    public void init1() {
        System.out.println("==========init1");
    }
    @PreDestroy
    public void destroy1() {
        System.out.println("==========destroy1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("===========InitializingBean 设置");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("===========DisposableBean 销毁");
    }
}
