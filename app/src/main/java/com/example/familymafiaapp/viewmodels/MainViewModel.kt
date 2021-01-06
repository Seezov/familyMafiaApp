package com.example.familymafiaapp.viewmodels

import android.app.Application
import com.example.familymafiaapp.repositories.GameRepository

class MainViewModel(application: Application, private val gameRepository: GameRepository) : BaseViewModel(application){

    fun getPlayers() {
        gameRepository.getPlayers()
    }
}