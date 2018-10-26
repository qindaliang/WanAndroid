package com.qin.wanandroid.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.qin.wanandroid.R;
import com.qin.wanandroid.base.MvpBaseActivity;
import com.qin.wanandroid.presenter.MainPresenter;
import com.qin.wanandroid.presenter.constract.MainContract;
import com.qin.wanandroid.ui.fragment.main.BlogFragment;
import com.qin.wanandroid.ui.fragment.main.HomeFragment;
import com.qin.wanandroid.ui.fragment.system.CategoryFragment;

import butterknife.BindView;

public class MainActivity extends MvpBaseActivity<MainPresenter> implements MainContract.View, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rbg)
    RadioGroup mRadioGroup;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.rb_chapter)
    RadioButton rbChapter;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_system)
    RadioButton rbSystem;
    private BlogFragment mBlogFragment;
    private HomeFragment mHomeFragment;
    private CategoryFragment mSystemFragment;
    private Fragment mFragment;

    @Override
    public void initData() {
        initToolBar(R.id.toolbar);
        presenter = new MainPresenter(this);
        mFragment = new HomeFragment();
        mRadioGroup.setOnCheckedChangeListener(this);
        //   mRadioGroup.check(R.id.rb_home);
        showFragment(mFragment);
    }

    public void showFragment(Fragment show, Fragment hide) {
        mFragment = show;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mFragment.isAdded()) {
            transaction.hide(hide).show(mFragment);
        } else {
            transaction.hide(hide).add(R.id.fl_content, mFragment);
        }
        transaction.commit();
        setToolBarVisible(mFragment);
    }

    public void showFragment(Fragment fragment) {
        setToolBarVisible(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.fl_content, fragment);
        }
        transaction.commit();
    }

    private void setToolBarVisible(Fragment fragment) {
        if (fragment instanceof HomeFragment) {
            mToolBar.setVisibility(View.VISIBLE);
        }else {
            mToolBar.setVisibility(View.GONE);
        }
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
        setTextColor(rbChapter);
        if (mBlogFragment == null) {
            mBlogFragment = new BlogFragment();
        }
        showFragment(mBlogFragment, mFragment);
    }

    private void setTextColor(RadioButton radioButton) {
        rbChapter.setTextColor(getResources().getColor(R.color.text_black));
        rbHome.setTextColor(getResources().getColor(R.color.text_black));
        rbSystem.setTextColor(getResources().getColor(R.color.text_black));
        radioButton.setTextColor(getResources().getColor(R.color.text_home_bottom));
    }

    @Override
    public void transformTwo() {
        setTextColor(rbHome);
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        showFragment(mHomeFragment, mFragment);
    }

    @Override
    public void transformThree() {
        setTextColor(rbSystem);
        if (mSystemFragment == null) {
            mSystemFragment = new CategoryFragment();
        }
        showFragment(mSystemFragment, mFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        presenter.switchView(checkedId);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return quitSystem(keyCode, event);
    }

}
