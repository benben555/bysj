package com.example.a19124.bysj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class User_more : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_more)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.user_more,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.sousuo_item -> {
                Toast.makeText(this, "即将跳转到搜索页面", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, More_sousuo::class.java);
                startActivity(intent);
            }
            R.id.daka_item -> {
                Toast.makeText(this, "即将跳转到打卡页面", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, More_daka::class.java);
                startActivity(intent);
            }
            R.id.change_item -> {
                Toast.makeText(this, "即将切换到另外一种模式", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, More_change::class.java);
                startActivity(intent);
            }}
            return true
    }

}