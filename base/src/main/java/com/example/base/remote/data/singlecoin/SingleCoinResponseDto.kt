package com.example.base.remote.data.singlecoin

data class SingleCoinResponseDto(
    val description: String? = "",
    val development_status: String? = "",
    val first_data_at: String? = "",
    val hardware_wallet: Boolean? = false,
    val hash_algorithm: String? = "",
    val id: String? = "",
    val is_active: Boolean? = false,
    val is_new: Boolean? = false,
    val last_data_at: String? = "",
    val links: Links = Links(),
    val links_extended: List<LinksExtended> = emptyList(),
    val message: String? = "",
    val name: String? = "",
    val open_source: Boolean? = false,
    val org_structure: String? = "",
    val proof_type: String? = "",
    val rank: Int? = 0,
    val started_at: String? = "",
    val symbol: String? = "",
    val tags: List<Tag> = emptyList(),
    val team: List<Team> = emptyList(),
    val type: String? = "",
    val whitepaper: Whitepaper = Whitepaper()
){
    data class Links(
        val explorer: List<String> = emptyList(),
        val facebook: List<String> = emptyList(),
        val reddit: List<String> = emptyList(),
        val source_code: List<String> = emptyList(),
        val website: List<String> = emptyList(),
        val youtube: List<String> = emptyList()
    )

    data class LinksExtended(
        val stats: Stats? = Stats(),
        val type: String? = "",
        val url: String? = ""
    ){
        data class Stats(
            val contributors: Int? = 0,
            val followers: Int? = 0,
            val stars: Int? = 0,
            val subscribers: Int? = 0
        )
    }

    data class Tag(
        val coin_counter: Int? = 0,
        val ico_counter: Int? = 0,
        val id: String? = "",
        val name: String? = ""
    )

    data class Team(
        val id: String? = "",
        val name: String? = "",
        val position: String? = ""
    )


    data class Whitepaper(
        val link: String? = "",
        val thumbnail: String? = ""
    )


}