package com.example.base.repository

import com.example.base.remote.data.allcoins.AllCoinsResponseDto
import com.example.base.view.AllCoinsResponse
import retrofit2.Response

interface AllCoinsRepository {
    suspend fun getAllCoins() : Response<AllCoinsResponseDto>
}