package com.example.myapplication.Tuan4

import android.content.Context
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyKotlinFn {
    var strJSON = ""
    fun getJSONArrayObjects (context: Context, textView: TextView) {
        //1 Tao request
        val queue = Volley.newRequestQueue(context)
        //2. URL
        val url = "http://192.168.0.118:8080/ajson/a.json"
        //3 goi request
        val request = JsonArrayRequest (url,
            Response.Listener { response ->
                for (i in 0 until response.length())
                {
                    // lay cac doi tuong
                    val person = response.getJSONObject(i)
                    val id = person.getString("id")
                    val name =person.getString("name")
                    val email = person.getString("email")
                    strJSON += "Customer " + (i+1) + ":\n"
                    strJSON += "id: $id \n"
                    strJSON += "name: $name \n"
                    strJSON += "email: $email \n"
                }
                textView.text = strJSON
            },
            Response.ErrorListener {
                error ->textView.text =error.message
            })
        //4 Thuc thi request
        queue.add(request)
    }
}