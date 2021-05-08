package com.example.familymafiaapp.repositories

import com.example.familymafiaapp.coroutines.CoroutineDispatchersProvider
import com.example.familymafiaapp.entities.Game
import com.example.familymafiaapp.entities.GameRange
import com.example.familymafiaapp.enums.SheetData.*
import com.example.familymafiaapp.extensions.await
import com.example.familymafiaapp.network.ApiClient
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepository @Inject internal constructor(
    private val apiClient: ApiClient,
    coroutineDispatchersProvider: CoroutineDispatchersProvider
) : BaseRepository(coroutineDispatchersProvider) {

    suspend fun getGame(gameRange: String): Game? = withContext(coroutineContext) {
        with(apiClient.googleSheetsService) {
            try {
                val gameArray = getSheetData(
                    range = gameRange,
                    majorDimension = "COLUMNS"
                ).await().values

                return@withContext Game(
                    winner = gameArray[0][0],
                    firstKilled = try {
                        (gameArray[0][1]).takeIf { it.isNotEmpty() }?.toInt() ?: 0
                    } catch (e: java.lang.Exception) {
                        0
                    },
                    bestMove = try {
                        listOf(
                            (gameArray[0][2]).takeIf { it.isNotEmpty() }?.toInt() ?: 0,
                            (gameArray[1][2]).takeIf { it.isNotEmpty() }?.toInt() ?: 0,
                            (gameArray[2][2]).takeIf { it.isNotEmpty() }?.toInt() ?: 0
                        )
                    } catch (e: java.lang.Exception) {
                        emptyList()
                    },
                    host = try {
                        gameArray[0][8]
                    } catch (e: java.lang.Exception) {
                        ""
                    },
                    date = try {
                        gameArray[0][9]
                    } catch (e: java.lang.Exception) {
                        ""
                    },
                    fouls = gameArray[3].map {
                        if (it.isEmpty()) {
                            0
                        } else {
                            it.toInt()
                        }
                    }.toMutableList().apply {
                        if (size < 10) {
                            repeat(10 - size) {
                                add(0)
                            }
                        }
                    },
                    players = gameArray[4].toMutableList().apply {
                        if (size < 10) {
                            repeat(10 - size) {
                                add("")
                            }
                        }
                    },
                    roles = try {
                        gameArray[17]
                    } catch (e: java.lang.Exception) {
                        emptyList()
                    },
                    additionalPoints = try {
                        gameArray[20].map {
                            if (it.isEmpty()) {
                                0.0F
                            } else {
                                it.toFloat()
                            }
                        }.toMutableList().apply {
                            if (size < 10) {
                                repeat(10 - size) {
                                    add(0.0F)
                                }
                            }
                        }
                    } catch (e: java.lang.Exception) {
                        emptyList()
                    }
                )
            } catch (e: Exception) {
                e.printStackTrace()
                return@withContext null
            }
        }
    }
}