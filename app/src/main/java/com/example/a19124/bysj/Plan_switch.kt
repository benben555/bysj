package com.example.a19124.bysj

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class Plan_switch : AppCompatActivity() {
 //   public var bj="liuji"
 companion object {
     @JvmStatic
     val biaoji: Plan_setbj? = null;
 }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plan_switch)

        switchbj(biaoji?.getbj())
        val linear_plan_gaokao1=findViewById<LinearLayout>(R.id.linear_plan_gaokao)
        linear_plan_gaokao1.setOnClickListener {
            biaoji?.setbj(3);
            clearbj()
            switchbj(3)
        }
        val linear_plan_kaoyan1=findViewById<LinearLayout>(R.id.linear_plan_kaoyan)
        linear_plan_kaoyan1.setOnClickListener {
            biaoji?.setbj(7);
            clearbj()
            switchbj(7)
        }
        val linear_plan_liuji1=findViewById<LinearLayout>(R.id.linear_plan_liuji)
        linear_plan_liuji1.setOnClickListener {
            biaoji?.setbj(6);
            clearbj()
            switchbj(6)
        }
        val linear_plan_siji1=findViewById<LinearLayout>(R.id.linear_plan_siji)
        linear_plan_siji1.setOnClickListener {
            biaoji?.setbj(4);
            clearbj()
            switchbj(4)
        }
    }

    public fun fanhui(view:View) {
        finish()
    }

    public fun clearbj(){
        val textview_plan_gaokao=findViewById<TextView>(R.id.textview_plan_gaokao)
        textview_plan_gaokao.setText("")
        val textview_plan_siji=findViewById<TextView>(R.id.textview_plan_siji)
        textview_plan_siji.setText("")
        val textview_plan_liuji=findViewById<TextView>(R.id.textview_plan_liuji)
        textview_plan_liuji.setText("")
        val textview_plan_kaoyan=findViewById<TextView>(R.id.textview_plan_kaoyan)
        textview_plan_kaoyan.setText("")
    }
    public fun switchbj(bj:Int?){
        when(bj){
            3->{
                val textview_plan_gaokao=findViewById<TextView>(R.id.textview_plan_gaokao)
                textview_plan_gaokao.setText("当前在学")
            }
            4->{
                val textview_plan_siji=findViewById<TextView>(R.id.textview_plan_siji)
                textview_plan_siji.setText("当前在学")
            }
            6->{
                val textview_plan_liuji=findViewById<TextView>(R.id.textview_plan_liuji)
                textview_plan_liuji.setText("当前在学")
            }
            7->{
                val textview_plan_kaoyan=findViewById<TextView>(R.id.textview_plan_kaoyan)
                textview_plan_kaoyan.setText("当前在学")
            }
        }
    }
}