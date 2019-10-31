// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.test;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/27 下午7:32
 **/
public class TestMainClass1 {
    public static void main(String[] args) {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("1", 1);
//        map.put("2", 2);
//        map.put("3", 3);
//        map.put("4", 4);
//        Iterator it = map.keySet().iterator();
//        while(it.hasNext()){
//            it.next();
//            it.remove();
////            map.remove(it.next());
//        }
//        System.out.println(map);
        ClassLoadTester  classLoadTester = new ClassLoadTester();
        System.out.println(ClassLoadTester.a);
    }
}
