package com.example.a19124.bysj

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.a19124.bysj.Adapter.CollectWordsAdapter
import com.example.a19124.bysj.Bean.UserInfo
import com.example.a19124.bysj.Utils.DBConnection


class User_shoucang : AppCompatActivity() {
    private var user:UserInfo = UserInfo.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_shoucang)

        val adapter:CollectWordsAdapter = CollectWordsAdapter(DBConnection.getCollectWords(user.username, "siji"))
        val recyclerView:RecyclerView = findViewById(R.id.rv_collect_words)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

    }
    public fun fanhui(view: View){
        finish()
    }
}