package com.example.a19124.bysj.Fuxi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.a19124.bysj.Utils.DBConnection
import com.example.a19124.bysj.R
import com.example.a19124.bysj.Bean.WordBean
import com.example.a19124.bysj.Bean.WordListRespository

class Fuxi_xunlian_beidanci : AppCompatActivity() {
    var str:String?="null"

    //拿到仓库类的单例
    var respository:WordListRespository = WordListRespository.getInstance("siji")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fuxi_xunlian_beidanci)

   //     str=intent.getStringExtra("recite")
        var word = respository.word
        set(word.toString())
        val button_beidanci_buqueding=findViewById<Button>(R.id.button_beidanci_buqueding)
        button_beidanci_buqueding.setOnClickListener {
            respository.changeRate(WordListRespository.UNCERTAIN)
            if(respository.remeberedAll()){
                finish()
            }
            set(respository.word.toString())
        }
        val button_beidanci_burenshi=findViewById<Button>(R.id.button_beidanci_burenshi)
        button_beidanci_burenshi.setOnClickListener {
            respository.changeRate(WordListRespository.UNRECOGNIZED)
            if(respository.remeberedAll()){
                finish()
            }
            set(respository.word.toString())
        }
        val button_beidanci_renshi=findViewById<Button>(R.id.button_beidanci_renshi)
        button_beidanci_renshi.setOnClickListener {
            respository.changeRate(WordListRespository.RECOGNIZED)
            if(respository.remeberedAll()){
                finish()
            }
            set(respository.word.toString())
        }

    }

    public fun fanhui(view: View){
        finish()
    }

    public fun set(_str: String?){
        val wordBean = WordBean(_str)

        val textview_beidanci_bj=findViewById<TextView>(R.id.textview_beidanci_bj)
        when(wordBean.flag){
            4->textview_beidanci_bj.setText("四级")
            6->textview_beidanci_bj.setText("六级")
            3->textview_beidanci_bj.setText("高考")
            7->textview_beidanci_bj.setText("考研")
            else->textview_beidanci_bj.setText("牛津")
        }
        val textview_beidanci_yinbiao=findViewById<TextView>(R.id.textview_beidanci_yinbiao)
        textview_beidanci_yinbiao.setText(wordBean.yinbiao)
        val textview_beidanci_shiyi=findViewById<TextView>(R.id.textview_beidanci_shiyi)
        textview_beidanci_shiyi.setText(wordBean.msg)
        Log.d("beidanci_xianshi",wordBean.toString())
        val textview_beidanci_word=findViewById<TextView>(R.id.textview_beidanci_word)
            textview_beidanci_word.post(Runnable { textview_beidanci_word.setText(wordBean.word) })
        val textview_beidanci_word1:TextView=(findViewById(R.id.textview_beidanci_word1));
        textview_beidanci_word1.post(Runnable { textview_beidanci_word1.setText(wordBean.word) })
    }
}