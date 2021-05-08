package com.example.familymafiaapp.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.familymafiaapp.R
import com.example.familymafiaapp.adapters.GamesAdapter
import com.example.familymafiaapp.entities.Game
import com.example.familymafiaapp.entities.GameRange
import com.example.familymafiaapp.repositories.GameRepository
import com.squareup.moshi.Moshi
import kotlinx.coroutines.*

class MainViewModel(
    application: Application,
    private val gameRepository: GameRepository,
    val moshi: Moshi,
    val adapter: GamesAdapter = GamesAdapter()
) : BaseViewModel(application) {

    private val _game = MutableLiveData<Game?>()
    val game: LiveData<Game?> = _game

    fun getGames() {
        GlobalScope.launch(Dispatchers.IO) {
            // 817
            for (i in 3..817 step 11) {
                gameRepository.getGame(
                    getApplication<Application>().getString(
                        R.string.complex_range,
                        "C$i",
                        "W${i + 9}"
                    )
                )?.let {
                    _game.postValue(it)
                }
            }
        }
    }
}