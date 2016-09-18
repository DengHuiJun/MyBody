package com.zero.mybody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
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

    public void getAllCategory() {

        Call<ResponseBody> call = mService.getAllCategory(MY_KEY);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String json = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }



}
