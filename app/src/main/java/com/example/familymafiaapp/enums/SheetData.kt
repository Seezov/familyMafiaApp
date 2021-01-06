package com.example.familymafiaapp.enums

enum class SheetData(val range: String, val majorDimension: String = "ROWS") {
    WINNER("Игры!C3", "ROWS"),
    FIRST_KILLED("Игры!C4", "ROWS"),
    BEST_MOVE("Игры!C5:E5", "ROWS"),
    HOST("Игры!C11", "ROWS"),
    DATE("Игры!C12", "ROWS"),
    FOULS("Игры!F3:F12", "COLUMNS"),
    PLAYERS("Игры!G3:G12", "COLUMNS"),
    ROLES("Игры!T3:T12", "COLUMNS"),
    ADDITIONAL_POINTS("Игры!W3:W12", "COLUMNS")
}