package com.example.a19124.bysj

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException


class UserReplaceMessage : AppCompatActivity(), View.OnClickListener {
    var name:String?=null
    private val INTENT_TYPE = "image/*"
    private val REQUESTCODE = 100
    private var imageView: ImageView? = null
    private val button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_replace_message)
        //接收主码
        name=intent.getStringExtra("name")
        //数据库：查，输出

        val button_user_quit=findViewById<Button>(R.id.button_user_quit)
        button_user_quit.setOnClickListener{
            intent.putExtra("name","error")
            setResult(Activity.RESULT_OK,intent)
            finish()

        }
        val imageView_replace_message_fanhui=findViewById<ImageView>(R.id.imageView_replace_message_fanhui)
        imageView_replace_message_fanhui.setOnClickListener {
            finish()
        }
        val replace_message_huantouxiang=findViewById<TextView>(R.id.replace_message_huantouxiang)
        replace_message_huantouxiang.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = INTENT_TYPE
            startActivityForResult(intent, REQUESTCODE)
            //Toast.makeText(this,"你点击了$", Toast.LENGTH_SHORT).show()
            val replace_message_huantouxiang = findViewById<TextView>(R.id.replace_message_huantouxiang);
            replace_message_huantouxiang.setOnClickListener(this);
            imageView = findViewById<ImageView>(R.id.imageview_change);
        }

        val textview_user_replace_name=findViewById<TextView>(R.id.textview_user_replace_name)
        textview_user_replace_name.setOnClickListener {
            //Toast.makeText(this,"你点击了$", Toast.LENGTH_SHORT).show()
        }
        val textview_user_replace_sex=findViewById<TextView>(R.id.textview_user_replace_sex)
        textview_user_replace_sex.setOnClickListener {
            //Toast.makeText(this,"你点击了$", Toast.LENGTH_SHORT).show()
        }
        val textview_user_replace_password=findViewById<TextView>(R.id.textview_user_replace_password)
        textview_user_replace_password.setOnClickListener {
            val intent=Intent(this,UserReplacePassword::class.java)
            //传送主码
            intent.putExtra("name",name)
            startActivity(intent)
        }


    }

    @Override
    public override fun onClick(v:View) {
        //使用intent调用系统提供的相册功能，
        //使用startActivityForResult是为了获取用户选择的图片
         val intent:Intent =Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(INTENT_TYPE);
        startActivityForResult(intent,REQUESTCODE);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            Log.e("TAG--->onresult", "ActivityResult resultCode error")
            return
        }

        //获得图片
        var bitmap: Bitmap? = null
        val resolver = contentResolver
        if (requestCode == REQUESTCODE) {
            val uri: Uri = data.data
            try {
                bitmap = MediaStore.Images.Media.getBitmap(resolver, uri) //获得图片
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        imageView!!.setImageBitmap(bitmap)


        //获得路径
        if (requestCode == REQUESTCODE) {
            var uri: Uri? = data.data
            uri = geturi(data) //解决方案
            val pro = arrayOf(MediaStore.Images.Media.DATA)
            //好像是android多媒体数据库的封装接口，具体的看Android文档
            val cursor: Cursor = managedQuery(uri, pro, null, null, null)
            val cursor1: Cursor = contentResolver.query(uri, pro, null, null, null)
            //拿到引索
            val index: Int = cursor1.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            //移动到光标开头
            cursor.moveToFirst()
            //最后根据索引值获取图片路径
            val path: String = cursor.getString(index)
            Log.d("Tag--->path", path)
        }
    }

    /**
     * 解决小米手机上获取图片路径为null的情况
     * @param intent
     * @return
     */
    fun geturi(intent: Intent): Uri? {
        var uri: Uri = intent.data
        val type = intent.type
        if (uri.getScheme().equals("file") && type.contains("image/")) {
            var path: String = uri.getEncodedPath()
            if (path != null) {
                path = Uri.decode(path)
                val cr = this.contentResolver
                val buff = StringBuffer()
                buff.append("(").append(MediaStore.Images.ImageColumns.DATA).append("=")
                        .append("'$path'").append(")")
                val cur: Cursor = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.Images.ImageColumns._ID),
                        buff.toString(), null, null)
                var index = 0
                cur.moveToFirst()
                while (!cur.isAfterLast()) {
                    index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID)
                    // set _id value
                    index = cur.getInt(index)
                    cur.moveToNext()
                }
                if (index == 0) {
                    // do nothing
                } else {
                    val uri_temp: Uri = Uri
                            .parse("content://media/external/images/media/"
                                    + index)
                    if (uri_temp != null) {
                        uri = uri_temp
                    }
                }
            }
        }
        return uri
    }


}