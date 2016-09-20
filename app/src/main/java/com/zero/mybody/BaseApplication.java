package com.zero.mybody;

import android.app.Application;

import com.zero.mybody.bean.CategoryResult;

import java.util.ArrayList;

/**
 * Created by zero on 16-9-20.
 */
public class BaseApplication extends Application {

    // 全局缓存标题
    public static ArrayList<CategoryResult.Category> TITLE_LIST = new ArrayList<>(10);

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
