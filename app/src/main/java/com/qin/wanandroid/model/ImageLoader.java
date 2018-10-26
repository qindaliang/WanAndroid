package com.qin.wanandroid.model;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qin.wanandroid.R;
import com.qin.wanandroid.application.GlideApp;

/**
 * Create by qindl
 * on 2018/10/23
 */
public class ImageLoader {

    public static void load(Context context, String url, int defaultID, ImageView img) {
        GlideApp.with(context)
                .asDrawable()
                .load(url)
                .thumbnail(0.2f)
                .placeholder(defaultID)
                .error(defaultID)
                .into(img);
    }

    public static void load(Context context, String url,ImageView img) {
        GlideApp.with(context)
                .asDrawable()
                .load(url)
                .thumbnail(0.2f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(context.getResources().getColor(R.color.default_gray)))
                .error(new ColorDrawable(context.getResources().getColor(R.color.default_gray)))
                .into(img);
    }

    public static void load(Context context, Drawable drawable, ImageView img) {
        GlideApp.with(context)
                .asDrawable()
                .load(drawable)
                .thumbnail(0.2f)
                .placeholder(new ColorDrawable(context.getResources().getColor(R.color.default_gray)))
                .error(new ColorDrawable(context.getResources().getColor(R.color.default_gray)))
                .into(img);
    }

    public static void load(Context context, int id, ImageView img) {
        GlideApp.with(context)
                .asDrawable()
                .load(id)
                .thumbnail(0.2f)
                .placeholder(new ColorDrawable(context.getResources().getColor(R.color.default_gray)))
                .error(context.getResources().getDrawable(R.mipmap.all_category_img))
                .into(img);
    }
}
