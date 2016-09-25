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
            + "CID integer primary key autoincrement not null,"
            + "createdTime long,"
            + "lastUpdateTime long,"
            + "id integer not null,"
            + "keywords varchar(50),"
            + "name varchar(50),"
            + "seq integer,"
            + "title varchar(50),"
            + "description varchar(255))";

    private static final String SQL_CREATE_CATEGORY_ITEM_TABLE = "create table t_category_item("
            + "CID integer primary key autoincrement not null,"
            + "createdTime long,"
            + "lastUpdateTime long,"
            + "id integer not null,"
            + "keywords varchar(50),"
            + "title varchar(50),"
            + "description varchar(255),"
            + "infoclass integer not null,"
            + "fcount integer,"
            + "rcount integer,"
            + "count integer,"
            + "time long,"
            + "img varchar(100))";

    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CATEGORY_TABLE);
        db.execSQL(SQL_CREATE_CATEGORY_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
