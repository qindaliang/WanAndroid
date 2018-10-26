package com.qin.wanandroid.ui.fragment.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.presenter.HomePagePresenter;
import com.qin.wanandroid.presenter.constract.HomePageContract;
import com.qin.wanandroid.ui.adapter.CommonHomeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import butterknife.BindView;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

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
    private int refreshPage;
    private int loadMorePage;
    private int currentPage;

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
        initRefreshLayout();
        presenter.loadRefreshData(refreshPage);
    }

    private void initRefreshLayout() {
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.loadMoreData(currentPage + 1);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshPage++;
                presenter.loadRefreshData(refreshPage);
            }
        });
    }

    private void initRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        //解决嵌套recycleview重复滑动
        //     recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setItemAnimator(null);
        mCommonHomeAdapter = new CommonHomeAdapter(mActivity);
        recyclerview.setAdapter(mCommonHomeAdapter);
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case SCROLL_STATE_IDLE:
                        //    GlideApp.with(mActivity).resumeRequests(); Log.i(TAG, "SCROLL_STATE_IDLE");
                        //     mCommonHomeAdapter.setScrolling(false);
                        //     mCommonHomeAdapter.notifyDataSetChanged();
                        break;
                    default:
                        //    GlideApp.with(mActivity).pauseRequests(); Log.i(TAG, "ting");
                        //    mCommonHomeAdapter.setScrolling(true);
                        break;
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void showRefreshData(HomeBanner dataBean) {
        mCommonHomeAdapter.setRefreshData(dataBean.getData());
    }

    @Override
    public void showRefreshMoreData(HomeMore homeMore) {
        mCommonHomeAdapter.setRefreshDataMore(homeMore.getData().getDatas());
    }

    @Override
    public void showLoadMoreData(HomeMore dataBean) {
        Log.i(TAG, "showLoadMoreData: "+dataBean.getData().getDatas().size());
        int pageCount = dataBean.getData().getPageCount();
        currentPage = dataBean.getData().getCurPage();
        if (currentPage <= pageCount) {
            mCommonHomeAdapter.setLoadMoreData(dataBean.getData().getDatas());
        } else {
            refreshLayout.finishLoadMoreWithNoMoreData();
        }
    }

    @Override
    public void showRefreshData(SecondBanner dataBean) {
        mCommonHomeAdapter.setRefreshData2(dataBean.getData().getDatas());
    }

    @Override
    public void stopShowData(boolean isRefreh) {
        if (isRefreh) {
            refreshLayout.finishRefresh();
        } else {
            refreshLayout.finishLoadMore();
        }
    }

    @Override
    public void showRefreshCategoryData(ProjectCategory category) {
        mCommonHomeAdapter.setRefreshCategoryData(category.getData());
    }
}
