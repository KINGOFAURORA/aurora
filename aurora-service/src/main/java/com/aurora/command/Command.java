package com.aurora.command;

/**
 * Created by zhangjian49 on 2017/8/1.
 */
public abstract class Command {
    protected Recever recever;

    public Command(Recever recever){
        this.recever = recever;
    }

    public abstract void excude();
}
