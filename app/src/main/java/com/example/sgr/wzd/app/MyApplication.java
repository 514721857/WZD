package com.example.sgr.wzd.app;

import android.app.Application;
import android.content.Context;

/**
 * Data：2018/1/23/-16:20
 * By  沈国荣
 * Description:自定义application
 */

public class MyApplication extends Application {
    private static MyApplication applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
    }

    public static MyApplication getInstance() {
        return applicationContext;
    }


}
