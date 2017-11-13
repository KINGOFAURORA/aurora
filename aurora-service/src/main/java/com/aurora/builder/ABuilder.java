// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.builder;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/5 下午4:32
 **/
public class ABuilder implements BaseBuilder {

    private Product product = new Product();

    public void buildA() {
        product.add(new PartA());
    }

    public void buildB() {
        product.add(new PartB());
    }

    public Product getProduct() {
        return product;
    }
}
