package com.qin.wanandroid.ui.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flyco.tablayout.SlidingTabLayout;
import com.qin.wanandroid.R;
import com.qin.wanandroid.base.MvpBaseFragment;
import com.qin.wanandroid.model.bean.Blog.Chapters;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;
import com.qin.wanandroid.presenter.BaseBlogPresenter;
import com.qin.wanandroid.presenter.constract.BaseBlogContract;
import com.qin.wanandroid.ui.fragment.blog.CommonBlogFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class BlogFragment extends MvpBaseFragment<BaseBlogContract.Presenter> implements BaseBlogContract.View {

    @BindView(R.id.tl_blog)
    SlidingTabLayout tlBlog;
    @BindView(R.id.iv_blog_search)
    ImageView ivBlogSearch;
    @BindView(R.id.vp_blog)
    ViewPager vpBlog;
    private View mBlogView;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles;

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mBlogView == null) {
            mBlogView = inflater.inflate(R.layout.fragment_blog_base, null);
        }
       return mBlogView;
    }

    @Override
    public void initData() {
        presenter = new BaseBlogPresenter(this);
        presenter.loadTab();
    }

    @Override
    public void showTab(BaseBlogResponse<List<Chapters>> blogResponse) {
        if (blogResponse==null){
            return;
        }
        List<Chapters> chapters = blogResponse.getData();
        int size = chapters.size();
        mTitles = new ArrayList<>(size);
        for(int i = 0 ; i < size ; i++){
            mTitles.add(chapters.get(i).getName());
            CommonBlogFragment fragment = new CommonBlogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",chapters.get(i).getId());
            fragment.setArguments(bundle);
            mFragments.add(fragment);
            Log.i(TAG, "showTab: "+chapters.get(i).getName());
        }
        vpBlog.setOffscreenPageLimit(mTitles.size());
        vpBlog.setAdapter(new MyFragmentAdapter(getChildFragmentManager()));
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
            return mTitles.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
