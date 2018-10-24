package com.qin.wanandroid.model.net;

import com.qin.wanandroid.model.bean.Blog.Chapters;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Path;

/**
 * Create by qindl
 * on 2018/10/19
 */
public interface HttpHelper {
    Flowable<BaseBlogResponse<List<Chapters>>> getChapters();
    Flowable<BaseBlogResponse<HistoryChapters.DataBean>> getHistoryChapters(int id,int page);
    Flowable<HomeBanner> getHomeBanner();
    Flowable<SecondBanner> getSecondBanner();
    Flowable<HomeMore> getHomeMoreList(int id);
}
