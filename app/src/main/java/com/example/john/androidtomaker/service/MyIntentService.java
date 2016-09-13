package com.example.john.androidtomaker.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by ZheWei on 2016/9/12.
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //在这里执行短期的耗时的操作
    }
}
