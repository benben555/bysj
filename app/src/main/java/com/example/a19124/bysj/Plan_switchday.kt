package com.example.a19124.bysj

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Plan_switchday : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plan_switchday)
    }
    public fun fanhui(view: View) {
        finish()
    }
}