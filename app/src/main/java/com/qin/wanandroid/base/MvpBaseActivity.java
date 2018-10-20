package com.qin.wanandroid.base;

/**
 * Create by qindl
 * on 2018/10/19
 */
public abstract class MvpBaseActivity<T extends BaseContract.BasePresenter> extends BaseActivity implements BaseContract.BaseView{

    public T presenter;

    @Override
    public void onCreateView() {
        super.onCreateView();
        if (presenter != null) {
            presenter.OnAttach(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.OnDetach();
    }
}
