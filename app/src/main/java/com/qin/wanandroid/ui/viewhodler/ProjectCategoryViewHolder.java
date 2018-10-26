package com.qin.wanandroid.ui.viewhodler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.qin.wanandroid.R;
import com.qin.wanandroid.base.BaseViewHolder;

/**
 * Create by qindl
 * on 2018/10/24
 */

public class ProjectCategoryViewHolder extends RecyclerView.ViewHolder {

    public RecyclerView recycleView;
    public LinearLayout allCategory;

    public ProjectCategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        recycleView = itemView.findViewById(R.id.recyclerview_home_category);
        allCategory = itemView.findViewById(R.id.ll_home_category_all);
    }
}
