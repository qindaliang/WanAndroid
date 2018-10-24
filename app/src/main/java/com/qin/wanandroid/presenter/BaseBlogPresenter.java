package com.qin.wanandroid.presenter;

import android.util.Log;

import com.qin.wanandroid.base.RxPresenter;
import com.qin.wanandroid.model.DataManager;
import com.qin.wanandroid.model.bean.Blog.Chapters;
import com.qin.wanandroid.model.http.CommonSubscriber;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;
import com.qin.wanandroid.presenter.constract.BaseBlogContract;
import com.qin.wanandroid.utils.RxUitl;

import java.util.List;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class BaseBlogPresenter extends RxPresenter<BaseBlogContract.View> implements BaseBlogContract.Presenter {

    public BaseBlogPresenter(BaseBlogContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTab() {
        addSubscrible(
                DataManager.getInstance().getChapters()
                        .compose(RxUitl.<BaseBlogResponse<List<Chapters>>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<BaseBlogResponse<List<Chapters>>>(view) {
                            @Override
                            public void onNext(BaseBlogResponse<List<Chapters>> chapters) {
                                view.showTab(chapters);
                            }

                            @Override
                            public void onComplete() {

                            }
                        })
        );
    }
}
