package com.example.kotlin_classes.abschluss_abgabe

sealed class BookStatus {
    object Available : BookStatus()
    data class CheckedOut(val dueDate: String) : BookStatus()
    data class Reserved(val reservedBy: String) : BookStatus()

    fun printStatus() = when (this) {
        is Available -> "Status: Available"
        is CheckedOut -> "Status: Checked out until $dueDate"
        is Reserved -> "Status: Reserved by $reservedBy"
    }
}