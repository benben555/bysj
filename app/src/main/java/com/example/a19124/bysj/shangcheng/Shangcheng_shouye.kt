package com.example.a19124.bysj.shangcheng

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.example.a19124.bysj.R

class Shangcheng_shouye : AppCompatActivity() {
    lateinit var tvCoinOver:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.shangcheng_shouye)

            val txhydh=findViewById<LinearLayout>(R.id.txhydh)
            txhydh.setOnClickListener {
                val intent: Intent = Intent(this, Shangcheng_xiadanfukuan::class.java);
                startActivity(intent);
            }
            val bdwpdh=findViewById<LinearLayout>(R.id.bdwpdh)
            bdwpdh.setOnClickListener {
                val intent: Intent = Intent(this, Shangcheng_xiadanfukuan::class.java);
                startActivity(intent);
            }
            val lzhydh=findViewById<LinearLayout>(R.id.lzhydh)
            lzhydh.setOnClickListener {
                val intent: Intent = Intent(this, Shangcheng_xiadanfukuan::class.java);
                startActivity(intent);
            }
            val xlxdh=findViewById<LinearLayout>(R.id.xlxdh)
            xlxdh.setOnClickListener {
                val intent: Intent = Intent(this, Shangcheng_xiadanfukuan::class.java);
            startActivity(intent);
        }

        tvCoinOver = findViewById(R.id.tv_coin_over)
        tvCoinOver.setText("2000")
    }

}