package com.example.a19124.bysj

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class More_sousuo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_sousuo)
        val textView_more_sousuo=findViewById<TextView>(R.id.textview_more_chaxunsousuo)
        textView_more_sousuo.setOnClickListener{
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse(("https://www.baidu.com"))
            startActivity(intent)
        }
    }
    public fun fanhui(view: View){
        finish()
    }
}