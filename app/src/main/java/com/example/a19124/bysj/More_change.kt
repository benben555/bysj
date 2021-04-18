package com.example.a19124.bysj
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.Button


class More_change : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_change)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, More_change.PlaceholderFragment()).commit()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {
        private var btnTheme: Button? = null
        private var btnAPK: Button? = null
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_main, container,
                    false)
            btnTheme = rootView.findViewById<View>(R.id.btn_theme) as Button
            btnAPK = rootView.findViewById<View>(R.id.btn_theme_apk) as Button
            btnTheme!!.setOnClickListener {
                val it = Intent()
                it.setClass(activity, ThemeActivity::class.java)
                startActivity(it)
            }
            btnAPK!!.setOnClickListener {
                val it = Intent()
                it.setClass(activity, ThemeApkActivity::class.java)
                startActivity(it)
            }
            return rootView
        }
    }

    fun fanhui(view: View){
        finish()
    }
}
