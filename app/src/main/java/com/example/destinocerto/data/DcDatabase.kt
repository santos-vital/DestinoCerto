package com.example.destinocerto.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.destinocerto.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DcDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: DcDatabase? = null

        fun getDatabase(context: Context): DcDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DcDatabase::class.java,
                    "dc_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}