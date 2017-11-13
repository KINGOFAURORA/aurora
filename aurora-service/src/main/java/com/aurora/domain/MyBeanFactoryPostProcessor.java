// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/14 下午6:19
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("testEntity");
        System.out.println("属性：" + bd.getPropertyValues().toString());
        MutablePropertyValues pv = bd.getPropertyValues();
        if(pv.contains("property1")){
            pv.addPropertyValue("property1", "4444");
        }

    }
}
