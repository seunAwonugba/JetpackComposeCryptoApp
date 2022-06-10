package com.example.base.repository

import com.example.base.remote.api.SingleCoinWebService
import com.example.base.remote.data.singlecoin.SingleCoinResponseDto
import retrofit2.Response
import javax.inject.Inject

class SingleCoinRepositoryImpl @Inject constructor(
    private val singleCoinWebService: SingleCoinWebService
) : SingleCoinRepository {
    override suspend fun getSingleCoin(coin_id: String): Response<SingleCoinResponseDto> {
        return singleCoinWebService.getCoinById(coin_id = coin_id)
    }
}