package com.example.a19124.bysj

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

//class More_daka : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.more_daka)
//    }
//}


/**
 * 本月日历
 *
 * @author aiyang
 */
class More_daka : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var registration_calendar_gv: GridView? = null
    private var today: TextView? = null
    private var adapter: RegistrationAdapter? = null
    private val sdf = SimpleDateFormat("yyyy-M-d")
    var mYear = 0 //年
    var mMonth = 0 //月
    var mDay = 0 //日
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_daka)
        registration_calendar_gv = findViewById<GridView>(R.id.registration_calendar_gv)
        today = findViewById<TextView>(R.id.today)
        val calendar = Calendar.getInstance()
        mYear = calendar[Calendar.YEAR] // 获取当前年份
        mMonth = calendar[Calendar.MONTH] // 获取当前月份以（0开头）
        mDay = calendar[Calendar.DAY_OF_MONTH] // 获取当前天以（0开头）
        val mCalendar = SpecialCalendar()
        val isLeapYear = mCalendar.isLeapYear(mYear)
        val mDays = mCalendar.getDaysOfMonth(isLeapYear, mMonth + 1)
        val week = mCalendar.getWeekdayOfMonth(mYear, mMonth)
        adapter = RegistrationAdapter(this, mDays, week, mDay)
        registration_calendar_gv!!.adapter = adapter
        registration_calendar_gv!!.onItemClickListener = this
        today!!.text = mYear.toString() + "年" + mMonth + "月" + mDay + "日"

    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        val today = "$mYear-$mMonth-$l"
        if (l != 0L) {
            if (l == mDay.toLong()) {
                val today_tv = view.findViewById<TextView>(R.id.day)
                today_tv.setBackgroundResource(R.mipmap.member_ok)
                today_tv.setTextColor(Color.BLACK)
                today_tv.text = l.toString() + ""
                view.setBackgroundColor(Color.parseColor("#ffffff"))
                Toast.makeText(view.context, "签到成功", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "您选择的日期：$today", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun fanhui(view: View){
        finish()
    }
}
