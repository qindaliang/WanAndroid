package com.qin.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Create by qindl
 * on 2018/10/19
 */
public abstract class MvpBaseFragment<T extends BaseContract.BasePresenter> extends BaseFragment implements BaseContract.BaseView {

    public T presenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (presenter != null) {
            presenter.OnAttach(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.OnDetach();
        }
    }
}
