package com.example.kotlin_classes.classes.enums

enum class Season(val description: String) {
    SPRING("Blossoms"),
    SUMMER("Hot"),
    FALL("Leaves falling"),
    WINTER("Cold");

    // Funktion, die die Beschreibung der jeweiligen Jahreszeit ausgibt
    fun printDescription() {
        println(description)
    }
}

// Funktion, die je nach Jahreszeit eine spezifische Nachricht ausgibt
fun handleSeason(season: Season) {
    when (season) {
        Season.SPRING -> println("It's SPRING: Time for flowers to bloom!")
        Season.SUMMER -> println("It's SUMMER: Time for sunshine and warmth.")
        Season.FALL -> println("It's FALL: Leaves are falling and colors change.")
        Season.WINTER -> println("It's WINTER: Cold and snowy days are here.")
    }
}

fun main() {
    val currentSeason = Season.SPRING
    currentSeason.printDescription()
    handleSeason(currentSeason)
}