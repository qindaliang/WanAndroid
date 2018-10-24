package com.qin.wanandroid.presenter;

import com.qin.wanandroid.base.RxPresenter;
import com.qin.wanandroid.model.DataManager;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.http.CommonSubscriber;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;
import com.qin.wanandroid.presenter.constract.CommonBlogContract;
import com.qin.wanandroid.utils.RxUitl;

/**
 * Create by qindl
 * on 2018/10/22
 */
public class CommonBlogPresenter extends RxPresenter<CommonBlogContract.View> implements CommonBlogContract.Presenter {

    public CommonBlogPresenter(CommonBlogContract.View view) {
        this.view = view;
    }

    @Override
    public void loadList(int id,int page) {
        addSubscrible(
                DataManager.getInstance().getHistoryChapters(id,page)
                        .compose(RxUitl.<BaseBlogResponse<HistoryChapters.DataBean>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<BaseBlogResponse<HistoryChapters.DataBean>>(view) {
                            @Override
                            public void onNext(BaseBlogResponse<HistoryChapters.DataBean> chapters) {
                                view.showData(chapters);
                            }

                            @Override
                            public void onComplete() {
                                view.stopRefresh(true);
                            }
                        })
        );
    }

    @Override
    public void loadMoreList(int id,int page) {
        addSubscrible(
                DataManager.getInstance().getHistoryChapters(id,page)
                        .compose(RxUitl.<BaseBlogResponse<HistoryChapters.DataBean>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<BaseBlogResponse<HistoryChapters.DataBean>>(view) {
                            @Override
                            public void onNext(BaseBlogResponse<HistoryChapters.DataBean> chapters) {
                                view.showMoreData(chapters);
                            }

                            @Override
                            public void onComplete() {
                                view.stopRefresh(false);
                            }
                        })
        );
    }
}
