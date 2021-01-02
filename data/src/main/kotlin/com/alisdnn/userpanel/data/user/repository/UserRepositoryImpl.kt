package com.alisdnn.userpanel.data.user.repository

import com.alisdnn.userpanel.data.common.extension.applyIoScheduler
import com.alisdnn.userpanel.data.user.datasource.UserDataSource
import com.alisdnn.userpanel.domain.user.entity.User
import com.alisdnn.userpanel.domain.user.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {

    override fun getUser(username: String): Single<User> {
        val data = userDataSource.selectUser(username)
        return data.applyIoScheduler()
            .doOnError { e ->
                println(e.message)
            }

    }

    override fun insertUser(user: User): Single<Long> {
        val data = userDataSource.insertUser(user)
        return data.applyIoScheduler()
            .doOnError {
                println(it.message)
            }
    }

}