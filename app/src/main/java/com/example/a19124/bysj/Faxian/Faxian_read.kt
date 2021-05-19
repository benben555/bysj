package com.example.a19124.bysj.Faxian

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.a19124.bysj.Bean.UserInfo
import com.example.a19124.bysj.Bean.WenzhangBean
import com.example.a19124.bysj.R
import com.example.a19124.bysj.Utils.DBConnection

class Faxian_read : AppCompatActivity() {
    var user: UserInfo = UserInfo.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.faxian_read)
        var cihuinum:Int=user.cihuiliang/1000+1
        var wenzhang=WenzhangBean(DBConnection.wenzhang(cihuinum))
        val read_title=findViewById<TextView>(R.id.read_title)
        val read_text=findViewById<TextView>(R.id.read_text)
        read_title.setText(wenzhang.title)
        read_text.setText(wenzhang.text)
    }
    public fun fanhui(view: View){
        finish()
    }
}