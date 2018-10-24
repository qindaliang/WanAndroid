package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.qin.wanandroid.R;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class NewProjectViewHolder extends RecyclerView.ViewHolder {

    public  RecyclerView recycleView;
    public RelativeLayout rl_more;

    public NewProjectViewHolder(@NonNull View itemView) {
        super(itemView);
        rl_more = itemView.findViewById(R.id.rl_home_more);
        recycleView = itemView.findViewById(R.id.rlv_home_newproject);
    }
}
