package com.example.familymafiaapp.network.services

import com.example.familymafiaapp.network.responses.GoogleSheetResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleSheetsService {

    @GET("{sheetId}/values/{range}")
    fun getSheetData(
        @Path("sheetId") sheetId: String = BASE_SHEET_ID,
        @Path("range") range: String,
        @Query("key") key: String = BASE_SHEET_KEY,
        @Query("majorDimension") majorDimension: String?
    ) : Call<GoogleSheetResponse>

    companion object {
        private const val BASE_SHEET_ID = "1snjU7SF_ww1cEMT8IYlRip4-nbVd9Nnd9rjTo35RZuA"
        private const val BASE_SHEET_KEY = "AIzaSyDaKmOHGwakaX6zHqSLXlP3rVljtLgI6ZE"
    }
}