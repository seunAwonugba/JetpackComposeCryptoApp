package com.example.base.repository

import com.example.base.data.ui.AllCoinsResponse
import retrofit2.Response

interface AllCoinsRepository {
    suspend fun getAllCoins() : Response<AllCoinsResponse>
}