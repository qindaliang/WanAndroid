package com.qin.wanandroid.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Create by qindl
 * on 2018/10/24
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int oretation;

    public SpacesItemDecoration(int oretation, int space) {
        this.space = space;
        this.oretation = oretation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (LinearLayoutManager.VERTICAL == oretation) {
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0)
                outRect.top = 0;
            if (parent.getChildAdapterPosition(view) == state.getItemCount() - 1) {
                outRect.bottom = 0;
            }
        } else if (LinearLayoutManager.HORIZONTAL == oretation){
            outRect.right = space;
            if (parent.getChildAdapterPosition(view) == 0)
                outRect.left = 0;
            if (parent.getChildAdapterPosition(view) == state.getItemCount() - 1) {
                outRect.right = 0;
            }
        }
    }
}
