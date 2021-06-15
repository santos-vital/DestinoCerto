package com.example.destinocerto.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.destinocerto.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}