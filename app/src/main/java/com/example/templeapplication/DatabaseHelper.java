package com.example.templeapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DatabaseHelper";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Temple.db", null, 21);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists mytable(id integer primary key autoincrement,item text,price int,image int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists mytable");
        onCreate(db);
    }

    public void insertData(MyListData data) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("item",data.getItem());
        contentValues.put("price",data.getAmount());
        contentValues.put("image",data.getImgid());
        long mytable = sqLiteDatabase.insert("mytable", null, contentValues);
        Log.e(TAG, "insertData:" + mytable);


    }
    public ArrayList<MyListData> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM mytable", null);
        ArrayList<MyListData> courseModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                courseModalArrayList.add(new MyListData( cursorCourses.getString(1),cursorCourses.getInt(2),cursorCourses.getInt(3)));
            } while (cursorCourses.moveToNext());
        }

        cursorCourses.close();
        return courseModalArrayList;
    }
}
