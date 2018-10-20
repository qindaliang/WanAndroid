package com.qin.wanandroid.application;

import android.app.Application;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class App extends Application {

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static App getInstance(){
        return mInstance;
    }
}
