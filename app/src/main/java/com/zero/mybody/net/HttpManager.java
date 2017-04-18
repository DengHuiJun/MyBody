package com.zero.mybody.net;

import com.zero.mybody.jsonResult.CategoryDetailResult;
import com.zero.mybody.jsonResult.CategoryItemResult;
import com.zero.mybody.jsonResult.CategoryResult;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zero on 16-9-18.
 */
public class HttpManager {

    private static final String BASE_URL = "http://www.tngou.net/api/info/";

    public static final String IMG_URL = "http://tnfs.tngou.net/image";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private CategoryService mService;

    private static class SingletonHolder {
        private static final HttpManager INSTANCE = new HttpManager();
    }

    public static HttpManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private HttpManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mService = mRetrofit.create(CategoryService.class);
    }

    public void requestGetAllCategory(Subscriber<CategoryResult.Category> subscriber) {
        mService.getAllCategory()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<CategoryResult, Observable<CategoryResult.Category>>() {
                    @Override
                    public Observable<CategoryResult.Category> call(CategoryResult httpResult) {
                        return Observable.from(httpResult.getCategories());
                    }
                })
                .subscribe(subscriber);
    }

    public void requestGetCategoryList(Subscriber<CategoryItemResult.CategoryItem> subscriber, int id) {
        mService.getDefaultCategoryList(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<CategoryItemResult, Observable<CategoryItemResult.CategoryItem>>() {
                    @Override
                    public Observable<CategoryItemResult.CategoryItem> call(CategoryItemResult categoryItemResult) {
                        return Observable.from(categoryItemResult.getCategoryItems());
                    }
                })
                .subscribe(subscriber);
    }

    public void requestGetCategoryDetail(Subscriber<CategoryDetailResult> subscriber, int id) {
        mService.getCategoryDetail(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
