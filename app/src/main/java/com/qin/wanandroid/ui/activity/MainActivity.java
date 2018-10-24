package com.qin.wanandroid.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.base.MvpBaseActivity;
import com.qin.wanandroid.presenter.MainPresenter;
import com.qin.wanandroid.presenter.constract.MainContract;
import com.qin.wanandroid.ui.fragment.main.BlogFragment;
import com.qin.wanandroid.ui.fragment.main.HomeFragment;

import butterknife.BindView;

public class MainActivity extends MvpBaseActivity<MainPresenter> implements MainContract.View, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rbg)
    RadioGroup mRadioGroup;
    private BlogFragment mBlogFragment;
    private HomeFragment mHomeFragment;
    private Fragment mFragment;

    @Override
    public void initData() {
        presenter = new MainPresenter(this);
        mFragment = new HomeFragment();
        mRadioGroup.setOnCheckedChangeListener(this);
     //   mRadioGroup.check(R.id.rb_home);
        showFragment(mFragment);
    }

    public void showFragment(Fragment show,Fragment hide) {
        if (mFragment==null){
            return;
        }
        mFragment = show;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mFragment.isAdded()){
            transaction.show(mFragment).hide(hide);
        }else {
            transaction.add(R.id.fl_content, mFragment).hide(hide);
        }
        transaction.commit();
    }
    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()){
            transaction.show(fragment);
        }else {
            transaction.add(R.id.fl_content, fragment);
        }
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
            mBlogFragment = new BlogFragment();
        }
        showFragment(mBlogFragment,mFragment);
    }

    @Override
    public void transformTwo() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        showFragment(mHomeFragment,mFragment);
    }

    @Override
    public void transformThree() {
        if (mBlogFragment == null) {
            mBlogFragment = new BlogFragment();
        }
        showFragment(mBlogFragment,mFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        presenter.switchView(checkedId);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       return quitSystem(keyCode,event);
    }

}
