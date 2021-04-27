package com.example.destinocerto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_price.*

class ActivityPrice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price)

        val type = intent.getStringExtra("type")

        if (type == "0") {

            val queue = Volley.newRequestQueue(this)

            val url = "https://economia.awesomeapi.com.br/json/EUR-BRL"

            val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    { response ->
                        val gson = GsonBuilder().create()

                        val result = gson.fromJson(response.toString(), Array<Coin>::class.java).toList()
                        tvNameCoin.text = result.firstOrNull()?.name
                        tvBid.text = result.firstOrNull()?.bid.toString()
                    },
                    Response.ErrorListener { tvBid.text = "Error" })

            queue.add(stringRequest)
        }
        if (type == "1") {

            val queue = Volley.newRequestQueue(this)

            val url = "https://economia.awesomeapi.com.br/json/USD-BRL"

            val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    { response ->
                        val gson = GsonBuilder().create()

                        val result = gson.fromJson(response.toString(), Array<Coin>::class.java).toList()
                        tvNameCoin.text = result.firstOrNull()?.name
                        tvBid.text = result.firstOrNull()?.bid.toString()
                    },
                    Response.ErrorListener { tvBid.text = "Error" })

            queue.add(stringRequest)
        }
        if (type == "2") {

            val queue = Volley.newRequestQueue(this)

            val url = "https://economia.awesomeapi.com.br/json/CNY-BRL"

            val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    { response ->
                        val gson = GsonBuilder().create()

                        val result = gson.fromJson(response.toString(), Array<Coin>::class.java).toList()
                        tvNameCoin.text = result.firstOrNull()?.name
                        tvBid.text = result.firstOrNull()?.bid.toString()
                    },
                    Response.ErrorListener { tvBid.text = "Error" })

            queue.add(stringRequest)
        }
        if (type == "3") {

            val queue = Volley.newRequestQueue(this)

            val url = "https://economia.awesomeapi.com.br/json/EUR-BRL"

            val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    { response ->
                        val gson = GsonBuilder().create()

                        val result = gson.fromJson(response.toString(), Array<Coin>::class.java).toList()
                        tvNameCoin.text = result.firstOrNull()?.name
                        tvBid.text = result.firstOrNull()?.bid.toString()
                    },
                    Response.ErrorListener { tvBid.text = "Error" })

            queue.add(stringRequest)
        }
    }
}