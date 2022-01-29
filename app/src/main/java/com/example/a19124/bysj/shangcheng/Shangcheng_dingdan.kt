package com.example.a19124.bysj.shangcheng

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.a19124.bysj.Adapter.OrderAdapter
import com.example.a19124.bysj.Bean.UserInfo
import com.example.a19124.bysj.R
import com.example.a19124.bysj.Utils.DBConnection

class Shangcheng_dingdan : AppCompatActivity() {
    var user:UserInfo = UserInfo.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shangcheng_dingdan)
        val adapter:OrderAdapter = OrderAdapter(DBConnection.getOrder(user.username))
        val recyclerView: RecyclerView = findViewById(R.id.rv_order_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }
}