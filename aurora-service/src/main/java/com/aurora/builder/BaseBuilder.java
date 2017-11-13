// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.builder;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午3:12
 **/
public interface BaseBuilder {
    void buildA();
    void buildB();
    Product getProduct();
}
