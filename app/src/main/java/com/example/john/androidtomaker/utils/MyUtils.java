package com.example.john.androidtomaker.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ZheWei on 2016/9/12.
 */
public class MyUtils {
    private static Toast mToast;

    /**
     * Toast 判断
     */
    public static void showToast(Context context, String message) {
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.show();
    }
}
