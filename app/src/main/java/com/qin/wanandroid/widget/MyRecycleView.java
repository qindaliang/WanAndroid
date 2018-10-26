package com.qin.wanandroid.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.qin.wanandroid.application.App;
import com.qin.wanandroid.application.GlideApp;

/**
 * Create by qindl
 * on 2018/10/25
 */
public class MyRecycleView extends RecyclerView {

    private Context mContext;

    public MyRecycleView(@NonNull Context context) {
        super(context);
        this.mContext =  App.getInstance().getApplicationContext();
    }

    public MyRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext =  App.getInstance().getApplicationContext();
    }

    public MyRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = App.getInstance().getApplicationContext();
        init();
    }

    private void init() {
        addOnScrollListener(new MyScrollListener());
    }

    class MyScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            switch (newState) {
                case SCROLL_STATE_IDLE:
                    GlideApp.with(mContext).resumeRequests();
                    Log.i("TAG", "onScrollStateChanged: ");
                    break;
                case SCROLL_STATE_SETTLING:
                    GlideApp.with(mContext).pauseRequests();
                    break;
                case SCROLL_STATE_DRAGGING:
                    GlideApp.with(mContext).pauseRequests();
                    break;
                default:
                    GlideApp.with(mContext).pauseRequests();
                    break;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }
}
