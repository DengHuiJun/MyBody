package com.zero.mybody.net;

import com.zero.mybody.jsonResult.Category;
import com.zero.mybody.jsonResult.CategoryList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hui_deng on 2017/9/30.
 */

public interface ReqNewsServiceApi {

    @GET(HealthApi.CATEGORY_URL)
    Observable<Category> getCategories();

    @GET(HealthApi.DETAIL_URL)
    Observable<CategoryList> getNewsListById(@Query("tid") long tid);
}
