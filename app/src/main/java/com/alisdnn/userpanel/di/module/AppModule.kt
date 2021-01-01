package com.alisdnn.userpanel.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.alisdnn.userpanel.data.db.base.UserDatabase
import com.alisdnn.userpanel.data.network.BaseHttpClient
import com.alisdnn.userpanel.data.network.BaseRetrofit
import com.alisdnn.userpanel.domain.extension.allowWrites
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.RetentionManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun resources(application: Application): Resources = application.resources

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun okHttpClient(baseHttpClient: BaseHttpClient): OkHttpClient = baseHttpClient.okHttpClient

    @Provides
    @Singleton
    fun retrofit(baseRetrofit: BaseRetrofit): Retrofit = baseRetrofit.retrofit

    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        UserDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun chuckerCollector(@ApplicationContext appContext: Context): ChuckerCollector =
        allowWrites {
            ChuckerCollector(
                context = appContext,
                showNotification = true,
                retentionPeriod = RetentionManager.Period.ONE_HOUR
            )
        }




}