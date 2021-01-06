package com.example.familymafiaapp.enums

enum class SheetData(val range: String) {
    WINNER("Игры!C3"),
    FIRST_KILLED("Игры!C4"),
    BEST_MOVE("Игры!C5:E5"),
    HOST("Игры!C11"),
    DATE("Игры!C12"),
    FOULS("Игры!F3:F12"),
    PLAYERS("Игры!G3:G12"),
    ROLES("Игры!T3:T12"),
    ADDITIONAL_POINTS("Игры!W3:W12")
}