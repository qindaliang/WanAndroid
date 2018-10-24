package com.qin.wanandroid.application;

import android.app.Application;

import com.bumptech.glide.request.target.ViewTarget;
import com.qin.wanandroid.R;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class App extends Application {

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ViewTarget.setTagId(R.id.glide_tag);
    }

    public static App getInstance(){
        return mInstance;
    }
}
