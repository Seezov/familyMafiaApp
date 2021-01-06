package com.example.familymafiaapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.familymafiaapp.di.ViewModelFactory
import com.example.familymafiaapp.extensions.component
import com.example.familymafiaapp.viewmodels.BaseViewModel
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class BaseMvvmActivity : AppCompatActivity() {

    protected abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected inline fun <reified T : BaseViewModel> viewModelDelegate() =
        object : ReadOnlyProperty<AppCompatActivity, T> {

            var value: T? = null

            override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
                if (value == null) {
                    value = ViewModelProvider(viewModelStore, viewModelFactory).get(T::class.java)
                }
                return value as T
            }
        }
}