package com.example.a19124.bysj;

import android.content.Context;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteDatabase.CursorFactory;

import android.database.sqlite.SQLiteOpenHelper;

public class myopenhelper extends SQLiteOpenHelper {
    public myopenhelper(Context context) {
        super(context,"people.db",null, 1);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(_id integer primary key autoincrement,name char(20),salary char(20),phone char(20))");

    }

    @Override

    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
// TODO Auto-generated method stub

        System.out.print("数据库升级了!!!");

    }

}
