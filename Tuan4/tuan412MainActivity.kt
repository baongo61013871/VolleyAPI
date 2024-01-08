package com.example.myapplication.Tuan4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R
import org.w3c.dom.Text

class tuan412MainActivity : AppCompatActivity() {
    var btn: Button? = null
    var tvKQ: TextView? = null
    var context: Context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan412_main)
        btn = findViewById(R.id.tuan412btn1)
        tvKQ= findViewById(R.id.tuan412tv1)

        val fn = VolleyKotlinFn()

        btn!!.setOnClickListener {
            fn.getJSONArrayObjects(context,tvKQ!!)
        }
    }
}