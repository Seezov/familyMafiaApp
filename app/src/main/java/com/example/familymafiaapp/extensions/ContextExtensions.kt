package com.example.familymafiaapp.extensions

import android.content.Context
import com.example.familymafiaapp.FamilyMafiaApp
import com.example.familymafiaapp.di.components.AppComponent

val Context.component: AppComponent
    get() = (applicationContext as FamilyMafiaApp).component()