package com.qin.wanandroid.model.net;

import com.qin.wanandroid.model.bean.Blog.Chapters;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.bean.category.Category;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Create by qindl
 * on 2018/10/19
 */
public interface HttpHelper {
    Flowable<BaseBlogResponse<List<Chapters>>> getChapters();
    Flowable<BaseBlogResponse<HistoryChapters.DataBean>> getHistoryChapters(int id,int page);
    Flowable<HomeBanner> getHomeBanner();
    Flowable<SecondBanner> getSecondBanner(int id);
    Flowable<HomeMore> getHomeMoreList(int id);
    Flowable<ProjectCategory> getProjectCategory();
    Flowable<Category> getCategory();
}
