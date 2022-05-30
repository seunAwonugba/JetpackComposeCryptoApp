package com.example.base.remote.api

import com.example.base.Constants.SINGLE_COIN_END_POINT
import com.example.base.remote.data.singlecoin.SingleCoinResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SingleCoinWebService {

    @GET(SINGLE_COIN_END_POINT)
    suspend fun getCoinById(
        @Path("coin_id") coin_id : String
    ) : Response<SingleCoinResponseDto>
}