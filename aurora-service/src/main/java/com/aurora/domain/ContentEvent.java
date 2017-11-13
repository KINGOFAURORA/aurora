// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.domain;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/18 下午5:14
 **/
public class ContentEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public ContentEvent(Object source) {
        super(source);
    }
}
