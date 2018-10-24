package com.qin.wanandroid.ui.fragment.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.base.MvpBaseFragment;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.presenter.HomePagePresenter;
import com.qin.wanandroid.presenter.constract.HomePageContract;
import com.qin.wanandroid.ui.adapter.CommonHomeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class HomeFragment extends MvpBaseFragment<HomePageContract.presenter> implements HomePageContract.view {

    @BindView(R.id.recyclerview_home)
    RecyclerView recyclerview;
    @BindView(R.id.refreshLayout_blog)
    SmartRefreshLayout refreshLayout;

    private View mHomeView;
    private CommonHomeAdapter mCommonHomeAdapter;

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mHomeView == null) {
            mHomeView = inflater.inflate(R.layout.fragment_blog_home, null);
        }
        return mHomeView;
    }

    @Override
    public void initData() {
        presenter = new HomePagePresenter(this);
        initRecycleView();
        presenter.loadRefreshData(0);
    }

    private void initRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        mCommonHomeAdapter = new CommonHomeAdapter(mActivity);
        recyclerview.setAdapter(mCommonHomeAdapter);
    }

    @Override
    public void showRefreshData(HomeBanner dataBean) {
        mCommonHomeAdapter.setRefreshData(dataBean.getData());
    }

    @Override
    public void showRefreshMoreData(HomeMore homeMore) {
        mCommonHomeAdapter.setRefreshDataMore(homeMore.getData().getDatas());
        Log.i(TAG, "showRefreshMoreData: "+homeMore.getData().getDatas().size());
    }

    @Override
    public void showLoadMoreData(HomeMore dataBean) {

    }

    @Override
    public void showRefreshData(SecondBanner dataBean) {
        mCommonHomeAdapter.setRefreshData2(dataBean.getData().getDatas());
    }

    @Override
    public void stopShowData(boolean isRefreh) {
        if (isRefreh){
            refreshLayout.finishRefresh();
        }else {
            refreshLayout.finishLoadMore();
        }
    }
}
