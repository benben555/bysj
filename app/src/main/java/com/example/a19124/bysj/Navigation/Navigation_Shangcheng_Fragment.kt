package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.a19124.bysj.R
import com.example.a19124.bysj.shangcheng.Shangcheng_dingdan
import com.example.a19124.bysj.shangcheng.Shangcheng_xiadanfukuan
import com.example.a19124.bysj.shangcheng.Shangcheng_xiaoxi
import com.kongzue.dialog.v2.SelectDialog


class Navigation_Shangcheng_Fragment : Fragment() {
    lateinit var tv_coin_over:TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val rootView: View = inflater.inflate(R.layout.navigation_shangcheng_fragment, container, false)
        val button_shezhi_task=rootView.findViewById<Button>(R.id.button_shezhi_task)
//        var mLinearButton=rootView.findViewById<Button>(R.id.recycler_shangcheng)
        button_shezhi_task.setOnClickListener {
            val intent: Intent = Intent(activity, com.example.a19124.bysj.User_task::class.java);
            startActivity(intent);
        }
        val button_shangcheng_xiaoxi=rootView.findViewById<Button>(R.id.button_shangcheng_xiaoxi)
        button_shangcheng_xiaoxi.setOnClickListener {
            val intent: Intent = Intent(activity, Shangcheng_xiaoxi::class.java);
            startActivity(intent);
        }
        val button_shangcheng_dingdan=rootView.findViewById<Button>(R.id.button_shangcheng_dingdan)
        button_shangcheng_dingdan.setOnClickListener {
            val intent: Intent = Intent(activity, Shangcheng_dingdan::class.java);
            startActivity(intent);
        }

        val txhydh=rootView.findViewById<LinearLayout>(R.id.txhydh)
        txhydh.setOnClickListener {
            showConfirmDialog("腾讯会员",1000)
        }
        val bdwpdh=rootView.findViewById<LinearLayout>(R.id.bdwpdh)
        bdwpdh.setOnClickListener {
            showConfirmDialog("百度网盘",1200)
        }
        val lzhydh=rootView.findViewById<LinearLayout>(R.id.lzhydh)
        lzhydh.setOnClickListener {
            showConfirmDialog("绿钻会员",800)
        }
        val xlxdh=rootView.findViewById<LinearLayout>(R.id.xlxdh)
        xlxdh.setOnClickListener {
            showConfirmDialog("行李箱",10000)
        }
        tv_coin_over = rootView.findViewById(R.id.tv_coin_over)
        tv_coin_over.setText("1000")
        return rootView
    }
    private fun showConfirmDialog(name: String, value: Int) {

        SelectDialog.show(context, "提示", String.format("请确认是否花费 %d 星币兑换 %s ", value, name),
                "确定", { dialog, which -> Toast.makeText(context, "您点击了确定按钮", Toast.LENGTH_SHORT).show() },
                "算了" ,{ dialog, which -> Toast.makeText(context, "您点击了取消按钮", Toast.LENGTH_SHORT).show() })
    }

}