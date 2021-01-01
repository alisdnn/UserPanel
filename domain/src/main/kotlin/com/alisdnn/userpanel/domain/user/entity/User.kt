package com.alisdnn.userpanel.domain.user.entity

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val isAdmin: Boolean,
    val passwordHash: String
)