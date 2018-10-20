package com.qin.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.qin.wanandroid.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create by qindl
 * on 2018/10/19
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    public static final String TAG = "TAG";
    private Unbinder mBind;
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mBind = ButterKnife.bind(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        onCreateView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void showSnackBar(View view, String str) {
        mSnackbar = Snackbar.make(view, str, Snackbar.LENGTH_SHORT);
        mSnackbar.getView().setBackgroundColor(getResources().getColor(R.color.snack_default, null));
        mSnackbar.show();
    }

    @Subscribe
    public void onEventMainThread(String flags) {

    }

    public void onCreateView() {
    }

    public abstract void initData();

    public abstract int getLayout();
}
