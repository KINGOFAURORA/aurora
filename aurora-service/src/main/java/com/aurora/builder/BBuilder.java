// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.builder;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午4:36
 **/
public class BBuilder implements BaseBuilder {

    private Product product = new Product();

    public void buildA() {
        product.add(new PartX());
    }

    public void buildB() {
        product.add(new PartY());
    }

    public Product getProduct() {
        return product;
    }
}
