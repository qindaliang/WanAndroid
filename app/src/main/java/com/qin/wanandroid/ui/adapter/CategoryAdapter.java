package com.qin.wanandroid.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.qin.wanandroid.R;
import com.qin.wanandroid.model.bean.category.Category;
import com.qin.wanandroid.ui.viewhodler.CategoryViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by qindl
 * on 2018/10/26
 */
public class CategoryAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Category.DataBean> datas = new ArrayList<>();

    public CategoryAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CategoryViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_category, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CategoryViewHolder holder = (CategoryViewHolder) viewHolder;
        holder.tv.setText(datas.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setTreeData(List<Category.DataBean> dataBean){
        datas.clear();
        datas.addAll(dataBean);
        notifyItemRangeChanged(0,datas.size());
    }
}
