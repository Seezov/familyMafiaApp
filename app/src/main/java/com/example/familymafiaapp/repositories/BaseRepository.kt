package com.example.familymafiaapp.repositories

import com.example.familymafiaapp.coroutines.CoroutineDispatchersProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository(
    coroutineDispatchersProvider: CoroutineDispatchersProvider
) : CoroutineScope {

    override val coroutineContext: CoroutineContext =
        coroutineDispatchersProvider.IO + SupervisorJob()
}