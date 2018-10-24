package com.qin.wanandroid.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.ui.viewhodler.HomePageListHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by qindl
 * on 2018/10/24
 */
public class HomePageAdapter extends RecyclerView.Adapter {

    private Context mContext ;
    private List<HomeMore.DataBean.DatasBean> mDatas;

    public HomePageAdapter(Context context) {
        mContext = context;
        mDatas = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HomePageListHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_more_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HomePageListHolder holder = (HomePageListHolder) viewHolder;

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
