package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.a19124.bysj.R

class Navigation_Shangcheng_Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val rootView: View = inflater.inflate(R.layout.navigation_shangcheng_fragment,container,false)
        val button_shezhi_task=rootView.findViewById<Button>(R.id.button_shezhi_task)
//        var mLinearButton=rootView.findViewById<Button>(R.id.recycler_shangcheng)
        button_shezhi_task.setOnClickListener {
            val intent: Intent = Intent(activity, com.example.a19124.bysj.User_task::class.java);
            startActivity(intent);
        }
        val button_shangcheng_xiaoxi=rootView.findViewById<Button>(R.id.button_shangcheng_xiaoxi)
        button_shangcheng_xiaoxi.setOnClickListener {
            val intent: Intent = Intent(activity, com.example.a19124.bysj.Shangcheng_xiaoxi::class.java);
            startActivity(intent);
        }
        val button_shangcheng_dingdan=rootView.findViewById<Button>(R.id.button_shangcheng_dingdan)
        button_shangcheng_dingdan.setOnClickListener {
            val intent: Intent = Intent(activity, com.example.a19124.bysj.Shangcheng_dingdan::class.java);
            startActivity(intent);
        }
        return rootView
    }
//    private fun setlistener(){
//        val listener:ButtonListener=ButtonListener()
//        mLinearButton.setOnclickListener(listener)
//
//
//    }

}