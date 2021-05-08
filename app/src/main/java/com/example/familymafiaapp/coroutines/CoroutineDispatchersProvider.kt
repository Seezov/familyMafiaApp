package com.example.familymafiaapp.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Suppress("PropertyName")
open class CoroutineDispatchersProvider {

    open val Default: CoroutineDispatcher get() =  Dispatchers.Default
    open val Main: CoroutineDispatcher get() = Dispatchers.Main
    open val IO: CoroutineDispatcher get() = Dispatchers.IO
//    open val Unconfined: CoroutineDispatcher get() = Dispatchers.Unconfined//TODO: experimental
}