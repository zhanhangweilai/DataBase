package com.example.lh.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by lihang on 17-6-30.
 */

public class DBHelper {
    private ArrayList<Person> arrayList;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private String string = "aa";
    public DBHelper(Context context, String db_name) {
        databaseHelper = new DatabaseHelper(context, db_name, null, 2);
        db = databaseHelper.getReadableDatabase();
    }

    public void query (String name) {
        db.query("person", new String[] { "_id", "name", "age" },"name = ?",new String[] {name}, null, null, null);
    }

    public void insert(ArrayList<Person> arrayList) {
        db.beginTransaction();
        try {
            for(Person person: arrayList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name",person.getName());
                contentValues.put("age",person.getAge());
                contentValues.put("_id", 0);
                db.insert("person", null, contentValues);
            }
        }catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        db.close();
        databaseHelper.close();
    }
    public int getVersion() {
        return db.getVersion();
    }

    public void closeDB() {
        db.close();
        databaseHelper.close();
    }
    public void test () {
        if ("".equals(string)) {
            throw new NullPointerException("string is null");
        }
    }
}
