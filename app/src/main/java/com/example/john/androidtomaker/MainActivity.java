package com.example.john.androidtomaker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.john.androidtomaker.Model.dagger.DaggerActivity;
import com.example.john.androidtomaker.service.WeatherService;
import com.example.john.androidtomaker.utils.MyUtils;
import com.example.john.androidtomaker.view.ResultActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button mBtn1;
    private int mMNotificationId = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolBar();
        //        showNotification();

        Intent intent = new Intent(this, WeatherService.class);
        startService(intent);

    }

    private void initToolBar() {
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("标题");
        toolBar.setSubtitle("subTitle");
        toolBar.setLogo(R.mipmap.notice);
    }

    @OnClick(R.id.btn_1)
    public void onClick() {
        //        sendBroadCast();
        //        uoDateNotification();
        //        startResultActivity();
        //        alertDialog();
        //        snackbar();
    }

    private void snackbar() {
        Snackbar.make(mBtn1, "哈哈", Snackbar.LENGTH_INDEFINITE).setAction("确定?", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyUtils.showToast(MainActivity.this, "好的");
            }
        }).show();
    }


    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title")
                .setMessage("This is Message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "NO", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void startResultActivity() {
        Intent intent = new Intent(MainActivity.this, DaggerActivity.class);
        startActivity(intent);
    }

    /***
     * 创建Notification
     */
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
        manager.notify(mMNotificationId, notification);

        //启动为前台服务
        //        startForeground(mNotificationId, notification);
    }

    /**
     * 发送广播
     */
    private void sendBroadCast() {
        sendBroadcast(new Intent("hello"));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 更新通知
     */
    private void uoDateNotification() {
        //创建Notificationmanager对象
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //创建builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.notice).setContentTitle("Title哈哈").setContentText("内容啊");

        int numMessages = 0;
        builder.setContentText("new message").setNumber(++numMessages);
        manager.notify(mMNotificationId, builder.build());
        //创建Action
        //        Intent intent = new Intent(this, ResultActivity.class);
        //        PendingIntent pendingIntent = PendingIntent.getActivity(this, mMNotificationId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
