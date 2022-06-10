package com.example.base.repository

import com.example.base.remote.api.AllCoinsWebService
import com.example.base.remote.data.allcoins.AllCoinsResponseDto
import com.example.base.view.AllCoinsResponse
import retrofit2.Response
import javax.inject.Inject

class AllCoinsRepositoryImpl @Inject constructor(
    private val allCoinsWebService: AllCoinsWebService
) : AllCoinsRepository {
    override suspend fun getAllCoins(): Response<AllCoinsResponseDto> {
        return allCoinsWebService.getAllCoins()
    }
}