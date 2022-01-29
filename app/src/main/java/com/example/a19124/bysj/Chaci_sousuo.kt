package com.example.a19124.bysj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.a19124.bysj.Utils.DBConnection

class Chaci_sousuo : AppCompatActivity() {
    public val EXTRA_MESSAGE:String="message";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chaci_sousuo)
        var chaci_sousuo=findViewById<TextView>(R.id.chaci_sousuo)
        chaci_sousuo.setOnClickListener{
            Class.forName("com.mysql.jdbc.Driver")
            //建立连接
            val messageView : EditText = findViewById(R.id.message);
            val messageText:String=messageView.getText().toString();
            val intent: Intent = Intent(this,Sousuo_xianshi::class.java);
            val msg = DBConnection.findWord(messageText)
            if(msg!=null) {
                intent.putExtra(EXTRA_MESSAGE, msg);
                startActivity(intent);
                //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"没有找到此单词",Toast.LENGTH_SHORT).show()
        }

        val message=findViewById<EditText>(R.id.message)
        message.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEND || event != null && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                //do something;
                Class.forName("com.mysql.jdbc.Driver")
                //建立连接
                val messageView : EditText = findViewById(R.id.message);
                var messageText:String=messageView.getText().toString();
                messageText+=' '
                val intent: Intent = Intent(this,Sousuo_xianshi::class.java);
                val msg = DBConnection.findWord(messageText)
                if(msg!=null) {
                    intent.putExtra(EXTRA_MESSAGE, msg);

                    startActivity(intent);
                }
                else
                    Toast.makeText(this,"没有找到此单词",Toast.LENGTH_SHORT).show()
                true
            } else false
        })

    }
    public fun fanhui(view: View){

        finish()
    }
    public fun qingchu(view: View){
        AlertDialog.Builder(this).apply {
            setTitle("确认删除吗")
            setMessage("something important.")
            setCancelable(false)
            setPositiveButton("ok"){
                dialog, which ->
            }
            setNegativeButton("cancel"){
                dialog, which ->
            }
            show()
        }
    }
}