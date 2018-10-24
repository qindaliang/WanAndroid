package com.qin.wanandroid.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.listener.OnItemClickListener;
import com.qin.wanandroid.model.ImageLoader;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.ui.viewhodler.NewProjectDetailViewHolder;
import com.qin.wanandroid.utils.StringUtil;

import java.util.List;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class NewProjectHomeAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context mContext;
    private List<SecondBanner.DataBean.DatasBean> datas;
    private OnItemClickListener mOnItemClickListener;

    public NewProjectHomeAdapter(Context context,List<SecondBanner.DataBean.DatasBean> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NewProjectDetailViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_new_project_detail, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        NewProjectDetailViewHolder holder = (NewProjectDetailViewHolder) viewHolder;
        SecondBanner.DataBean.DatasBean bean = datas.get(i);
        holder.author.setText(bean.getAuthor());
        holder.desc.setText(StringUtil.replaceBlank(bean.getDesc()));
        holder.name.setText(bean.getChapterName());
        holder.time.setText(bean.getNiceDate());
        ImageLoader.load(mContext,bean.getEnvelopePic() ,holder.desc_pic);
        holder.desc_pic.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View v) {
        mOnItemClickListener.onClick("");
    }
}
