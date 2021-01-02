package com.alisdnn.userpanel.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alisdnn.userpanel.data.db.base.BaseDao
import io.reactivex.Single

@Dao
interface UserDao : BaseDao<UserData> {

    @Query("SELECT * FROM user WHERE username = :username")
    fun select(username: String): Single<UserData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insert(t: UserData): Single<Long>
}