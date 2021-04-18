package com.example.myapplication

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.a19124.bysj.*

class Navigation_fuxi_Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val rootView: View = inflater.inflate(R.layout.navigation_fuxi_fragment,container,false)

        val button_fuxi_xunlian=rootView.findViewById<Button>(R.id.button_fuxi_xunlian)
        button_fuxi_xunlian.setOnClickListener {
            val intent: Intent = Intent(activity, Fuxi_xunlian::class.java);
            startActivity(intent);
        }
        val linear_fuxi_chaci=rootView.findViewById<LinearLayout>(R.id.linear_fuxi_chaci)
        linear_fuxi_chaci.setOnClickListener {
            val intent: Intent = Intent(activity, Chaci_sousuo::class.java);
            startActivity(intent);
        }
        val linear_faxian_aiyuedu=rootView.findViewById<LinearLayout>(R.id.linear_faxian_aiyuedu)
        linear_faxian_aiyuedu.setOnClickListener {
            val intent: Intent = Intent(activity, Faxian_read::class.java);
            startActivity(intent);
        }
        val textview_fuxi_ciku=rootView.findViewById<TextView>(R.id.textview_fuxi_ciku)
        val textview_fuxi_wordnum=rootView.findViewById<TextView>(R.id.textview_fuxi_wordnum)
        val button_plan_change=rootView.findViewById<Button>(R.id.button_plan_change)
        button_plan_change.setOnClickListener {
            val biaoji:Plan_setbj?=null

            val bj:Int?= biaoji?.getbj()  ;
            when(bj){
                3->{
                    textview_fuxi_ciku.setText("高考词汇")
                    textview_fuxi_wordnum.setText("3877")
                }
                4->{
                    textview_fuxi_ciku.setText("四级词汇")
                    textview_fuxi_wordnum.setText("4449")
                }
                6->{
                    textview_fuxi_ciku.setText("六级词汇")
                    textview_fuxi_wordnum.setText("5556")
                }
                7->{
                    textview_fuxi_ciku.setText("考研词汇")
                    textview_fuxi_wordnum.setText("5507")
                }
            }
            val intent: Intent = Intent(activity, com.example.a19124.bysj.Plan_switch::class.java);
            startActivity(intent);

        }

//        val textview_xianshi_liju2=findViewById<TextView>(R.id.textview_xianshi_jinyici)
//        textview_xianshi_liju2.setText(wordBean.uid.toString())
        return rootView
    }

}