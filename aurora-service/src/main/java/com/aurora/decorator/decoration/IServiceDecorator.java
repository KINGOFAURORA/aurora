package com.aurora.decorator.decoration;

import com.aurora.decorator.IService;

/**
 * Created by zhangjian49 on 2017/7/3.
 */
public abstract class IServiceDecorator implements IService {
    protected IService service;

    public void setService(IService service){
        this.service = service;
    }

    public abstract void functionA();
}
