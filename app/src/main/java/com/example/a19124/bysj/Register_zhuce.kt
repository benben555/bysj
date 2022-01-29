package com.example.a19124.bysj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Register_zhuce : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_zhuce)
        val button=findViewById<Button>(R.id.register_user_button)
        button.setOnClickListener{
            val name=findViewById<EditText>(R.id.name)
            val sex=findViewById<EditText>(R.id.sex)
            val password=findViewById<EditText>(R.id.password)
            val re_password=findViewById<EditText>(R.id.re_password)
            finish()
        }
    }
    fun fanhui(view: View) {
//        val intent: Intent = Intent(this, User_Register::class.java)
//        startActivity(intent)
        finish()
    }
}