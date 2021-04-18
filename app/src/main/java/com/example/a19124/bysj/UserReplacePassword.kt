package com.example.a19124.bysj

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class UserReplacePassword : AppCompatActivity() {
    var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_replace_password)
        val textview_user_replace_password_update = findViewById<Button>(R.id.textview_user_replace_password_update)
        textview_user_replace_password_update.setOnClickListener {
            //接收主码
            name=intent.getStringExtra("name")
            //数据库：查，改
            finish()
        }
        val imageView_replace_password_fanhui = findViewById<ImageView>(R.id.imageView_replace_password_fanhui)
        imageView_replace_password_fanhui.setOnClickListener {
            finish()
        }


    }
}