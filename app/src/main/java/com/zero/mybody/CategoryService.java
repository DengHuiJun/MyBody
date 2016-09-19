package com.zero.mybody;

import com.zero.mybody.bean.CategoryDetailResult;
import com.zero.mybody.bean.CategoryItemResult;
import com.zero.mybody.bean.CategoryResult;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zero on 16-9-14.
 */
public interface CategoryService {

    @GET("classify")
    Observable<CategoryResult> getAllCategory(@Header("apikey")String key);

    @GET("list")
    Observable<CategoryItemResult> getCategoryList(@Header("apikey")String key, @Query("id")int id, @Query("page")int page, @Query("rows")int rows);

    @GET("list")
    Observable<CategoryItemResult> getDefaultCategoryList(@Header("apikey")String key, @Query("id")int id);

    @GET("show")
    Observable<CategoryDetailResult> getCategoryDetail(@Header("apikey")String key, @Query("id")int id);
}
