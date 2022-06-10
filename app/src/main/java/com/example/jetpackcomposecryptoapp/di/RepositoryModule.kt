package com.example.jetpackcomposecryptoapp.di

import com.example.base.remote.api.AllCoinsWebService
import com.example.base.remote.api.SingleCoinWebService
import com.example.base.repository.AllCoinsRepository
import com.example.base.repository.AllCoinsRepositoryImpl
import com.example.base.repository.SingleCoinRepository
import com.example.base.repository.SingleCoinRepositoryImpl
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
    fun provideAllCoinsWebService(retrofit: Retrofit) : AllCoinsWebService = retrofit.create()

    @Singleton
    @Provides
    fun provideSingleCoinWebService(retrofit: Retrofit) : SingleCoinWebService = retrofit.create()

    @Singleton
    @Provides
    fun provideAllCoinsRepository(allCoinsWebService: AllCoinsWebService) : AllCoinsRepository{
        return AllCoinsRepositoryImpl(allCoinsWebService = allCoinsWebService)
    }

    @Singleton
    @Provides
    fun provideSingleCoinRepository(singleCoinWebService: SingleCoinWebService) : SingleCoinRepository{
        return SingleCoinRepositoryImpl(singleCoinWebService = singleCoinWebService)
    }
}