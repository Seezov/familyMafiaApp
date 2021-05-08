package com.example.familymafiaapp.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Game(
    val winner: String,
    val firstKilled: Int,
    val bestMove: List<Int>,
    val host: String,
    val date: String,
    val fouls: List<Int>,
    val players: List<String>,
    val roles: List<String>,
    val additionalPoints: List<Float>
)