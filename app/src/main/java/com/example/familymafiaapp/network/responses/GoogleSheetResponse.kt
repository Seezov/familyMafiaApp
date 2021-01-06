package com.example.familymafiaapp.network.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleSheetResponse(
    @field:Json(name = "range")
    var range: String,
    @field:Json(name = "majorDimension")
    var majorDimension: String,
    @field:Json(name = "values")
    var values: List<List<String>>
)
