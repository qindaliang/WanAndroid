package com.qin.wanandroid.ui.fragment.blog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.base.MvpBaseFragment;
import com.qin.wanandroid.listener.OnItemClickListener;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;
import com.qin.wanandroid.presenter.CommonBlogPresenter;
import com.qin.wanandroid.presenter.constract.CommonBlogContract;
import com.qin.wanandroid.ui.activity.WebViewBlogActivity;
import com.qin.wanandroid.ui.adapter.CommonBlogAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class CommonBlogFragment extends MvpBaseFragment<CommonBlogContract.Presenter> implements CommonBlogContract.View {

    @BindView(R.id.recyclerview_blog)
    RecyclerView recyclerViewBlog;
    @BindView(R.id.refreshLayout_blog)
    SmartRefreshLayout refreshLayoutBlog;
    public int page;

    private CommonBlogAdapter mCommonBlogAdapter;
    private int pageTotal;
    private int mId;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common_blog, null);
    }

    @Override
    public void initData() {
        mId = getArguments().getInt("id");
        presenter = new CommonBlogPresenter(this);
        initSmartRefreshLayout();
        initRecycleView();
        presenter.loadList(mId, page);
    }

    public void initSmartRefreshLayout() {
        refreshLayoutBlog.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshlayout) {
                presenter.loadList(mId, 0);
            }
        });
        refreshLayoutBlog.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshlayout) {
                page++;
                if (page <= pageTotal)
                    presenter.loadMoreList(mId,page+1);
            }
        });
    }

    private void initRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        //    recyclerViewBlog.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
        recyclerViewBlog.setItemAnimator(new DefaultItemAnimator());
        recyclerViewBlog.setLayoutManager(manager);
        mCommonBlogAdapter = new CommonBlogAdapter(mActivity);
        recyclerViewBlog.setAdapter(mCommonBlogAdapter);
        mCommonBlogAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(String url) {
                Intent intent = new Intent(mActivity, WebViewBlogActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }


    @Override
    public void showData(BaseBlogResponse<HistoryChapters.DataBean> chapters) {
        Log.i(TAG, "showData: " + chapters.getData().getDatas().size()+page);
        pageTotal = chapters.getData().getTotal() / chapters.getData().getDatas().size() + 1;
        mCommonBlogAdapter.setLoadData(chapters.getData());
    }

    @Override
    public void showMoreData(BaseBlogResponse<HistoryChapters.DataBean> chapters) {
        if (chapters != null) {
            mCommonBlogAdapter.setLoadMore(chapters.getData());
            Log.i(TAG, "showMoreData: " + chapters.getData().getDatas().size()+page);
        }
    }

    @Override
    public void stopRefresh(boolean isRefresh) {
        if (isRefresh){
            refreshLayoutBlog.finishRefresh();
        }else {
            refreshLayoutBlog.finishLoadMore();
        }
    }

    @Override
    public void showMsg(String msg) {

    }

}
