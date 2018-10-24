package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qin.wanandroid.R;

/**
 * Create by qindl
 * on 2018/10/22
 */
public class CommonBlogViewHolder extends RecyclerView.ViewHolder {

    public  TextView mCount;
    public  TextView mTime;
    public  TextView mTitle;

    public CommonBlogViewHolder(@NonNull View itemView) {
        super(itemView);
        mCount = itemView.findViewById(R.id.tv_common_blog_count);
        mTime = itemView.findViewById(R.id.tv_common_blog_time);
        mTitle = itemView.findViewById(R.id.tv_common_blog_title);
    }
}
