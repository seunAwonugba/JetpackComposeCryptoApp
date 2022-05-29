package com.example.base.data.remote.allcoins.api

import com.example.base.Constants.ALL_COINS_END_POINT
import com.example.base.data.remote.allcoins.AllCoinsResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface AllCoinsWebService {

    @GET(ALL_COINS_END_POINT)
    suspend fun getAllCoins() : Response<AllCoinsResponseDto>


}