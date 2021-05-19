package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.a19124.bysj.*
import com.example.a19124.bysj.Faxian.Faxian_read
import com.example.a19124.bysj.Faxian.Faxian_wordTest
import com.example.a19124.bysj.Faxian.Faxian_xiaojiangtang

class Navigation_faxian_Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val rootView: View = inflater.inflate(R.layout.navigation_faxian_fragment,container,false)

        val linear_faxian_xiaojiangtang=rootView.findViewById<LinearLayout>(R.id.linear_faxian_xiaojiangtang)
        linear_faxian_xiaojiangtang.setOnClickListener {
            val intent: Intent = Intent(activity, Faxian_xiaojiangtang::class.java);
            startActivity(intent);
        }
        val linear_faxian_read=rootView.findViewById<LinearLayout>(R.id.linear_faxian_read)
        linear_faxian_read.setOnClickListener {
            val intent: Intent = Intent(activity, Faxian_read::class.java);
            startActivity(intent);
        }
        val linear_faxian_wordtest=rootView.findViewById<LinearLayout>(R.id.linear_faxian_wordtest)
        linear_faxian_wordtest.setOnClickListener {
            val intent: Intent = Intent(activity, Faxian_wordTest::class.java);
            startActivity(intent);
        }


        return rootView

    }


}