package com.zero.mybody.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import com.zero.mybody.jsonResult.CategoryResult.Category;
import com.zero.mybody.db.column.CategoryColumn;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zero on 16-9-21.
 */
public class DataManager implements CategoryDao{

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

    private void add(@NonNull Category category) {
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


    @Override
    public void addCategory(Category... category) {
        if (category.length <= 0) {
            return;
        }

        BriteDatabase.Transaction transaction = mBriteDatabase.newTransaction();
        try {
            for (Category item : category) {
                add(item);
            }
            transaction.markSuccessful();
        } finally {
            transaction.end();
        }
    }

    @Override
    public Observable<List<Category>> getCategoryList() {
        String[] projection = {CategoryColumn.ID, CategoryColumn.TITLE};
        String sql = String.format("SELECT %s FROM %s", TextUtils.join(",", projection), CategoryColumn.TABLE_NAME);
        return mBriteDatabase.createQuery(CategoryColumn.TABLE_NAME, sql, new String[]{})
                .mapToList(new Func1<Cursor, Category>() {
            @Override
            public Category call(Cursor cursor) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(CategoryColumn.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(CategoryColumn.TITLE));
                Log.d("zero",id+title);
                return new Category(id, title);
            }
        });
    }

    @Override
    public void deleteAllCategory() {
        mBriteDatabase.delete(CategoryColumn.TABLE_NAME, null, new String[]{});
    }
}
