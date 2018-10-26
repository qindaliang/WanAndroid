package com.qin.wanandroid.model;

import com.qin.wanandroid.model.bean.Blog.Chapters;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.bean.category.Category;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;
import com.qin.wanandroid.model.net.HttpHelper;
import com.qin.wanandroid.model.net.HttpHelperImpl;
import com.qin.wanandroid.model.net.RetrofitHelper;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Create by qindl
 * on 2018/10/22
 */
public class DataManager implements HttpHelper {

    private static DataManager mDataManager;
    private HttpHelper mHttpHelper;

    private DataManager() {
        mHttpHelper = new HttpHelperImpl(RetrofitHelper.getBlogApi());
    }

    public static DataManager getInstance() {
        if (mDataManager == null) {
            synchronized (new Object()) {
                if (mDataManager == null) {
                    return mDataManager = new DataManager();
                }
            }
        }
        return mDataManager;
    }

    @Override
    public Flowable<BaseBlogResponse<List<Chapters>>> getChapters() {
       return mHttpHelper.getChapters();
    }

    @Override
    public Flowable<BaseBlogResponse<HistoryChapters.DataBean>> getHistoryChapters(int id, int page) {
        return mHttpHelper.getHistoryChapters(id,page);
    }

    @Override
    public Flowable<HomeBanner> getHomeBanner() {
        return mHttpHelper.getHomeBanner();
    }

    @Override
    public Flowable<SecondBanner> getSecondBanner(int id) {
        return mHttpHelper.getSecondBanner(id);
    }

    @Override
    public Flowable<HomeMore> getHomeMoreList(int id) {
        return mHttpHelper.getHomeMoreList(id);
    }

    @Override
    public Flowable<ProjectCategory> getProjectCategory() {
        return mHttpHelper.getProjectCategory();
    }

    @Override
    public Flowable<Category> getCategory() {
        return mHttpHelper.getCategory();
    }
}
