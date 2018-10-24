package com.qin.wanandroid.ui.viewhodler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qin.wanandroid.R;
import com.youth.banner.Banner;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class HomeBannerViewHolder extends RecyclerView.ViewHolder {

    public Banner banner;

    public HomeBannerViewHolder(@NonNull View itemView) {
        super(itemView);
        banner = itemView.findViewById(R.id.banner_home);
    }
}
