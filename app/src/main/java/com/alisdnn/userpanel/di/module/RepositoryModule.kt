package com.alisdnn.userpanel.di.module

import com.alisdnn.userpanel.data.db.base.UserDatabase
import com.alisdnn.userpanel.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserDao(
        userDatabase: UserDatabase
    ): UserDao {
        return userDatabase.userDao()
    }

}