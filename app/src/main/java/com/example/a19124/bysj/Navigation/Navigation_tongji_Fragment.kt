package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import com.example.a19124.bysj.*
import kotlinx.android.synthetic.main.navigation_tongji_fragment.*
import java.util.*

class Navigation_tongji_Fragment : Fragment() {

    var chartViews: chartview?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val rootView: View = inflater.inflate(R.layout.navigation_tongji_fragment,container,false)
        val switch_dash=rootView.findViewById<Switch>(R.id.switch_dash)
        switch_dash.setOnCheckedChangeListener { _, isChecked ->
            chartViews?.isShowDash = isChecked
        }
        val switch_type=rootView.findViewById<Switch>(R.id.switch_type)
        switch_type.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                chartViews?.lineType = BROKENLINE
            } else {
                chartViews?.lineType = CURVELINE
            }
        }
        val switch_cover=rootView.findViewById<Switch>(R.id.switch_cover)
        switch_cover.setOnCheckedChangeListener { _, isChecked ->
            chartViews?.fillArea = isChecked
        }

        val random = Random()
        val pointList = ArrayList<Int>()
        for (i in 0..30) {
            val nextInt = random.nextInt(30)
            pointList.add(nextInt)
        }
        chartViews?.dashColor = Color.GREEN
        chartViews?.maxY=35
        chartViews?.setChartPoints(pointList)
        return rootView
    }
}