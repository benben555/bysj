package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.a19124.bysj.*
import com.example.a19124.bysj.Bean.UserInfo
import com.example.a19124.bysj.Utils.SecurityLoginUtils

class Navigation_User_Fragment : Fragment() {

    var context: String? = null
    var mTextView: TextView? = null
    var name: String? = "注册/登录"
    var rootView: View? = null
    var user:UserInfo = UserInfo.getInstance()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.navigation_user_fragment, container, false)
        val register=rootView?.findViewById<Button>(R.id.button_user_register)
        if (!SecurityLoginUtils.getInstance(getContext()).loginStatus) {
            register?.setText("注册/登录")
        } else {
            register?.setText("登出")
        }
        register?.setOnClickListener {
            if (name == "注册/登录") {
                SecurityLoginUtils.getInstance(getContext()).logout()
                val intent = Intent(activity, UserLoginMain::class.java)
                startActivityForResult(intent, 1)
            } else {
                val intent = Intent(activity, UserReplaceMessage::class.java)
                intent.putExtra("name", name)
                startActivityForResult(intent, 2)
            }

        }
        val tv_user_coin_over = rootView?.findViewById<TextView>(R.id.tv_coin_over_user)
        tv_user_coin_over?.setText(""+user.coinOver)
        val tv_cihuiliang_user = rootView?.findViewById<TextView>(R.id.tv_cihuiliang_user)
        tv_cihuiliang_user?.setText(""+user.cihuiliang)
        val button_user_exit=rootView?.findViewById<Button>(R.id.button_user_exit)
        button_user_exit?.setOnClickListener {
           activity?.finish()
        }
        val button_user_yonghuxieyi=rootView?.findViewById<Button>(R.id.button_user_yonghuxieyi)
        button_user_yonghuxieyi?.setOnClickListener {
            val intent: Intent = Intent(activity, User_xieyi::class.java);
            startActivity(intent);
        }
        val button_user_zhenti=rootView?.findViewById<Button>(R.id.button_user_zhenti)
        button_user_zhenti?.setOnClickListener {
            val intent: Intent = Intent(activity, User_zhenti::class.java);
            startActivity(intent);
        }
        val button_user_plan=rootView?.findViewById<Button>(R.id.button_user_plan)
        button_user_plan?.setOnClickListener {
            val intent: Intent = Intent(activity, User_plan::class.java);
            startActivity(intent);
        }
        val button_user_help=rootView?.findViewById<Button>(R.id.button_user_help)
        button_user_help?.setOnClickListener {
            val intent: Intent = Intent(activity, User_help::class.java);
            startActivity(intent);
        }
        val button_user_shoucang=rootView?.findViewById<Button>(R.id.button_user_shoucang)
        button_user_shoucang?.setOnClickListener {
            val intent: Intent = Intent(activity, User_shoucang::class.java);
            startActivity(intent);
        }
        val button_user_task=rootView?.findViewById<Button>(R.id.button_user_task)
        button_user_task?.setOnClickListener {
            val intent: Intent = Intent(activity, User_task::class.java);
            startActivity(intent);
        }
        val button_user_guanyu=rootView?.findViewById<Button>(R.id.button_user_guanyu)
        button_user_guanyu?.setOnClickListener {
            val intent: Intent = Intent(activity, User_guanyu::class.java);
            startActivity(intent);
        }
//        val button_user_more=rootView?.findViewById<Button>(R.id.button_user_more)
//        button_user_more?.setOnClickListener {
//            val intent: Intent = Intent(activity, User_more::class.java);
//            startActivity(intent);
//        }



        val button_user_fenxiang=rootView?.findViewById<Button>(R.id.button_user_fenxiang)
        button_user_fenxiang?.setOnClickListener {
//            val intent: Intent = Intent(activity, User_help::class.java);
//            startActivity(intent);
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
// 比如发送文本形式的数据内容
// 指定发送的内容
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
// 指定发送内容的类型
            sendIntent.setType("text/plain");
// 比如发送二进制文件数据流内容（比如图片、视频、音频文件等等）
// 指定发送的内容 (EXTRA_STREAM 对于文件 Uri )
            val shareIntent=Intent()
           //shareIntent.putExtra(Intent.EXTRA_STREAM, @);
// 指定发送内容的类型 (MIME type)
            shareIntent.setType("image/jpeg");
            startActivity(Intent.createChooser(shareIntent, "Share to..."));




        }



        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                //返回的主码
                name = data?.getStringExtra("name")
                val register =
                        rootView?.findViewById<TextView>(R.id.button_user_register)
                register?.setText(name)
            }
            2 -> if (resultCode == Activity.RESULT_OK) {
                if (data?.getStringExtra("name") == "error") {
                    name = "注册/登录"
                    val register =
                            rootView?.findViewById<TextView>(R.id.button_user_register)
                    register?.setText(name)
                }
            }

        }
    }

}