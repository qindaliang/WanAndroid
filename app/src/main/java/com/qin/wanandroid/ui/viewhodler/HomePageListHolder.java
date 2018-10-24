package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qin.wanandroid.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class HomePageListHolder extends RecyclerView.ViewHolder {

    public TextView author;
    public TextView desc;
    public TextView count;
    public TextView time;
    public TextView title;
    public ImageView desc_pic;
    public CircleImageView head_pic;
    public LinearLayout ll_author;
    public CardView cardview;

    public HomePageListHolder(@NonNull View itemView) {
        super(itemView);
        author = itemView.findViewById(R.id.tv_item_more_author);
        desc = itemView.findViewById(R.id.tv_item_more_desc);
        count = itemView.findViewById(R.id.tv_item_more_count);
        time = itemView.findViewById(R.id.tv_item_more_time);
        title = itemView.findViewById(R.id.tv_item_more_title);
        desc_pic = itemView.findViewById(R.id.iv_item_more_pic);
        head_pic = itemView.findViewById(R.id.iv_item_more_head);
        ll_author = itemView.findViewById(R.id.ll_home_more_author);
        cardview = itemView.findViewById(R.id.cardview_home);
    }
}
