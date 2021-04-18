package com.example.a19124.bysj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class User_plan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_plan)
        val button_plan_change=findViewById<Button>(R.id.button_plan_change)
        button_plan_change.setOnClickListener {
            val intent: Intent = Intent(this, com.example.a19124.bysj.Plan_switch::class.java);
            startActivity(intent);
        }
    }
    public fun fanhui(view: View){
        finish()
    }
}