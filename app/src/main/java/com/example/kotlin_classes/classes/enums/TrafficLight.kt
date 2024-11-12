package com.example.kotlin_classes.classes.enums

/**
 * 1.)-> Erstellt eine Enum Class namens TrafficLight mit den Werten RED, YELLOW und GREEN.
 *
 * 2.)-> Fügt jeder Farbe eine Beschreibung hinzu, z.B. "Stop" für RED, "Ready" für YELLOW und "Go" für GREEN.
 *
 * 3.)-> Implementiert eine Funktion in der Enum Class, die die Beschreibung der jeweiligen Farbe ausgibt.
 *
 * 4.)-> Verwendet das when-Statement, um eine Logik zu schreiben, die auf Basis der Ampelfarbe eine Ausgabe erzeugt.
 */

enum class TrafficLight(val description: String) {
    RED("Stop"),
    YELLOW("Ready"),
    GREEN("Go");

    // Funktion, die die Beschreibung der jeweiligen Farbe ausgibt
    fun printDescription() {
        println(description)
    }
}

// Funktion, die je nach Ampelfarbe eine spezifische Nachricht ausgibt
fun handleTrafficLight(light: TrafficLight) {
    when (light) {
        TrafficLight.RED -> println("The light is RED: Please stop and wait.")
        TrafficLight.YELLOW -> println("The light is YELLOW: Get ready, but do not move yet.")
        TrafficLight.GREEN -> println("The light is GREEN: You may proceed safely.")
    }
}

fun main() {
    // Enum-Werte erstellen und testen
    val currentLight = TrafficLight.RED
    currentLight.printDescription() // Ausgabe: Stop

    // Aufruf der Funktion, um Logik je nach Ampelfarbe zu testen
    handleTrafficLight(currentLight)  // Ausgabe: The light is RED: Please stop and wait.
}