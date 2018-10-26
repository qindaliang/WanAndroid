package com.qin.wanandroid.ui.viewhodler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qin.wanandroid.R;


/**
 * Create by qindl
 * on 2018/10/24
 */
public class ProjectCategoryDetailViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView desc;
    public ImageView iv_mame;
    public View view;

    public ProjectCategoryDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_home_category_name);
        desc = itemView.findViewById(R.id.tv_home_category_desc);
        iv_mame = itemView.findViewById(R.id.iv_home_category_name);
        view = itemView.findViewById(R.id.view_category_desc);
    }
}
