package com.example.base.view

import com.example.base.remote.data.singlecoin.*

data class SingleCoinResponse(
    val description: String = "",
    val development_status: String = "",
    val first_data_at: String = "",
    val id: String = "",
    val is_active: Boolean = false,
    val is_new: Boolean = false,
    val last_data_at: String = "",
    val links: SingleCoinResponseDto.Links = SingleCoinResponseDto.Links(),
    val links_extended: List<SingleCoinResponseDto.LinksExtended> = emptyList(),
    val name: String = "",
    val rank: Int = 0,
    val started_at: String = "",
    val symbol: String = "",
    val tags: List<SingleCoinResponseDto.Tag> = emptyList(),
    val team: List<SingleCoinResponseDto.Team> = emptyList(),
    val type: String = "",
    val whitepaper: SingleCoinResponseDto.Whitepaper = SingleCoinResponseDto.Whitepaper()
)
