package com.qin.wanandroid.base;

/**
 * Create by qindl
 * on 2018/10/19
 */
public interface BaseContract {

    interface BasePresenter<T extends BaseView> {
        void OnAttach(T view);

        void OnDetach();
    }

    interface BaseView {
        void showMsg(String msg);
    }
}
