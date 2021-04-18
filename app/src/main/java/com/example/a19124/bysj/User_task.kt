package com.example.a19124.bysj

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class User_task : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_task)
    }
    public fun fanhui(view: View){
        finish()
    }
}