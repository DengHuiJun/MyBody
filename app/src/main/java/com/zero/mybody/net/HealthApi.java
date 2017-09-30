package com.zero.mybody.net;

/**
 * Created by hui_deng on 2017/9/29.
 */

public class HealthApi {

    public static final String APPID = "24533";
    public static final String SECRECT =  "0be9d530a20240dc97ae839d73814cc4";

    private static final String QUERY_ID = "?showapi_appid=24533&showapi_sign=0be9d530a20240dc97ae839d73814cc4";

    public static final String BASE_URL = "http://route.showapi.com";
    public static final String CATEGORY_URL = "/90-86" + QUERY_ID;
    public static final String DETAIL_URL = "/90-87" + QUERY_ID;
    public static final String SINGLE_URL = "/90-88" + QUERY_ID;

}
