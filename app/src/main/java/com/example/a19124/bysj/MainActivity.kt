package com.example.a19124.bysj

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.myapplication.*


class MainActivity : AppCompatActivity() {
//    var conn: Connection ?=null
//    var str:String?="error"
//    var stmt:Statement?=null
//    var rs:ResultSet?=null
//    var sql:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    setTheme(R.style.AppTheme)
    setContentView(R.layout.activity_main)
    
    val intent: Intent = Intent(this, OpenActivity::class.java);
    startActivity(intent);
        setContentView(R.layout.activity_main)
        replaceFragment(Navigation_fuxi_Fragment())
//        Log.d("stmt_messages","conn_first")
//        val button_fuxi=findViewById<Button>(R.id.button_fuxi)
//        button_fuxi.setOnClickListener {
//            replaceFragment(Navigation_fuxi_Fragment())
//            sql="SELECT word FROM liuji WHERE number=2"
//            stmt=conn!!.createStatement()
////            if(stmt!=null)
////                Log.d("stmt_message","first")
////            else
////                Log.d("stmt_message","error")
//            rs = stmt!!.executeQuery(sql)
//            str=rs!!.getString("word").toString()
//            val button_faxian=findViewById<Button>(R.id.button_faxian)
//            button_faxian.setText(str)
//            rs?.close()
//            stmt?.close()
//            conn?.close()
//        }
        val button_fuxi1:Button=findViewById<Button>(R.id.button_fuxi)
        button_fuxi1.setOnClickListener {
            replaceFragment(Navigation_fuxi_Fragment())
        }
        val button_faxian=findViewById<Button>(R.id.button_faxian)
        button_faxian.setOnClickListener {

            replaceFragment(Navigation_faxian_Fragment())
        }
        val button_tongji=findViewById<Button>(R.id.button_tongji)
        button_tongji.setOnClickListener {
            replaceFragment(Navigation_tongji_Fragment())
        }
        val button_shangcheng=findViewById<Button>(R.id.button_shangcheng)
        button_shangcheng.setOnClickListener {
          //  val intent: Intent = Intent(this, com.example.a19124.bysj.Navigation_Shangcheng_Fragment::class.java);
        //    startActivity(intent);
            replaceFragment(Navigation_Shangcheng_Fragment())
        }
        val button_button_shezhi=findViewById<Button>(R.id.button_shezhi)
        button_button_shezhi.setOnClickListener {
            replaceFragment(Navigation_User_Fragment())
        }
    }


    fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.navigation,fragment)
        transaction.commit()
    }

}
