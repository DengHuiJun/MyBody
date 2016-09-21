package com.zero.mybody.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zero on 16-9-21.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mybody.db";

    private static final String SQL_CREATE_CATEGORY_TABLE = "create table t_category("
            + "categoryPOID integer primary key autoincrement not null,"
            + "createdTime long,"
            + "lastUpdateTime long,"
            + "id integer not null,"
            + "keywords varchar(50),"
            + "name varchar(50),"
            + "seq integer,"
            + "title varchar(50),"
            + "description varchar(255))";

//    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CATEGORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
