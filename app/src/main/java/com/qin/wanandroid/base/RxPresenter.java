package com.qin.wanandroid.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class RxPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    public T view;
    private CompositeDisposable mCompositeDisposable;

    public void unSubscrible() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    public void addSubscrible(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void OnAttach(T view) {
        this.view = view;
    }

    @Override
    public void OnDetach() {
        unSubscrible();
    }
}
