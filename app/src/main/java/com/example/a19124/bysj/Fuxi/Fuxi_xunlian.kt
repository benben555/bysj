package com.example.a19124.bysj.Fuxi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.a19124.bysj.R

class Fuxi_xunlian : AppCompatActivity() {
    public val EXTRA_recite:String="recite";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fuxi_xunlian)


        var linear_fuxi_xunlian=findViewById<LinearLayout>(R.id.linear_fuxi_xunlian)
        linear_fuxi_xunlian.setOnClickListener{
            Class.forName("com.mysql.jdbc.Driver")
            val intent: Intent = Intent(this, Fuxi_xunlian_beidanci::class.java);
     //       val msg = DBConnection.getWord("gaokao");
    //        intent.putExtra(EXTRA_recite,msg);
            startActivity(intent);
        }

//        val message=findViewById<EditText>(R.id.message)
//        message.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_SEND || event != null && event.keyCode == KeyEvent.KEYCODE_ENTER) {
//                //do something;
//                Class.forName("com.mysql.jdbc.Driver")
//                //建立连接
//                val messageView : EditText = findViewById(R.id.message);
//                val messageText:String=messageView.getText().toString();
//                val intent: Intent = Intent(this,Sousuo_xianshi::class.java);
//                val msg = DBConnection.findWord(messageText)
//                intent.putExtra(EXTRA_recite,msg);
//
//                startActivity(intent);
//
//                true
//            } else false
//        })

   // }
































    }
    public fun fanhui(view: View){
        finish()
    }
//    public fun beidanci(view: View){
//        val intent: Intent = Intent(this, Fuxi_xunlian_beidanci::class.java);
//        startActivity(intent);
//    }




}