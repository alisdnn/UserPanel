package com.alisdnn.userpanel.domain.user.repository

import com.alisdnn.userpanel.domain.user.entity.User
import io.reactivex.Single

interface UserRepository {

    fun getUser(username: String): Single<User>

    fun insertUser(user: User): Single<Long>

}