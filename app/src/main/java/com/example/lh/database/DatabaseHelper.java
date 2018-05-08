package com.example.lh.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lihang on 17-6-29.
 */

class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context, String database_name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,database_name, factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("lihang"+TAG,"excute oncreate");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("lihang"+TAG,"excute onUpgrade");
        sqLiteDatabase.execSQL("ALTER TABLE person ADD COLUME sex VARCHAR(10)");
    }
}
