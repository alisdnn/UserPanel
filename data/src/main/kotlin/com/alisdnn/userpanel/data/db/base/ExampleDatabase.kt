package com.alisdnn.userpanel.data.db.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alisdnn.userpanel.data.db.ExampleEntity

@Database(
    entities = [ExampleEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ExampleDatabase: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: ExampleDatabase? = null

        fun getInstance(context: Context): ExampleDatabase =
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                        ?: buildDatabase(
                            context
                        ).also {
                            INSTANCE = it
                        }
                }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ExampleDatabase::class.java, "Example.db")
                .build()
    }
}