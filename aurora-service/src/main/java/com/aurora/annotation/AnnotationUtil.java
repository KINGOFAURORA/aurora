// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/14 上午10:52
 **/
@Aspect
@Component
public class AnnotationUtil {

    @Around(value = "execution(public * com.aurora..*.*(..)) && @annotation(myAnnotation) ")
    public Object dealAnnotation(ProceedingJoinPoint joinPoint, MyAnnotation myAnnotation) throws Throwable {
        System.out.println("aop");
        Object response = joinPoint.proceed();
        return response;
    }

    public static void dealAnnotation(Class<?> clazz){

        String name = null;

        Method[] methods =clazz.getMethods();

        for(Method method : methods){
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            if(myAnnotation != null){
                System.out.println(myAnnotation.name());
            }
        }
    }
}
