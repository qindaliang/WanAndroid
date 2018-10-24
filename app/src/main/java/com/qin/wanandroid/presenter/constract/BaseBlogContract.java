package com.qin.wanandroid.presenter.constract;

import com.qin.wanandroid.base.BaseContract;
import com.qin.wanandroid.model.bean.Blog.Chapters;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;

import java.util.List;

/**
 * Create by qindl
 * on 2018/10/20
 */
public interface BaseBlogContract {

    interface Presenter extends BaseContract.BasePresenter<View> {
        void loadTab();
    }

    interface View extends BaseContract.BaseView {
        void showTab(BaseBlogResponse<List<Chapters>> chapters);
    }
}
