package com.qin.wanandroid.presenter.constract;

import com.qin.wanandroid.base.BaseContract;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.bean.home.SecondBanner;

import java.util.List;

/**
 * Create by qindl
 * on 2018/10/23
 */
public interface HomePageContract {
    interface presenter extends BaseContract.BasePresenter<view>{
        void loadRefreshData(int id);
        void loadMoreData(int id);

    }
    interface view extends BaseContract.BaseView{
        void showRefreshData(HomeBanner dataBean);
        void showRefreshMoreData(HomeMore homeMore);
        void showLoadMoreData(HomeMore homeMore);
        void showRefreshData(SecondBanner dataBean);
        void stopShowData(boolean isRefreh);
        void showRefreshCategoryData(ProjectCategory category);
    }
}
