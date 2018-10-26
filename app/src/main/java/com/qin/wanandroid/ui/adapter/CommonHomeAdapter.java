package com.qin.wanandroid.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qin.wanandroid.R;
import com.qin.wanandroid.application.GlideApp;
import com.qin.wanandroid.listener.OnItemClickListener;
import com.qin.wanandroid.model.ImageLoader;
import com.qin.wanandroid.model.bean.home.HomeBanner;
import com.qin.wanandroid.model.bean.home.HomeMore;
import com.qin.wanandroid.model.bean.home.ProjectCategory;
import com.qin.wanandroid.model.bean.home.SecondBanner;
import com.qin.wanandroid.ui.viewhodler.EmptyHolder;
import com.qin.wanandroid.ui.viewhodler.HomeBannerViewHolder;
import com.qin.wanandroid.ui.viewhodler.HomePageListHolder;
import com.qin.wanandroid.ui.viewhodler.NewProjectViewHolder;
import com.qin.wanandroid.ui.viewhodler.ProjectCategoryViewHolder;
import com.qin.wanandroid.ui.viewhodler.QualityChapterViewHolder;
import com.qin.wanandroid.utils.StringUtil;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class CommonHomeAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context mContext;
    private static final int HOME_BANNER = 0;
    private static final int NEW_PROJECT = 1;
    private static final int CATEGORY = 2;
    private static final int QUALITY_CHAPTER = 3;
    private static final int MORE = 4;
    private List<String> images = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<HomeBanner.DataBean> bannerDatas = new ArrayList<>();
    private List<SecondBanner.DataBean.DatasBean> secondBanners = new ArrayList<>();
    private List<HomeMore.DataBean.DatasBean> homeMores = new ArrayList<>();
    private List<ProjectCategory.DataBean> categorys = new ArrayList<>();
    private List<HomeMore.DataBean.DatasBean> totalDatas = new ArrayList<>();
    private OnItemHomeMoreClickListener mOnItemClickListener;
    private boolean scrolling;

    public CommonHomeAdapter(Context context) {
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        int postion = (int) v.getTag();
        switch (v.getId()) {
            case R.id.iv_item_more_pic:
                mOnItemClickListener.onClick(v, "", postion);
                break;
            case R.id.ll_home_more_author:
                mOnItemClickListener.onClick(v, "", postion);
                break;
            default:
                break;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == HOME_BANNER) {
            return new HomeBannerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_banner, viewGroup, false));
        } else if (viewType == NEW_PROJECT) {
            return new NewProjectViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_new_project, viewGroup, false));
        } else if (viewType == CATEGORY) {
            return new ProjectCategoryViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_project_category, viewGroup, false));
        } else if (viewType == QUALITY_CHAPTER) {
            return new QualityChapterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_quality_chapter, viewGroup, false));
        } else if (viewType == MORE) {
            return new HomePageListHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_more_list, viewGroup, false));
        } else {
            return new EmptyHolder(LayoutInflater.from(mContext).inflate(R.layout.empty, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof HomeBannerViewHolder) {
            initHomePageBanner((HomeBannerViewHolder) viewHolder);
        } else if (viewHolder instanceof NewProjectViewHolder) {
            initNewProjectViewHodler((NewProjectViewHolder) viewHolder);
        } else if (viewHolder instanceof ProjectCategoryViewHolder) {
            initProjectCategoryViewHodler((ProjectCategoryViewHolder) viewHolder);
        } else if (viewHolder instanceof QualityChapterViewHolder) {
            initQualityChapterViewHolder((QualityChapterViewHolder) viewHolder);
        } else if (viewHolder instanceof HomePageListHolder) {
            initHomePageHolder((HomePageListHolder) viewHolder, i);
        }
    }

    private void initQualityChapterViewHolder(QualityChapterViewHolder holder) {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        QualityChapterAdapter adapter = new QualityChapterAdapter(mContext,images,titles,bannerDatas);
        holder.recyclerView.setAdapter(adapter);

    }

    private void initProjectCategoryViewHodler(ProjectCategoryViewHolder holder) {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.recycleView.setLayoutManager(manager);
        holder.recycleView.setItemAnimator(new DefaultItemAnimator());
        ProjectCategoryDetailAdapter adapter = new ProjectCategoryDetailAdapter(mContext, categorys, images, titles);
        holder.recycleView.setAdapter(adapter);

    }

    private void initHomePageHolder(@NonNull HomePageListHolder holder, int postion) {
        if (homeMores.size() != 0) {
            HomeMore.DataBean.DatasBean bean = homeMores.get(postion);
            String envelopePic = bean.getEnvelopePic();
            String desc = bean.getDesc();
            holder.author.setText(bean.getAuthor());
            holder.count.setText(String.valueOf(bean.getId()));
            holder.time.setText(bean.getNiceDate());

            if ("".equals(envelopePic)) {
                holder.desc_pic.setVisibility(View.GONE);
                ImageLoader.load(mContext, mContext.getResources().getDrawable(R.mipmap.all_category_img), holder.head_pic);
            } else {
                if (!scrolling) {
                    ImageLoader.load(mContext, bean.getEnvelopePic(), holder.desc_pic);
                    ImageLoader.load(mContext, bean.getEnvelopePic(), holder.head_pic);
                    holder.desc_pic.setVisibility(View.VISIBLE);
                }
            }

            if ("".equals(desc) && "".equals(envelopePic)) {
                holder.cardview.setVisibility(View.GONE);
            } else {
                holder.cardview.setVisibility(View.VISIBLE);
            }
            holder.desc.setText(StringUtil.replaceBlank(bean.getDesc()));
            holder.title.setText(StringUtil.replaceBlank(bean.getTitle()));
            holder.head_pic.setTag(postion);
            holder.desc_pic.setTag(postion);
//            holder.desc_pic.setOnClickListener(this);
//            holder.ll_author.setOnClickListener(this);
        }
    }

    private void initNewProjectViewHodler(@NonNull NewProjectViewHolder holder) {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager.setReverseLayout(false);
        holder.recyclerView.setLayoutManager(manager);
        //解决每次复用重绘item间距，内部View设置
        //   holder.recyclerView.addItemDecoration(new SpacesItemDecoration(LinearLayoutManager.HORIZONTAL, 10));
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        NewProjectHomeAdapter adapter = new NewProjectHomeAdapter(mContext, secondBanners);
        holder.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(String s) {

            }
        });
    }

    private void initHomePageBanner(HomeBannerViewHolder holder) {
        holder.banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        holder.banner.setImageLoader(new com.youth.banner.loader.ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                GlideApp.with(context).asDrawable().load(path).into(imageView);
            }
        });
        holder.banner.setImages(images);
        holder.banner.setBannerAnimation(Transformer.ZoomOut);
        holder.banner.setBannerTitles(titles);
        holder.banner.isAutoPlay(true);
        holder.banner.setDelayTime(2000);
        holder.banner.setIndicatorGravity(BannerConfig.CENTER);
        holder.banner.start();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HOME_BANNER;
        } else if (position == 1) {
            return NEW_PROJECT;
        } else if (position == 2) {
            return CATEGORY;
        } else if (position == 3) {
            return QUALITY_CHAPTER;
        } else if (position >= 4) {
            return MORE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return homeMores.size() - 4;
    }

    public void setScrolling(boolean scroll) {
        this.scrolling = scroll;
    }

    public interface OnItemHomeMoreClickListener {
        void onClick(View v, String s, int postion);
    }

    public void setOnItemHomeMoreClickListener(OnItemHomeMoreClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setRefreshData(List<HomeBanner.DataBean> dataBean) {
        if (dataBean != null) {
            bannerDatas.clear();
            bannerDatas = dataBean;
            for (int i = 0; i < dataBean.size(); i++) {
                titles.add(dataBean.get(i).getTitle());
                images.add(dataBean.get(i).getImagePath());
            }
            notifyItemRangeChanged(0, 1);
        }
    }

    public void setRefreshData2(List<SecondBanner.DataBean.DatasBean> dataBean) {
        if (dataBean != null) {
            secondBanners.clear();
            secondBanners = dataBean;
            notifyItemRangeChanged(1, 2);
        }
    }

    public void setRefreshCategoryData(List<ProjectCategory.DataBean> dataBean) {
        if (dataBean != null) {
            categorys.clear();
            categorys.addAll(dataBean);
            notifyItemRangeChanged(2, 3);
        }
    }

    public void setRefreshDataMore(List<HomeMore.DataBean.DatasBean> dataBean) {
        if (dataBean != null) {
            homeMores.clear();
            homeMores.addAll(dataBean);
            notifyItemRangeChanged(3, homeMores.size());
        }
    }

    public void setLoadMoreData(List<HomeMore.DataBean.DatasBean> datasBean) {
        int count = getItemCount();
        homeMores.addAll(datasBean);
        for (int i = count; i < homeMores.size(); i++) {
            notifyItemInserted(i);
        }
    }

}
