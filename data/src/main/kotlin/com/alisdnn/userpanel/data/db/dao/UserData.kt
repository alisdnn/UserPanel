package com.alisdnn.userpanel.data.db.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alisdnn.userpanel.data.base.ResponseObject
import com.alisdnn.userpanel.domain.user.entity.User

@Entity(tableName = "user")
data class UserData(

    @ColumnInfo(name = "userId")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "fullname")
    val fullname: String,

    @ColumnInfo(name = "isAdmin")
    val isAdmin: Boolean,

    @ColumnInfo(name = "password")
    val password: String

) : ResponseObject<User> {
    override fun toDomain(): User =
        User(
            id = id,
            username = username,
            fullname = fullname,
            isAdmin = isAdmin,
            password = password
        )

}