package com.example.details

import com.example.base.view.SingleCoinResponse

data class SingleCoinState(
    val isLoading: Boolean = false,
    //not fetching a list of data, fetching a data, thats why this is not a list
    val fetchedCoins : SingleCoinResponse? = null,
    val error : String = ""
)