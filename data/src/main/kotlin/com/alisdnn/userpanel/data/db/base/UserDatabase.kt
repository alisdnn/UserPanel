package com.alisdnn.userpanel.data.db.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alisdnn.userpanel.data.db.Constants.USER_DATABASE_NAME
import com.alisdnn.userpanel.data.db.dao.UserDao
import com.alisdnn.userpanel.data.db.dao.UserData

@Database(
    entities = [UserData::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = USER_DATABASE_NAME
    }
}