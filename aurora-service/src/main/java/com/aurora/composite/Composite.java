// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.composite;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/24 下午7:38
 **/
public class Composite implements Component {
    public List<Component> list = Lists.newArrayList();

    public void add(Component component) {
        list.add(component);
    }

    public void remove(Component component) {
        list.remove(component);
    }
}
