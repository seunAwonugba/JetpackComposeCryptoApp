package com.example.base.view

import com.example.base.remote.data.singlecoin.*

data class SingleCoinResponse(
    val description: String?,
    val development_status: String?,
    val first_data_at: String?,
    val id: String?,
    val is_active: Boolean?,
    val is_new: Boolean?,
    val last_data_at: String?,
    val links: SingleCoinResponseDto.Links?,
    val links_extended: List<SingleCoinResponseDto.LinksExtended?>,
    val name: String?,
    val rank: Int?,
    val started_at: String?,
    val symbol: String?,
    val tags: List<SingleCoinResponseDto.Tag>,
    val team: List<SingleCoinResponseDto.Team?>,
    val type: String?,
    val whitepaper: SingleCoinResponseDto.Whitepaper?
)
