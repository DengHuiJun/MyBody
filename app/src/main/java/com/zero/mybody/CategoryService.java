package com.zero.mybody;

import com.zero.mybody.bean.CategoryDetail;
import com.zero.mybody.bean.CategoryItem;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by zero on 16-9-14.
 */
public interface CategoryService {

    @GET("classify")
    Call<ResponseBody> getAllCategory(@Header("apikey")String key);

    @GET("list")
    Call<List<CategoryItem>> getCategoryList(@Header("apikey")String key, @Query("id")int id, @Query("page")int page, @Query("rows")int rows);

    @GET("list")
    Call<List<CategoryItem>> getDefaultCategoryList(@Header("apikey")String key);

    @GET("show")
    Call<CategoryDetail> getCategoryDetail(@Header("apikey")String key, @Query("id")int id);
}
