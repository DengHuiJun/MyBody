package com.zero.mybody;

import android.support.v4.widget.ViewDragHelper;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zero on 16-9-14.
 */
public interface CategoryService {

    @GET("90-86")
    Observable<ResultEntity> getCategoryList(@Query("showapi_appid") String appId, @Query("showapi_sign") String key,
                                           @Query("showapi_timestamp") String time, @Query("showapi_res_gzip") String gzip);
}
