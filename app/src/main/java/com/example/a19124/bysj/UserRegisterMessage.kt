package com.example.a19124.bysj

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView


class UserRegisterMessage : AppCompatActivity() {
    var name:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_register_message)
        val button=findViewById<Button>(R.id.register_user_button)
        button.setOnClickListener{
            intent.putExtra("name","ok")
            setResult(Activity.RESULT_OK,intent)
            finish()

        }
        val imageView_register_message_fanhui=findViewById<ImageView>(R.id.imageView_register_message_fanhui)
        imageView_register_message_fanhui.setOnClickListener {
            finish()
        }

    }
}