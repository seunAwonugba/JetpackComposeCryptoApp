package com.example.base.remote.api

import com.example.base.Constants.ALL_COINS_END_POINT
import com.example.base.remote.data.allcoins.AllCoinsResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface AllCoinsWebService {

    @GET(ALL_COINS_END_POINT)
    suspend fun getAllCoins() : Response<AllCoinsResponseDto>


}