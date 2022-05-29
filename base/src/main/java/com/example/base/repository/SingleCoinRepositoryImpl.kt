package com.example.base.repository

import com.example.base.data.ui.SingleCoinResponse
import retrofit2.Response

class SingleCoinRepositoryImpl : SingleCoinRepository {

    override suspend fun getSingleCoin(coin_id: String): Response<SingleCoinResponse> {
        TODO("Not yet implemented")
    }
}