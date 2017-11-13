// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.domain;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/1 上午11:56
 **/
@Component
public class Demo1 {

    @Resource
    private TestEntity testEntity;

    @Resource
    private Map<String, Object> map;

    public void functionA() {
        map.put("1", 1);
        System.out.println("aaa");
    }
}
