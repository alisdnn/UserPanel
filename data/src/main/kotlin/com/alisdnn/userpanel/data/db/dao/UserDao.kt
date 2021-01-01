package com.alisdnn.userpanel.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.alisdnn.userpanel.data.db.base.BaseDao
import io.reactivex.Single

@Dao
interface UserDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM user WHERE username = :username")
    fun select(username: String): Single<UserEntity>

}