package com.qin.wanandroid.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Create by qindl
 * on 2018/10/24
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        outRect.right = space;
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.left = 0;
        if (parent.getChildAdapterPosition(view) == state.getItemCount()-1){
            outRect.right = 0;
        }
    }
}
