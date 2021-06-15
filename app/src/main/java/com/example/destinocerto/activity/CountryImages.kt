package com.example.destinocerto.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.destinocerto.R
import com.example.destinocerto.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_country_images.*

class CountryImages : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_images)

        val actionBar : ActionBar? = supportActionBar

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
        if (aTitle.equals("Inglaterra")) {
            val button: Button = findViewById(R.id.btnPrice)
            button.setOnClickListener {
                val intentCoin = Intent(this, ActivityPrice::class.java)
                intentCoin.putExtra("type", "4")
                startActivity(intentCoin)
            }
        }

        val buttonComment: Button = findViewById(R.id.btnComment)
        buttonComment.setOnClickListener {
            val intentComment = Intent(this, Comment::class.java)
            startActivity(intentComment)
        }

        val adapter = ListAdapter()
        val recyclerView = recyclerComment
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe( this, Observer { user ->
            adapter.setData(user)
        })
    }
}