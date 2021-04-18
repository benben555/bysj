package com.example.a19124.bysj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class User_Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shezhi_register)
    }
    public fun fanhui(view: View){
        finish()

    }
    public fun zhuce(view: View){
        val intent: Intent = Intent(this,Register_zhuce::class.java);
        startActivity(intent);
    }
    fun return_navigation_user_main(view: View){
        finish()
    }
}