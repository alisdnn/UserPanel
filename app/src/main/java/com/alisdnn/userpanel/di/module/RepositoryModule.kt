package com.alisdnn.userpanel.di.module

import com.alisdnn.userpanel.data.db.base.UserDatabase
import com.alisdnn.userpanel.data.db.dao.UserDao
import com.alisdnn.userpanel.data.user.datasource.UserDataSource
import com.alisdnn.userpanel.data.user.datasource.UserDataSourceImpl
import com.alisdnn.userpanel.data.user.repository.UserRepositoryImpl
import com.alisdnn.userpanel.domain.user.repository.UserRepository
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
    fun provideUserRepository(
        userDataSource: UserDataSource
    ): UserRepository {
        return UserRepositoryImpl(
            userDataSource = userDataSource
        )
    }

    @Singleton
    @Provides
    fun provideUserDataSource(
        userDao: UserDao
    ): UserDataSource {
        return UserDataSourceImpl(
            userDao = userDao
        )
    }

    @Singleton
    @Provides
    fun provideUserDao(
        userDatabase: UserDatabase
    ): UserDao {
        return userDatabase.userDao()
    }

}