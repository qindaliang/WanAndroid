package com.qin.wanandroid.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.qin.wanandroid.R;
import com.qin.wanandroid.base.MvpBaseActivity;
import com.qin.wanandroid.presenter.MainPresenter;
import com.qin.wanandroid.presenter.constract.MainContract;
import com.qin.wanandroid.ui.fragment.blog.BaseBlogFragment;

public class MainActivity extends MvpBaseActivity<MainPresenter> implements MainContract.View {

    private BaseBlogFragment mBlogFragment;

    @Override
    public void initData() {
        presenter = new MainPresenter(this);
        presenter.switchView();
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_content, fragment);
        transaction.show(fragment);
        transaction.commit();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void transformOne() {
        if (mBlogFragment == null) {
            mBlogFragment = new BaseBlogFragment();
        }
        showFragment(mBlogFragment);
    }

    @Override
    public void transformTwo() {

    }

    @Override
    public void transformThree() {

    }
}
