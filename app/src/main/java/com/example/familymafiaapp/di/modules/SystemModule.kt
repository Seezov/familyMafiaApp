package com.example.familymafiaapp.di.modules

import android.app.Application
import com.example.familymafiaapp.FamilyMafiaApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SystemModule {

    @Provides
    @Singleton
    internal fun provideApplication(): Application = FamilyMafiaApp.application
}