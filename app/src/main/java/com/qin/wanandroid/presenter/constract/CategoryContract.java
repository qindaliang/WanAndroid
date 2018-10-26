package com.qin.wanandroid.presenter.constract;

import com.qin.wanandroid.base.BaseContract;
import com.qin.wanandroid.model.bean.Blog.HistoryChapters;
import com.qin.wanandroid.model.bean.category.Category;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;

/**
 * Create by qindl
 * on 2018/10/22
 */
public interface CategoryContract {
    interface Presenter extends BaseContract.BasePresenter<View>{
        String TAG = "Presenter";
//        void loadList(int id, int page);
//        void loadMoreList(int id, int page);
        void loadTree();
    }

    interface View extends BaseContract.BaseView{
//        void showData(BaseBlogResponse<HistoryChapters.DataBean> chapters);
//        void showMoreData(BaseBlogResponse<HistoryChapters.DataBean> chapters);
        void stopRefresh(boolean isRefresh);
        void showTree(Category category);
    }
}
