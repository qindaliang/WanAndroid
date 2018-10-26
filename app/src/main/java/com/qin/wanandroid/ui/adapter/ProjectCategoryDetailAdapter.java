package com.qin.wanandroid.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.model.ImageLoader;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.ui.viewhodler.ProjectCategoryDetailViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by qindl
 * on 2018/10/24
 */
public class ProjectCategoryDetailAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<ProjectCategory.DataBean> categroies;
    private List<String> images = new ArrayList<>();
    private List<String> descs = new ArrayList<>();


    public ProjectCategoryDetailAdapter(Context context, List<ProjectCategory.DataBean> dataBeans, List<String> imgs, List<String> desc) {
        mContext = context;
        categroies = new ArrayList<>();
        categroies.addAll(dataBeans);

        images.addAll(imgs);
        descs.addAll(desc);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ProjectCategoryDetailViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_project_category_child, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ProjectCategoryDetailViewHolder holder = (ProjectCategoryDetailViewHolder) viewHolder;
        if (categroies.size() != 0 && images.size() >= 4) {
            ProjectCategory.DataBean bean = categroies.get(i);
            holder.name.setText(bean.getName());
            holder.desc.setText("# "+descs.get(i));
            ImageLoader.load(mContext, images.get(i), holder.iv_mame);
            if (i == 3) {
                holder.view.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
