package com.zero.mybody;

import android.os.Handler;
import android.os.Message;

import com.zero.mybody.bean.HttpResult;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zero on 16-9-18.
 */
public class HttpManager {

    private static final String MY_KEY = "e98b79f5091ab600ae3a3add2c0b3ecc";

    private static final String BASE_URL = "http://apis.baidu.com/tngou/info/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private CategoryService mService;

    public static final int REQUEST_GET_CATEGORY = 0x01;

    private static class SingletonHolder {
        private static final HttpManager INSTANCE = new HttpManager();
    }

    public static HttpManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public HttpManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = mRetrofit.create(CategoryService.class);
    }

    public void requestGetAllCategory(final Handler handler) {
        Call<HttpResult> call = mService.getAllCategory(MY_KEY);
        call.enqueue(new Callback<HttpResult>() {
            @Override
            public void onResponse(Call<HttpResult> call, Response<HttpResult> response) {
                HttpResult httpResult = response.body();
                if (httpResult != null && httpResult.isStatus()) {
                    Message msg = Message.obtain();
                    msg.what = REQUEST_GET_CATEGORY;
                    msg.obj = httpResult.getTngou();
                    handler.sendMessage(msg);
                }
            }

            @Override
            public void onFailure(Call<HttpResult> call, Throwable t) {

            }
        });
    }



}
