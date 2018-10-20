package com.qin.wanandroid.model.http.api;

import io.reactivex.Flowable;

/**
 * Create by qindl
 * on 2018/10/19
 */
public interface BlogApi {

    String HOST = "";

    Flowable<String> getGuoLinBlog();
}
