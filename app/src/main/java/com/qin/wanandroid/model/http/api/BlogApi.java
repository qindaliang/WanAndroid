package com.qin.wanandroid.model.http.api;

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
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Create by qindl
 * on 2018/10/19
 */
public interface BlogApi {

    String HOST = "http://wanandroid.com/";
  //  String HOST = "http://wanandroid.com/wxarticle/chapters/json";



    @GET("wxarticle/chapters/json")
    Flowable<BaseBlogResponse<List<Chapters>>> getChapters();

    @GET("wxarticle/list/{id}/{page}/json")
    Flowable<BaseBlogResponse<HistoryChapters.DataBean>> getHistoryChapters(@Path("id") int id,@Path("page") int page);

    @GET("banner/json")
    Flowable<HomeBanner> getHomeBanner();

    @GET("article/listproject/{id}/json")
    Flowable<SecondBanner> getSecondBanner(@Path("id") int id);

    @GET("article/list/{id}/json")
    Flowable<HomeMore> getHomeMoreList(@Path("id")int id);

    @GET("project/tree/json")
    Flowable<ProjectCategory> getProjectCategory();

    @GET("tree/json")
    Flowable<Category> getCategory();
}
