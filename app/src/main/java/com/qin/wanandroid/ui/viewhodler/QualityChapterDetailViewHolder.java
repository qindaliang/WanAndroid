package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.qin.wanandroid.R;


/**
 * Create by qindl
 * on 2018/10/25
 */
public class QualityChapterDetailViewHolder extends RecyclerView.ViewHolder {
    public RoundedImageView iv_top;
    public RoundedImageView iv_bottom;
    public TextView tv_top;
    public TextView tv_bottom;

    public QualityChapterDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        iv_top = itemView.findViewById(R.id.iv_item_quality_top);
        iv_bottom = itemView.findViewById(R.id.iv_item_quality_bottom);
        tv_top = itemView.findViewById(R.id.tv_item_quality_top);
        tv_bottom = itemView.findViewById(R.id.tv_item_quality_bottom);
    }
}
