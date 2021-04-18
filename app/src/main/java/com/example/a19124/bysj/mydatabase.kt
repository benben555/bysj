package com.example.a19124.bysj

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class mydatabase(val context:Context,name:String,version:Int):
        SQLiteOpenHelper(context,name,null,version){
    val ss:String="creat table siji("+
            "num integer primary key autoincrement,"+
             "yinbiao text,"+
              "word text,"+
              "shiyi text,"+
               "biaoji integer)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(ss)
        Toast.makeText(context,"ok",Toast.LENGTH_SHORT).show()
    }
    override  fun onUpgrade(db:SQLiteDatabase,oldversion:Int,netVersion:Int){}
}
