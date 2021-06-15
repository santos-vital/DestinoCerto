package com.example.destinocerto.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.destinocerto.model.Coin
import com.example.destinocerto.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_price.*

class ActivityPrice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price)

        val type = intent.getStringExtra("type")

        if (type == "0") {// Aqui criei um if para especificar a chamada da API em cada posição do array

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

            val videoView = findViewById<VideoView>(R.id.videoView)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            val onlineUri = Uri.parse("https://r3---sn-bg0ezn7s.googlevideo.com/videoplayback?expire=1623815261&ei=_R_JYJvLDaq61Ab10oigDg&ip=46.70.199.1&id=o-AItYl1aa9mW-bTiG3IA5wL4cDj-r4Zl_NkGuU6g4t2bS&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=sSra67a1McxzBRcqTDXhlGQF&gir=yes&clen=38003704&ratebypass=yes&dur=433.121&lmt=1555099975836763&fexp=24001373,24007246&c=WEB&txp=5431432&n=bFxp5W-kSBh1aP&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgMnte2QPhWxI4b1owhdUyL7lY3t594K1QEMEfLvRA1E8CIQC2eo6qCBHnpxjWTSZDhSC-2qUpXUoVkn406OJJwjf6Tw%3D%3D&rm=sn-cxxapox-x8oz7s&req_id=cd96af05281ba3ee&redirect_counter=2&cm2rm=sn-nv4ss7s&cms_redirect=yes&mh=oG&mip=143.208.72.9&mm=34&mn=sn-bg0ezn7s&ms=ltu&mt=1623793479&mv=m&mvi=3&pl=23&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAJ7ZJ6mdRuwAsO9vQktpZDCBT4kD765Rqbm-zyKnfNGDAiAtxoTDEWp2o5pEpF46iezaaAh2q8t9w04UADC-G_FYrA%3D%3D")
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(onlineUri)
            videoView.start()
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

            val videoView = findViewById<VideoView>(R.id.videoView)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            val onlineUri = Uri.parse("https://r3---sn-bg0ezn7s.googlevideo.com/videoplayback?expire=1623815261&ei=_R_JYJvLDaq61Ab10oigDg&ip=46.70.199.1&id=o-AItYl1aa9mW-bTiG3IA5wL4cDj-r4Zl_NkGuU6g4t2bS&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=sSra67a1McxzBRcqTDXhlGQF&gir=yes&clen=38003704&ratebypass=yes&dur=433.121&lmt=1555099975836763&fexp=24001373,24007246&c=WEB&txp=5431432&n=bFxp5W-kSBh1aP&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgMnte2QPhWxI4b1owhdUyL7lY3t594K1QEMEfLvRA1E8CIQC2eo6qCBHnpxjWTSZDhSC-2qUpXUoVkn406OJJwjf6Tw%3D%3D&rm=sn-cxxapox-x8oz7s&req_id=cd96af05281ba3ee&redirect_counter=2&cm2rm=sn-nv4ss7s&cms_redirect=yes&mh=oG&mip=143.208.72.9&mm=34&mn=sn-bg0ezn7s&ms=ltu&mt=1623793479&mv=m&mvi=3&pl=23&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAJ7ZJ6mdRuwAsO9vQktpZDCBT4kD765Rqbm-zyKnfNGDAiAtxoTDEWp2o5pEpF46iezaaAh2q8t9w04UADC-G_FYrA%3D%3D")
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(onlineUri)
            videoView.start()
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
        if (type == "4") {

            val queue = Volley.newRequestQueue(this)

            val url = "https://economia.awesomeapi.com.br/json/GBP-BRL"

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

