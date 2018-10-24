package com.qin.wanandroid.model.net;

import com.qin.wanandroid.BuildConfig;
import com.qin.wanandroid.constants.Constants;
import com.qin.wanandroid.model.http.api.BlogApi;
import com.qin.wanandroid.model.http.interceptor.HttpCacheInterceptor;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Create by qindl
 * on 2018/10/19
 */
public class RetrofitHelper {

    private static OkHttpClient okHttpClient;

    public static Retrofit getRetrofit() {
        initOkhttpClient();
        return new Retrofit.Builder()
                .baseUrl(BlogApi.HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static BlogApi getBlogApi(){
       return getRetrofit().create(BlogApi.class);
    }

    private static void initOkhttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(loggingInterceptor);
            }
            File cacheFile = new File(Constants.PATH_CACHE);
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
            //设置缓存
            builder.addNetworkInterceptor(new HttpCacheInterceptor());
            builder.addInterceptor(new HttpCacheInterceptor());
            builder.cache(cache);
            //设置超时
            builder.connectTimeout(10, TimeUnit.SECONDS);
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);
            okHttpClient = builder.build();
        }
    }
}
