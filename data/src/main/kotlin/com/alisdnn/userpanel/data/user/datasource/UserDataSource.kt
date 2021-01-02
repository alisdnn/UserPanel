package com.alisdnn.userpanel.data.user.datasource

import com.alisdnn.userpanel.domain.user.entity.User
import io.reactivex.Single

interface UserDataSource {

    fun selectUser(username:String): Single<User>

    fun insertUser(user: User):Single<Long>
}