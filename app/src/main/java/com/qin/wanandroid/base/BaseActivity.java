package com.qin.wanandroid.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

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
    private Toolbar mToolBar;
    private long mExitTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
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


    public void initToolBar(){
        mToolBar = findViewById(R.id.toolbar);
        if (mToolBar!=null){
            setSupportActionBar(mToolBar);
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

    public boolean quitSystem(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, R.string.quit_system,
                        Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            }else {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public void onCreateView() {
    }

    public abstract void initData();

    public abstract int getLayout();
}
