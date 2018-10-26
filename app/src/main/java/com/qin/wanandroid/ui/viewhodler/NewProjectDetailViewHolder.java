package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qin.wanandroid.R;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class NewProjectDetailViewHolder extends RecyclerView.ViewHolder {

    public TextView author;
    public TextView desc;
    public TextView time;
    public TextView name;
    public ImageView desc_pic;
    public ImageView author_pic;

    public NewProjectDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        author = itemView.findViewById(R.id.tv_item_author);
        desc = itemView.findViewById(R.id.tv_item_desc);
        time = itemView.findViewById(R.id.tv_item_time);
        name = itemView.findViewById(R.id.tv_item_name);
        desc_pic = itemView.findViewById(R.id.iv_item_pic);
        author_pic = itemView.findViewById(R.id.iv_item_author);

    }
}
