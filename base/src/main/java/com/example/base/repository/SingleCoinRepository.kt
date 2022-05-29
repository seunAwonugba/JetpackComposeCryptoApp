package com.example.base.repository

import com.example.base.data.ui.SingleCoinResponse
import retrofit2.Response

interface SingleCoinRepository {
    suspend fun getSingleCoin(coin_id : String) : Response<SingleCoinResponse>
}