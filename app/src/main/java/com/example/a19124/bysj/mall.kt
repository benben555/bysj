package com.example.a19124.bysj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import kotlinx.android.synthetic.main.activity_mall.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
class mall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mall)
        ceshi1.setOnClickListener {
            Thread(Runnable {
                val sql = "SELECT * FROM liuji where number=2"
                mysqlConnection(sql)
            }).start()
        }

    }
    /**
     * 连接数据库
     */
    fun mysqlConnection(sql:String) {
        var cn: Connection
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver")
            //建立连接
//            cn = DriverManager.getConnection("jdbc:mysql://192.168.8.254:3306/bysj",
            cn = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/bysj",
                    "wyy", "root")
            val ps = cn.createStatement()
            val resultSet = ps!!.executeQuery(sql)
            while (resultSet.next()) {
                Log.d("mysqlConnection: " , resultSet.getString("word"))
                       // ceshi1.setText(resultSet.getString("word"))
            }


            if (ps != null&& !ps.isClosed()) {
                ps!!.close()
            }

            if (cn != null&& !cn.isClosed()) {
                cn.close()
            }
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        }

    }
}







