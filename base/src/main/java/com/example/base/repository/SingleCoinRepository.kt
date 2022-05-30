package com.example.base.repository

import com.example.base.viewdata.SingleCoinResponse
import retrofit2.Response

interface SingleCoinRepository {
    suspend fun getSingleCoin(coin_id : String) : Response<SingleCoinResponse>
}