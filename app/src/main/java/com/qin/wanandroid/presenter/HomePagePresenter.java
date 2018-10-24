package com.qin.wanandroid.presenter;

import com.qin.wanandroid.base.RxPresenter;
import com.qin.wanandroid.model.DataManager;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.model.http.CommonSubscriber;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;
import com.qin.wanandroid.presenter.constract.HomePageContract;
import com.qin.wanandroid.utils.RxUitl;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class HomePagePresenter extends RxPresenter<HomePageContract.view> implements HomePageContract.presenter {

    public HomePagePresenter(HomePageContract.view view) {
        this.view = view;
    }

    @Override
    public void loadRefreshData(int id) {
        //TODO  rxjava实现上一次请求成功
        addSubscrible(DataManager.getInstance().getHomeBanner()
                .compose(RxUitl.<HomeBanner>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<HomeBanner>(view) {
                    @Override
                    public void onNext(HomeBanner dataBean) {
                        view.showRefreshData(dataBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

        addSubscrible(DataManager.getInstance().getSecondBanner()
        .compose(RxUitl.<SecondBanner>rxSchedulerHelper())
        .subscribeWith(new CommonSubscriber<SecondBanner>(view) {
            @Override
            public void onNext(SecondBanner secondBanner) {
                view.showRefreshData(secondBanner);
            }

            @Override
            public void onComplete() {

            }
        }));

        addSubscrible(DataManager.getInstance().getHomeMoreList(id)
        .compose(RxUitl.<HomeMore>rxSchedulerHelper())
        .subscribeWith(new CommonSubscriber<HomeMore>(view) {
            @Override
            public void onNext(HomeMore homeMore) {
                view.showRefreshMoreData(homeMore);
            }

            @Override
            public void onComplete() {
                view.stopShowData(true);
            }
        }));
    }

    @Override
    public void loadMoreData() {

    }
}
