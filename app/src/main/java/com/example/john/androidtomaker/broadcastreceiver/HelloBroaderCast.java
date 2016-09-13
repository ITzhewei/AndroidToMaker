package com.example.john.androidtomaker.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ZheWei on 2016/9/12.
 */
public class HelloBroaderCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "hhasdsd", Toast.LENGTH_SHORT).show();
    }
}
