package com.qin.wanandroid.model.net;

import com.qin.wanandroid.model.bean.Blog.Chapters;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.bean.category.Category;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.model.http.api.BlogApi;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Create by qindl
 * on 2018/10/22
 */
public class HttpHelperImpl implements  HttpHelper {

    private BlogApi mBlogApi;
    public HttpHelperImpl(BlogApi blogApi) {
        this.mBlogApi = blogApi;
    }
    @Override
    public Flowable<BaseBlogResponse<List<Chapters>>> getChapters() {
       return mBlogApi.getChapters();
    }

    @Override
    public Flowable<BaseBlogResponse<HistoryChapters.DataBean>> getHistoryChapters(int id, int page) {
        return mBlogApi.getHistoryChapters(id,page);
    }

    @Override
    public Flowable<HomeBanner> getHomeBanner() {
        return mBlogApi.getHomeBanner();
    }

    @Override
    public Flowable<SecondBanner> getSecondBanner(int id) {
        return mBlogApi.getSecondBanner(id);
    }

    @Override
    public Flowable<HomeMore> getHomeMoreList(int id) {
        return mBlogApi.getHomeMoreList(id);
    }

    @Override
    public Flowable<ProjectCategory> getProjectCategory() {
        return mBlogApi.getProjectCategory();
    }

    @Override
    public Flowable<Category> getCategory() {
        return mBlogApi.getCategory();
    }
}
