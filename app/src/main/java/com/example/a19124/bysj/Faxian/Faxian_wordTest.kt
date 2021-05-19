package com.example.a19124.bysj.Faxian

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.a19124.bysj.Bean.TestWordsRespository
import com.example.a19124.bysj.Bean.UserInfo
import com.example.a19124.bysj.Bean.WordBean
import com.example.a19124.bysj.R
import java.util.*
import kotlin.properties.Delegates

class Faxian_wordTest : AppCompatActivity(),View.OnClickListener {
    lateinit var tv_word:TextView
    lateinit var bt_1:Button
    lateinit var bt_2:Button
    lateinit var bt_3:Button
    lateinit var bt_4:Button
    lateinit var bt_dont_know:Button
    lateinit var tv_last_cnt:TextView
    lateinit var respository: TestWordsRespository
    var ans = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.faxian_wordtest)
        respository = TestWordsRespository.getInstance(UserInfo.getInstance().database)
        init()
        setWord()
    }

    public fun fanhui(view: View){
        finish()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.bt_test_1-> isRight(1)
            R.id.bt_test_2-> isRight(2)
            R.id.bt_test_3 -> isRight(3)
            R.id.bt_test_4 -> isRight(4)
            R.id.bt_dont_kown -> isRight(5)
            R.id.bt_back -> finish()
        }
        if( respository.isTestWordsEmpty) {
            //显示测量结果
            return
        }
        setWord()
    }

    private fun init() {
        tv_word = findViewById(R.id.tv_test_word)
        //tv_last_cnt = findViewById(R.id.tv_test_last)

        bt_1 = findViewById(R.id.bt_test_1)
        bt_2 = findViewById(R.id.bt_test_2)
        bt_3 = findViewById(R.id.bt_test_3)
        bt_4 = findViewById(R.id.bt_test_4)

        bt_dont_know = findViewById(R.id.bt_dont_kown)

        bt_1.setOnClickListener(this)
        bt_2.setOnClickListener(this)
        bt_3.setOnClickListener(this)
        bt_4.setOnClickListener(this)
        bt_dont_know.setOnClickListener(this)


        respository.initTestWords()

    }
    private fun setWord() {
        var word:WordBean = respository.word
        tv_word.setText(word.word)


        //给另外的按钮设置错误选项
        var list = respository.confusedWords
        bt_1.setText(list[0].msg)
        bt_2.setText(list[1].msg)
        bt_3.setText(list[2].msg)
        bt_4.setText(list[3].msg)

        bt_1.setBackgroundResource(R.drawable.test_word_wrong)
        bt_2.setBackgroundResource(R.drawable.test_word_wrong)
        bt_3.setBackgroundResource(R.drawable.test_word_wrong)
        bt_4.setBackgroundResource(R.drawable.test_word_wrong)

        //设置正确选项
        ans = Random().nextInt(3)+1

        when(ans){
            1 -> {bt_1.setText(word.msg);bt_1.setBackgroundResource(R.drawable.test_word_right)}
            2 -> {bt_2.setText(word.msg);bt_2.setBackgroundResource(R.drawable.test_word_right)}
            3 -> {bt_3.setText(word.msg);bt_3.setBackgroundResource(R.drawable.test_word_right)}
            4 -> {bt_4.setText(word.msg);bt_4.setBackgroundResource(R.drawable.test_word_right)}
        }
        //显示剩余待测单词数
        //tv_last_cnt.setText(respository.size)
    }
    private fun isRight(i:Int){
        if( i == ans) {
            respository.recognizeWord()
        }
    }

}