package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qin.wanandroid.R;

/**
 * Create by qindl
 * on 2018/10/26
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView tv;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.tv);
    }
}
