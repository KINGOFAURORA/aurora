// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.domain;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/18 下午5:18
 **/
@Component
public class MyListener implements ApplicationListener<ApplicationEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContentEvent){
            System.out.println("XXXXXXX");
        }
    }
}
