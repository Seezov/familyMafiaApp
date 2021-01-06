package com.example.familymafiaapp

import android.app.Application
import com.example.familymafiaapp.di.components.AppComponent
import com.example.familymafiaapp.di.components.DaggerAppComponent

open class FamilyMafiaApp : Application() {

    open val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    @Deprecated("Remove this", replaceWith = ReplaceWith("FamilyMafiaApp.component"))
    fun component(): AppComponent = component

    init {
        application = this
    }

    companion object {

        @Suppress("unused")
        private val TAG = FamilyMafiaApp::class.java.simpleName

        lateinit var application: FamilyMafiaApp
            private set
    }
}
