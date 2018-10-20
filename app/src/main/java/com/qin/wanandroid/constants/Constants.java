package com.qin.wanandroid.constants;

import com.qin.wanandroid.application.App;

import java.io.File;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class Constants {
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";
}
