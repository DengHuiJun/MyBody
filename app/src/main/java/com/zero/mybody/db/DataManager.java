package com.zero.mybody.db;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import com.zero.mybody.bean.CategoryResult.Category;

import rx.schedulers.Schedulers;

/**
 * Created by zero on 16-9-21.
 */
public class DataManager {

    private BriteDatabase mBriteDatabase;

    private static DataManager INSTANCE;

    public static DataManager getInstance(Context context) {
        if (context == null) {
            throw new NullPointerException("context must not be null!");
        }

        if (INSTANCE == null) {
            INSTANCE = new DataManager(context);
        }

        return INSTANCE;
    }

    private DataManager(Context context) {
        mBriteDatabase = SqlBrite.create().wrapDatabaseHelper(new DatabaseHelper(context), Schedulers.io());
    }

    public void add(@NonNull Category category) {
        ContentValues cv = new ContentValues();
        cv.put("id", category.getId());
        cv.put("name", category.getName());
        cv.put("seq", category.getSeq());
        cv.put("title", category.getTitle());
        cv.put("description", category.getDescription());
        cv.put("keywords", category.getKeywords());
        cv.put("createdTime", System.currentTimeMillis());
        cv.put("lastUpdateTime", System.currentTimeMillis());
        mBriteDatabase.insert("t_category", cv);
    }

}
