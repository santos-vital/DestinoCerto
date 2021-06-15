package com.example.destinocerto.repository

import androidx.lifecycle.LiveData
import com.example.destinocerto.data.UserDao
import com.example.destinocerto.model.User

class UserRepository(private val userDao: UserDao) {

    // A classe repository serve para separar algumas responsabilidades no projeto

    val readAllData: LiveData<List<User>> = userDao.readAllData() // responsável por receber os usuários do banco e listar todos

    suspend fun  addUser(user: User) {
        userDao.addUser(user)
    }
}