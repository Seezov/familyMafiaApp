package com.example.familymafiaapp.repositories

import android.util.Log
import com.example.familymafiaapp.network.ApiClient
import com.example.familymafiaapp.network.responses.GoogleSheetResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GameRepository @Inject internal constructor(
    private val apiClient: ApiClient
) {

    fun getPlayers() {
        apiClient.googleSheetsService.getPlayers(
            range = "Игры!G3:G12",
        ).enqueue(object : Callback<GoogleSheetResponse> {
            override fun onResponse(
                call: Call<GoogleSheetResponse>,
                response: Response<GoogleSheetResponse>
            ) {
                Log.d("Success!", response.body()?.values.toString())
            }

            override fun onFailure(call: Call<GoogleSheetResponse>, t: Throwable) {
                Log.e("Failed Query :(", t.toString())
            }
        })
    }
}