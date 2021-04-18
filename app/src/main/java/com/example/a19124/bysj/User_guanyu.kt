package com.example.a19124.bysj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.user_guanyu.*

class User_guanyu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_guanyu)
        button_guanyu_jiancha.setOnClickListener{
            Toast.makeText(this,"已经是最新版本!",Toast.LENGTH_SHORT).show()
        }
    }
    public fun fanhui(view: View){

       finish()
    }
}