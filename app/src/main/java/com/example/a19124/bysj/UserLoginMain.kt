package com.example.a19124.bysj

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.a19124.bysj.Utils.SecurityLoginUtils
import com.kongzue.dialog.v2.WaitDialog

//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat.startActivity


class UserLoginMain : AppCompatActivity() {
    lateinit var et_username:EditText
    lateinit var et_password:EditText

    var name:String?="error"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login_main)

        et_username = findViewById(R.id.user_name)
        et_password = findViewById(R.id.user_password)

        showLoadingDialog()
        checkLoginStatus()
        val bt_user_login=findViewById<Button>(R.id.button_login_ok)
        bt_user_login.setOnClickListener {
            //传回主码
            intent.putExtra("name","更换用户")
            setResult(Activity.RESULT_OK,intent)
            var username = et_username.editableText.toString()
            var password = et_password.editableText.toString()

            if(SecurityLoginUtils.getInstance(this).login(username,password)) {
                val intent: Intent = Intent(this, MainActivity::class.java);
                intent.putExtra("user_name",username)
                startActivity(intent);
            } else{
                showToast("用户名或密码错误")
            }
        }
        val imageView_register_main_fanhui=findViewById<ImageView>(R.id.imageView_register_main_fanhui)
        imageView_register_main_fanhui.setOnClickListener {
            finish()
        }
        val user_register_to=findViewById<TextView>(R.id.textview_3)
        user_register_to.setOnClickListener {
            val intent=Intent(this,UserRegisterMessage::class.java)
            startActivityForResult(intent,1)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode)
        {
            1->if(resultCode== Activity.RESULT_OK)
            {
                //返回的主码
                name=data?.getStringExtra("name")
                intent.putExtra("name",name)
                setResult(Activity.RESULT_OK,intent)
//                val intent: Intent = Intent(this, MainActivity::class.java);
//                startActivity(intent);
                finish()
            }

        }
    }
    private fun showToast(msg:String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
    private fun showLoadingDialog() {
        WaitDialog.show(this,"载入中...")
    }
    private fun checkLoginStatus() {
        if (SecurityLoginUtils.getInstance(this).loginStatus) {
            WaitDialog.dismiss()

            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }else{
            WaitDialog.dismiss()
        }
    }

}