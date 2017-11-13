// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/3 下午9:05
 **/
public class ServiceInterfaceProxy implements InvocationHandler{

    private Object proxied;

    public ServiceInterfaceProxy(){

    }

    public ServiceInterfaceProxy(Object proxied){
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy:" + proxy.getClass());
        System.out.println("Proxy1:" + this.getClass());
        System.out.println("Method:" + method);
        System.out.println("Args:" + args);
        return method.invoke(proxied, args);
    }
}
