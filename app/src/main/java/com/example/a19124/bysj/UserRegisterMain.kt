package com.example.a19124.bysj

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat.startActivity


class UserRegisterMain : AppCompatActivity() {

    var name:String?="error"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_register_main)
        val user_register=findViewById<Button>(R.id.button_register_ok)
        user_register.setOnClickListener {
            //传回主码
            intent.putExtra("name","更换用户")
            setResult(Activity.RESULT_OK,intent)
            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
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

}