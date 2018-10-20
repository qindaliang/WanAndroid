package com.qin.wanandroid.presenter;

import com.qin.wanandroid.base.RxPresenter;
import com.qin.wanandroid.presenter.constract.MainContract;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{


    public MainPresenter(MainContract.View view) {
    this.view = view;
    }

    @Override
    public void switchView() {
        view.transformOne();
    }
}
