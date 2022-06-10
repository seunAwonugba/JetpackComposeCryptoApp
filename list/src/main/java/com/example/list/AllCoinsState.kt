package com.example.list

import com.example.base.view.AllCoinsResponse

data class AllCoinsState(
    val isLoading: Boolean = false,
    val fetchedCoins : List<AllCoinsResponse> = emptyList(),
    val error : String = ""
)
