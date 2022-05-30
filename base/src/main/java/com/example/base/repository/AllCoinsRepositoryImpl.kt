package com.example.base.repository

import com.example.base.viewdata.AllCoinsResponse
import retrofit2.Response

class AllCoinsRepositoryImpl : AllCoinsRepository {

    override suspend fun getAllCoins(): Response<AllCoinsResponse> {
        TODO("Not yet implemented")
    }
}