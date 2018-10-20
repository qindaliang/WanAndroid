package com.qin.wanandroid.presenter;

import com.qin.wanandroid.base.RxPresenter;
import com.qin.wanandroid.presenter.constract.BaseBlogContract;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class BaseBlogPresenter extends RxPresenter<BaseBlogContract.View> implements BaseBlogContract.Presenter {

    public BaseBlogPresenter(BaseBlogContract.View view) {
        this.view = view;
    }


}
