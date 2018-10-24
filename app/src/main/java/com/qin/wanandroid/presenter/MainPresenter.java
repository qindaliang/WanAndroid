package com.qin.wanandroid.presenter;

import com.qin.wanandroid.R;
import com.qin.wanandroid.base.RxPresenter;
import com.qin.wanandroid.presenter.constract.MainContract;

/**
 * Create by qindl
 * on 2018/10/19
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{


    public MainPresenter(MainContract.View view) {
    this.view = view;
    }

    @Override
    public void switchView(int id) {
        switch (id) {
            case R.id.rb_chapter:
                view.transformOne();
                break;
            case R.id.rb_home:
                view.transformTwo();
                break;
            case R.id.rb_e:
                view.transformThree();
                break;
            default:
                break;
        }
    }
}
