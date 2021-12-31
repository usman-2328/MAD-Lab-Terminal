package com.example.asynctask

import android.app.Dialog
import android.app.ProgressDialog
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.AuthFailureError

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val qeue =Volley.newRequestQueue(this)

        val params = HashMap<String,String>()
        params[edi1.text.toString()]=edi2.text.toString()

        val jsonObject = JSONObject(params as Map<*, *>)



        btnpost.setOnClickListener{
            val url = "https://run.mocky.io/v3/2cf15d61-982f-4843-9607-7947e1904668"
            val jas = JsonObjectRequest(
                com.android.volley.Request.Method.POST,url,jsonObject,
                Response.Listener{
                    response ->
                    txtv.text=" Response $response"
                    Toast.makeText(this,"Data Post succesfully",Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener {
                    error ->
                    txtv.text=" Response $error"
                    Toast.makeText(this,"Error in data $error",Toast.LENGTH_SHORT).show()
                }

            )


            qeue.add(jas)
        }
    }
}