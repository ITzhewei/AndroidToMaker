package com.example.john.androidtomaker.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.john.androidtomaker.R;
import com.example.john.androidtomaker.view.ResultActivity;

/**
 * Created by ZheWei on 2016/9/12.
 */
public class WeatherService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        showNotification();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return START_STICKY;//粘性的  当服务被异常kill时,系统会自动重启这个服务
        return START_REDELIVER_INTENT;
        //        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void showNotification() {
        Log.i("MainActivity", "showNotification: 1111");
        //创建一个Builder对象
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.notice)
                .setContentTitle("Notification_ContentTitle")
                .setContentText("ContentText");
        //定义并设置一个通知动作
        Intent resultIntent = new Intent(this, ResultActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        //生成一个Notification对象
        Notification notification = mBuilder.build();

        //使用notificationManager对象发送通知
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int mNotificationId = 001;
        manager.notify(mNotificationId, notification);

        //启动为前台服务
        startForeground(mNotificationId, notification);
    }


}
