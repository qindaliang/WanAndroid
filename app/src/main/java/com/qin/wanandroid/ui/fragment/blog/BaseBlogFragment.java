package com.qin.wanandroid.ui.fragment.blog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.qin.wanandroid.R;
import com.qin.wanandroid.base.MvpBaseFragment;
import com.qin.wanandroid.presenter.constract.BaseBlogContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class BaseBlogFragment extends MvpBaseFragment<BaseBlogContract.Presenter> implements BaseBlogContract.View{

    @BindView(R.id.iv_blog_category)
    ImageView ivBlogCategory;
    @BindView(R.id.tl_blog)
    SlidingTabLayout tlBlog;
    @BindView(R.id.iv_blog_search)
    ImageView ivBlogSearch;
    @BindView(R.id.vp_blog)
    ViewPager vpBlog;
    Unbinder unbinder;

    private View mBlogView;
    private ArrayList<CommonBlogFragment> mFragments = new ArrayList<>();
    private String[] mTitles;

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mBlogView == null) {
            mBlogView = inflater.inflate(R.layout.fragment_base_blog, null);
        }
        return mBlogView;
    }

    @Override
    public void initData() {
        mTitles = getResources().getStringArray(R.array.blog_tab);
        HongXiangFragment fragment = new HongXiangFragment();
        for(int i = 0; i < mTitles.length ; i++){
            mFragments.add(new HongXiangFragment());
        }
        vpBlog.setAdapter(new MyFragmentAdapter(getFragmentManager()));
        tlBlog.setViewPager(vpBlog);
      
    }

    class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
