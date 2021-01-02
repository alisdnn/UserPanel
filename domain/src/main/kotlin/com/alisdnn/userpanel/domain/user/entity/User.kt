package com.alisdnn.userpanel.domain.user.entity


data class User(
    val id: Int = 0,
    val username: String,
    val fullname: String,
    val isAdmin: Boolean = false,
    val password: String
)