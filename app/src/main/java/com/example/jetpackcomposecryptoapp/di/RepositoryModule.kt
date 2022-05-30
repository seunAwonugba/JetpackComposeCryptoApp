package com.example.jetpackcomposecryptoapp.di

import com.example.base.data.remote.allcoins.api.AllCoinsWebService
import com.example.base.data.remote.singlecoins.api.SingleCoinWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideListWebService(retrofit: Retrofit) : AllCoinsWebService = retrofit.create()

    @Singleton
    @Provides
    fun provideDetailsWebService(retrofit: Retrofit) : SingleCoinWebService = retrofit.create()
}