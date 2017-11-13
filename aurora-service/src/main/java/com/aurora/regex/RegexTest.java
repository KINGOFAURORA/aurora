// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.regex;

import java.util.regex.Pattern;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/14 上午10:15
 **/
public class RegexTest {
    public static void main(String[] args) {
        System.out.println(Pattern.compile("(\\d{10})\\d{7}(\\w{1})").matcher("210803198902062517").replaceAll("$1*******$2"));
    }
}
