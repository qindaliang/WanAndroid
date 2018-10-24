package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qin.wanandroid.R;

/**
 * Create by qindl
 * on 2018/10/24
 */
public class HomePageHolder extends RecyclerView.ViewHolder {

    public  RecyclerView recycleView;

    public HomePageHolder(@NonNull View itemView) {
        super(itemView);
        recycleView = itemView.findViewById(R.id.recyclerview_home_more);
    }
}
