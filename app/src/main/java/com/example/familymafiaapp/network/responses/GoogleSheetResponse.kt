package com.example.familymafiaapp.network.responses

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleSheetResponse(
    var range: String,
    var majorDimension: String,
    var values: List<List<String>>
)
