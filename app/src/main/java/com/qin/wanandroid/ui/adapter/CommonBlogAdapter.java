package com.qin.wanandroid.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qin.wanandroid.R;
import com.qin.wanandroid.listener.OnItemClickListener;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.ui.viewhodler.CommonBlogViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by qindl
 * on 2018/10/22
 */
public class CommonBlogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HistoryChapters.DataBean.DatasBean> mDatasBeanList = new ArrayList<>();
    private List<Integer> isClick = new ArrayList<>();
    private Context mContext;

    public CommonBlogAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_common_blog, null);
        return new CommonBlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final CommonBlogViewHolder hodler = (CommonBlogViewHolder) viewHolder;
        hodler.mTitle.setText(mDatasBeanList.get(i).getTitle());
        hodler.mTime.setText(mDatasBeanList.get(i).getNiceDate());
        hodler.mCount.setText(String.valueOf((mContext.getResources().getString(R.string.pageview) + mDatasBeanList.get(i).getId())));
        final int color = mContext.getResources().getColor(R.color.recycleview_gray);
        final int id = mDatasBeanList.get(i).getId();
        hodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hodler.mTitle.setTextColor(color);
                            hodler.mTime.setTextColor(color);
                            hodler.mCount.setTextColor(color);
                        }
                    }, 300);
                    if (!isClick.contains(id)){
                        isClick.add(id);
                    }else {
                    }
                    mOnItemClickListener.onClick(mDatasBeanList.get(i).getLink());
                }
            }
        });
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onClickListener) {
        this.mOnItemClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return mDatasBeanList == null ? 0 : mDatasBeanList.size();
    }

    public void setData(HistoryChapters.DataBean.DatasBean datasBean) {
        mDatasBeanList.add(datasBean);
    }

    public void setLoadData(HistoryChapters.DataBean dataBean) {
        //    notifyItemRangeRemoved(0, this.mDatasBeanList.size());
        mDatasBeanList.clear();
        this.mDatasBeanList = dataBean.getDatas();
        notifyItemRangeChanged(0, dataBean.getDatas().size());
    }

    public void setLoadMore(HistoryChapters.DataBean dataBean) {
        int index = getItemCount();
        this.mDatasBeanList.addAll(dataBean.getDatas());
        for (int i = index; i < this.mDatasBeanList.size(); i++) {
            notifyItemInserted(i);
        }
    }
}
