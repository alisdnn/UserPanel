package com.alisdnn.userpanel.data.user.datasource

import com.alisdnn.userpanel.data.db.dao.UserDao
import com.alisdnn.userpanel.data.mapper.map
import com.alisdnn.userpanel.domain.user.entity.User
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : UserDataSource {

    override fun selectUser(username: String): Single<User> {
        return userDao.select(username).map {
            it.toDomain()
        }
    }

    override fun insertUser(user: User): Single<Long> {
        return userDao.insert(
            user.map()
        )
    }


}