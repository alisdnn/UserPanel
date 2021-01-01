package com.alisdnn.userpanel.data.db.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alisdnn.userpanel.data.db.Constants.USER_DATABASE_NAME

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = USER_DATABASE_NAME
    }
}