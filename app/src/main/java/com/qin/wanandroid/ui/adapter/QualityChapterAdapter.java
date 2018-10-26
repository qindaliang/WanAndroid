package com.qin.wanandroid.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.model.ImageLoader;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.ui.viewhodler.QualityChapterDetailViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by qindl
 * on 2018/10/25
 */
public class QualityChapterAdapter extends RecyclerView.Adapter {

    private List<HomeBanner.DataBean> bannerDatas = new ArrayList<>();
    private List<HomeBanner.DataBean> bannerDatas2 = new ArrayList<>();
    private Context mContext;

    public QualityChapterAdapter(Context context, List<String> imges, List<String> title, List<HomeBanner.DataBean> bannerData) {
        mContext = context;
        bannerDatas.addAll(bannerData);
        bannerDatas2 = bannerDatas.subList(4, 7);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new QualityChapterDetailViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_quality_detail, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        QualityChapterDetailViewHolder holder = (QualityChapterDetailViewHolder) viewHolder;
        String title = bannerDatas.get(i).getTitle();
        String imagePath = bannerDatas.get(i).getImagePath();
        String title2 = bannerDatas2.get(i).getTitle();
        String imagePath2 = bannerDatas2.get(i).getImagePath();
        ImageLoader.load(mContext, imagePath, holder.iv_top);
        ImageLoader.load(mContext, imagePath2, holder.iv_bottom);
        holder.tv_top.setText(title);
        holder.tv_bottom.setText(title2);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private OnQualityItemClickListener mOnItemClickListener;

    public interface OnQualityItemClickListener {
        void onItemClick();
    }

    public void setOnItemClickListener(OnQualityItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
