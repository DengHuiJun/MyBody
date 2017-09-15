package com.zero.mybody.net;

import com.zero.mybody.jsonResult.CategoryDetailResult;
import com.zero.mybody.jsonResult.CategoryItemResult;
import com.zero.mybody.jsonResult.CategoryResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zero on 16-9-14.
 */
public interface CategoryService {

    @GET("classify")
    Observable<CategoryResult> getAllCategory();

    @GET("list")
    Observable<CategoryItemResult> getCategoryList(@Query("id")int id, @Query("page")int page, @Query("rows")int rows);

    @GET("list")
    Observable<CategoryItemResult> getDefaultCategoryList(@Query("id")int id);

    @GET("show")
    Observable<CategoryDetailResult> getCategoryDetail(@Query("id")int id);
}
