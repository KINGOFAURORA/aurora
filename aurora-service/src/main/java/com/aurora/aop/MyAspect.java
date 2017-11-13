// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/19 下午7:06
 **/
@Component
@Aspect
public class MyAspect {

    @Around("@annotation(com.aurora.aop.MyAnnotation)")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("OK");
        return proceedingJoinPoint.proceed();
    }
}
