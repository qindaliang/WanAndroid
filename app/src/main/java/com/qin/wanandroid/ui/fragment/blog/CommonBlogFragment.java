package com.qin.wanandroid.ui.fragment.blog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qin.wanandroid.R;
import com.qin.wanandroid.base.BaseContract;
import com.qin.wanandroid.base.MvpBaseFragment;

/**
 * Create by qindl
 * on 2018/10/20
 */
public abstract class CommonBlogFragment<T extends BaseContract.BasePresenter> extends MvpBaseFragment<T> {

    private View mCommonView;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mCommonView != null) {
            mCommonView = inflater.inflate(R.layout.fragment_common_blog,null);
        }
        return mCommonView;
    }

    @Override
    public void initData() {

    }
}
