package com.alisdnn.userpanel.data.mapper

import com.alisdnn.userpanel.data.db.dao.UserData
import com.alisdnn.userpanel.domain.user.entity.User

fun User.map() = UserData(
    id = id,
    username = username,
    email = email,
    isAdmin = isAdmin,
    passwordHash = passwordHash
)