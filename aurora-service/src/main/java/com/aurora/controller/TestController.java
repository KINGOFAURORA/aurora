// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangjian49
 * @version 1.0
 * @created 2017/4/26 下午4:12
 **/
@Controller
@RequestMapping("/aurora")
public class TestController {
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "Hello";
    }
}
