package com.alisdnn.userpanel.data.db.base

import androidx.paging.DataSource
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update
import io.reactivex.Flowable
import io.reactivex.Single

interface BaseDao<T : Any> {

    fun select(id: Long): Flowable<T>

    fun selectAllPaged(): DataSource.Factory<Int, T>

    @Insert(onConflict = IGNORE)
    fun insert(t: T): Long

    @Insert(onConflict = REPLACE)
    fun insert(ts: List<T>)

    @Update(onConflict = REPLACE)
    fun update(t: T)

    @Update(onConflict = REPLACE)
    fun update(ts: List<T>)

    @Delete
    fun delete(t: T): Single<Int>

    @Delete
    fun delete(ts: List<T>)

}