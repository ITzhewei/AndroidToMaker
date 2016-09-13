package com.example.john.androidtomaker.Model.dagger;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * Created by ZheWei on 2016/9/12.
 */
public class A {
    public String filed;

    @Inject
    public A() {

    }

    public void doSomething() {
        Logger.i("a doSomething");
    }
}
