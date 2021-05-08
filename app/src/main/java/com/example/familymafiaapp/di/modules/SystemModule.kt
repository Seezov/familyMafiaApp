package com.example.familymafiaapp.di.modules

import android.app.Application
import com.example.familymafiaapp.FamilyMafiaApp
import com.example.familymafiaapp.coroutines.CoroutineDispatchersProvider
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SystemModule {

    companion object {

        val moshi: Moshi = Moshi.Builder()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApplication(): Application = FamilyMafiaApp.application

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = moshi

    @Provides
    @Singleton
    fun provideCoroutineDispatchersProvider() = CoroutineDispatchersProvider()
}