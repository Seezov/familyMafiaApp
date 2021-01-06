package com.example.familymafiaapp.di.components

import com.example.familymafiaapp.FamilyMafiaApp
import com.example.familymafiaapp.activities.BaseMvvmActivity
import com.example.familymafiaapp.di.modules.ApiClientModule
import com.example.familymafiaapp.di.modules.SystemModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ApiClientModule::class,
        SystemModule::class
    ]
)
@Singleton
interface AppComponent {

    //region Application

    fun inject(familyMafiaApp: FamilyMafiaApp)
    //endregion

    //region Activities

    fun inject(activity: BaseMvvmActivity)
    //endregion
}