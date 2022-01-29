package com.example.a19124.bysj

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.support.v7.app.AppCompatActivity
import android.widget.*
import com.example.a19124.bysj.Utils.DBConnection


class UserRegisterMessage : AppCompatActivity() {
    var name:String?=null
    lateinit var et_username:EditText
    lateinit var et_email:EditText
    lateinit var et_mobile:EditText
    lateinit var et_sex:EditText
    lateinit var et_password:EditText
    lateinit var et_re_password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_register_message)
        et_username = findViewById(R.id.register_username)
        et_password = findViewById(R.id.register_password)
        et_mobile = findViewById(R.id.register_mobile)
        et_sex = findViewById(R.id.register_sex)
        et_email = findViewById(R.id.register_email)
        et_re_password = findViewById(R.id.register_re_password)

        val button=findViewById<Button>(R.id.register_user_button)
        button.setOnClickListener{
            var username = et_username.editableText.toString()
            var password = et_password.editableText.toString()
            var email = et_email.editableText.toString()
            var mobile = et_mobile.editableText.toString()
            var sex = et_sex.editableText.toString()
            var re_password = et_re_password.editableText.toString()
            if(password!=re_password)
                Toast.makeText(this,"两次密码输入不一致，请重新输入",Toast.LENGTH_SHORT).show()
            else if(username==""||password==""||email==""||mobile==""||sex==""||re_password==""){
                Toast.makeText(this,"信息输入不完整，请检查输入",Toast.LENGTH_SHORT).show()
            }
            else {
                DBConnection.register(username,password,mobile,email,sex)
                intent.putExtra("name", "更换用户")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }





        val imageView_register_message_fanhui=findViewById<ImageView>(R.id.imageView_register_message_fanhui)
        imageView_register_message_fanhui.setOnClickListener {
            finish()
        }

    }
}