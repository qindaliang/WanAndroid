package com.qin.wanandroid.presenter;

import com.qin.wanandroid.base.RxPresenter;
import com.qin.wanandroid.model.DataManager;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.bean.category.Category;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.http.CommonSubscriber;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;
import com.qin.wanandroid.presenter.constract.CategoryContract;
import com.qin.wanandroid.presenter.constract.CommonBlogContract;
import com.qin.wanandroid.utils.RxUitl;

/**
 * Create by qindl
 * on 2018/10/22
 */
public class CategoryPresenter extends RxPresenter<CategoryContract.View> implements CategoryContract.Presenter {

    public CategoryPresenter(CategoryContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTree() {
        addSubscrible(DataManager.getInstance().getCategory()
                .compose(RxUitl.<Category>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<Category>(view) {
                    @Override
                    public void onNext(Category category) {
                        view.showTree(category);
                    }

                    @Override
                    public void onComplete() {
                        view.stopRefresh(true);
                    }
                }));
    }
}
