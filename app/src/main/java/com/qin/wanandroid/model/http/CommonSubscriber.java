package com.qin.wanandroid.model.http;

import android.util.Log;
import com.qin.wanandroid.base.BaseContract;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Create by qindl
 * on 2018/10/20
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private static final String TAG = "TAG";
    private BaseContract.BaseView mBaseView;

    public CommonSubscriber(BaseContract.BaseView mBaseView) {
        this.mBaseView = mBaseView;
    }


    @Override
    public void onError(Throwable t) {
        if (mBaseView == null) {
            return;
        }
        mBaseView.showMsg(t.getMessage());
        Log.d(TAG, "onError:" + t.getMessage());
    }
}
