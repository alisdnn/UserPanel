package com.alisdnn.userpanel.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ExampleEntity(
    @ColumnInfo(name = "jokeId")
    @PrimaryKey(autoGenerate = false)
    val id: Long
)