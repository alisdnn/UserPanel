package com.alisdnn.userpanel.data.db.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alisdnn.userpanel.data.base.ResponseObject
import com.alisdnn.userpanel.domain.user.entity.User

@Entity(tableName = "user")
data class UserEntity(

    @ColumnInfo(name = "userId")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "isAdmin")
    val isAdmin: Boolean,

    @ColumnInfo(name = "passwordHash")
    val passwordHash: String

) : ResponseObject<User> {
    override fun toDomain(): User =
        User(
            id = id,
            username = username,
            email = email,
            isAdmin = isAdmin,
            passwordHash = passwordHash
        )

}