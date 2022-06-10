package com.example.base.repository

import com.example.base.remote.data.singlecoin.SingleCoinResponseDto
import com.example.base.view.SingleCoinResponse
import retrofit2.Response

interface SingleCoinRepository {
    suspend fun getSingleCoin(coin_id : String) : Response<SingleCoinResponseDto>
}