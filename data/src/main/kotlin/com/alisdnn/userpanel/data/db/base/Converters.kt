package com.alisdnn.userpanel.data.db.base

import androidx.room.TypeConverter
import java.util.*


class Converters {

    @TypeConverter
    fun fromExample(value: Long?): Date? {
        return value?.let { Date(it) }
    }

}