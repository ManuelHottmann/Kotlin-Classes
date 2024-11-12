package com.example.kotlin_classes.abschluss_abgabe

enum class Genre(val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Based on real events and facts"),
    SCIENCE("Scientific books and references"),
    HISTORY("Historical accounts and studies"),
    CHILDREN("Books for children");

    fun printDescription() {
        println(description)
    }
}