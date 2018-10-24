package com.qin.wanandroid.utils;

import com.qin.wanandroid.model.http.exception.ApiExcetion;
import com.qin.wanandroid.model.http.exception.ExceptionHandle;
import com.qin.wanandroid.model.http.exception.ServerException;
import com.qin.wanandroid.model.http.response.BaseBlogResponse;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by qindl
 * on 2018/10/20
 */
public class RxUitl {

    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 返回结果的统一处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<BaseBlogResponse<T>, T> handleResult() {
        return new FlowableTransformer<BaseBlogResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<BaseBlogResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseBlogResponse<T>, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(BaseBlogResponse<T> tBaseBlogResponse) throws Exception {
                        if (tBaseBlogResponse.getErrorCode() == 0)
                            return createData(tBaseBlogResponse.getData());
                        else
                            return Flowable.error(new ServerException(tBaseBlogResponse.getErrorMsg()));
                    }
                });
            }
        };
    }

    private static <T> Publisher<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    public static <T> FlowableTransformer<BaseBlogResponse<T>, T> retryWhenNetworkError() {
        return new FlowableTransformer<BaseBlogResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<BaseBlogResponse<T>> upstream) {
                return upstream.map(new ServerResultFunc<T>())
                        .onErrorResumeNext(new ErrorResumeNext<T>())
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static class ServerResultFunc<T> implements Function<BaseBlogResponse<T>, T> {
        @Override
        public T apply(BaseBlogResponse<T> tBaseBlogResponse) throws Exception {
            if (tBaseBlogResponse.getErrorCode() == 0)
                return tBaseBlogResponse.getData();
            else
                return null;
        }
    }

    public static class ErrorResumeNext<T> implements Function<Throwable, Flowable<T>> {
        @Override
        public Flowable<T> apply(Throwable throwable) throws Exception {
            return Flowable.error(ExceptionHandle.handleException(throwable));
        }
    }
}
