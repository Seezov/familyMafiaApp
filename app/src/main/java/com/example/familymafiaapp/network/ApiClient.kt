package com.example.familymafiaapp.network

import com.example.familymafiaapp.network.services.GoogleSheetsService
import retrofit2.Retrofit

class ApiClient(retrofit: Retrofit) {

    val googleSheetsService: GoogleSheetsService = retrofit.create(GoogleSheetsService::class.java)

}