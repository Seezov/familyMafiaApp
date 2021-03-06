package com.example.familymafiaapp.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.familymafiaapp.repositories.GameRepository
import com.example.familymafiaapp.viewmodels.MainViewModel
import com.squareup.moshi.Moshi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject internal constructor(
    private val application: Application,
    private val gameRepository: GameRepository,
    private val moshi: Moshi
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(
                application,
                gameRepository,
                moshi
            ) as T
            else -> throw IllegalArgumentException()
        }
    }
}