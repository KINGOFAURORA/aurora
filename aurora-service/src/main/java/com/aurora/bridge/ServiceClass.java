// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.bridge;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/28 下午7:33
 **/
public class ServiceClass {
    protected Process process;

    protected ServiceClass(){}

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public void doProcess(){
        process.checkRisk();
    }
}
