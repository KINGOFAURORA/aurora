// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.effective;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/6 下午12:12
 **/
public class ClassA {

    public static class Builder{

        public Builder color(){
            return this;
        }

        public ClassA build(){

            return new ClassA(this);
        }
    }

    private ClassA(Builder builder){

    }
}
