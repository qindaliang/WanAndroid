package com.qin.wanandroid.ui.fragment.system;

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
import com.qin.wanandroid.model.bean.category.Category;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.presenter.CategoryPresenter;
import com.qin.wanandroid.presenter.constract.CategoryContract;
import com.qin.wanandroid.ui.adapter.CategoryAdapter;
import butterknife.BindView;

/**
 * Create by qindl
 * on 2018/10/26
 */
public class CategoryFragment extends MvpBaseFragment<CategoryContract.Presenter> implements CategoryContract.View {

    @BindView(R.id.recyclerview_category)
    RecyclerView recyclerView;
    private View mView;
    private CategoryAdapter mAdapter;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_blog_category, null);
        }
        return mView;
    }

    @Override
    public void initData() {
        initRecycleView();
        presenter = new CategoryPresenter(this);
        presenter.loadTree();
    }

    @Override
    public void stopRefresh(boolean isRefresh) {

    }

    @Override
    public void showTree(Category category) {
        mAdapter.setTreeData(category.getData());
    }

    @Override
    public void showMsg(String msg) {

    }

    private void initRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(manager);
        mAdapter = new CategoryAdapter(mActivity);
        recyclerView.setAdapter(mAdapter);

    }
}
