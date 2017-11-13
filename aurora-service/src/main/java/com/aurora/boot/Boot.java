// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.boot;

import com.aurora.domain.Demo1;
import com.aurora.domain.TestEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangjian49
 *
 *
 *
 * @version 1.0
 * @created 2017/4/27 下午12:23
 **/
public class Boot {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        TestEntity entity1 = (TestEntity) context.getBean("testEntity");
//        entity1.setProperty1("222");
        TestEntity entity2 = (TestEntity) context.getBean("testEntity");
        System.out.println(entity1.equals(entity2));
        System.out.println(entity2.getProperty1());
        ((ClassPathXmlApplicationContext)context).registerShutdownHook();
        Demo1 d1 = (Demo1) context.getBean("demo1");
        d1.functionA();
    }
}
