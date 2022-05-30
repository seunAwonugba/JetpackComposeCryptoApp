package com.example.base.viewdata

data class AllCoinsResponse(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
