package com.example.a19124.bysj


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.util.Log
import android.view.View

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import java.util.List
//import com.mysql.jdbc.log.Log

class Sousuo_xianshi : AppCompatActivity() {

    var str:String?="null"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.sousuo_xianshi)
        str=intent.getStringExtra("message")
        val wordBean = WordBean(str)
         val textview_xianshi_bj=findViewById<TextView>(R.id.textview_xianshi_bj)
        when(wordBean.flag){
            4->textview_xianshi_bj.setText("四级 , 六级 , 考研")
            6->textview_xianshi_bj.setText("四级 , 六级 , 考研")
            3->textview_xianshi_bj.setText("四级 , 六级 , 考研 , 高考")
            7->textview_xianshi_bj.setText("四级 , 六级 , 考研")
            10->textview_xianshi_bj.setText("四级 , 六级 , 考研 , 有道")
            else->textview_xianshi_bj.setText("牛津")
        }

        val textview_xianshi_liju2=findViewById<TextView>(R.id.textview_xianshi_jinyici)
        textview_xianshi_liju2.setText(wordBean.uid.toString())

        val textview_xianshi_yinbiao=findViewById<TextView>(R.id.textview_xianshi_yinbiao)
        if(wordBean.msg==null) textview_xianshi_yinbiao.setText(" ")
        else textview_xianshi_yinbiao.setText(wordBean.yinbiao)
        val textview_xianshi_shiyi=findViewById<TextView>(R.id.textview_xianshi_shiyi)
        textview_xianshi_shiyi.setText(wordBean.msg)

        Log.d("Sousuo_xianshi",wordBean.toString())


        val TextView_a:TextView=findViewById<TextView>(R.id.textview_xianshi_danci)
        TextView_a.post(Runnable { TextView_a.setText(wordBean.word) })




       val messageView:TextView=(findViewById(R.id.message));
        messageView.post(Runnable { messageView.setText(wordBean.word) })
 //       messageView.setText(intent.getStringExtra("message"));
//        val thread = object :Thread(){
//            public override fun run() {
//                val conn = DBConnection.getConnection()
//                val statement: Statement  = conn.createStatement();
//                val sql = "SELECT * FROM bysj.kaoyan LIMIT 0, 1000"
//                // 执行sql查询语句并获取查询信息
//                val rSet: ResultSet = statement.executeQuery(sql);
//                while (rSet.next()){
//                    Log.d("mysql11111",rSet.toString());
//                }
//            }
//        }
//        thread.start()
    }
    public fun fanhui(view: View){

        finish()
    }
}
