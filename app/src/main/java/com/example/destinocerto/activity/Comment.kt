package com.example.destinocerto.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.destinocerto.R
import com.example.destinocerto.model.User
import com.example.destinocerto.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_comment.*

class Comment : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
            val comment = intent.getStringExtra("cmt")

            mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        save_comment.setOnClickListener {

            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val nickName = et_nickName.text.toString()
        val comment = et_addComment.text.toString()

        if(inputCheck(nickName, comment)) {
            // Create User Object
            val user = User( 0, nickName, comment)
            // Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Comentário adicionado!", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(this, "Por favor preencha todos os campos.", Toast.LENGTH_LONG).show()
        }
    }

        private fun inputCheck(nickName: String, comment: String): Boolean {
            return !(TextUtils.isEmpty(nickName) && TextUtils.isEmpty(comment))
        }
    }