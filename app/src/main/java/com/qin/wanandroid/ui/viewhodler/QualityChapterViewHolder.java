package com.qin.wanandroid.ui.viewhodler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qin.wanandroid.R;

/**
 * Create by qindl
 * on 2018/10/25
 */
public class QualityChapterViewHolder extends RecyclerView.ViewHolder {

    public RecyclerView recyclerView;

    public QualityChapterViewHolder(View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.recyclerview_home_quality);
    }
}
