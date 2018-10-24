package com.qin.wanandroid.presenter.constract;

import com.qin.wanandroid.base.BaseContract;

/**
 * Create by qindl
 * on 2018/10/19
 */
public interface MainContract {

    interface Presenter extends BaseContract.BasePresenter<View> {

        void switchView(int id);
    }

    interface View extends BaseContract.BaseView {

        void transformOne();

        void transformTwo();

        void transformThree();
    }
}
