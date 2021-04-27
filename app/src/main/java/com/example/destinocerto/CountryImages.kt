package com.example.destinocerto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_country_images.*

class CountryImages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_images)

        val  actionBar : ActionBar? = supportActionBar

        actionBar!!.setDisplayHomeAsUpEnabled(true)

        actionBar.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val aTitle = intent.getStringExtra("iName")
        val aDescription = intent.getStringExtra("iDescription")
        val aImageView = intent.getIntExtra("iImageView", 0)

        actionBar.setTitle(aTitle)
        nameCountryTv.text = aTitle
        descCountryTv.text = aDescription
        imageCountryIv.setImageResource(aImageView)

        if (aTitle.equals("Alemanha")) {
            val button: Button = findViewById(R.id.btnPrice)
            button.setOnClickListener {
                val intentCoin = Intent(this, ActivityPrice::class.java)
                intentCoin.putExtra("type", "0")
                startActivity(intentCoin)
            }
        }
        if (aTitle.equals("Estados Unidos")) {
            val button: Button = findViewById(R.id.btnPrice)
            button.setOnClickListener {
                val intentCoin = Intent(this, ActivityPrice::class.java)
                intentCoin.putExtra("type", "1")
                startActivity(intentCoin)
            }
        }
        if (aTitle.equals("China")) {
            val button: Button = findViewById(R.id.btnPrice)
            button.setOnClickListener {
                val intentCoin = Intent(this, ActivityPrice::class.java)
                intentCoin.putExtra("type", "2")
                startActivity(intentCoin)
            }
        }
        if (aTitle.equals("França")) {
            val button: Button = findViewById(R.id.btnPrice)
            button.setOnClickListener {
                val intentCoin = Intent(this, ActivityPrice::class.java)
                intentCoin.putExtra("type", "3")
                startActivity(intentCoin)
            }
        }
    }
}