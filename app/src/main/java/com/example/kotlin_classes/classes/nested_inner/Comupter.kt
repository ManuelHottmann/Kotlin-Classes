package com.example.kotlin_classes.classes.nested_inner

// Äußere Klasse für Computer
class Computer(val model: String) {

    // Nested Class: Diese Klasse kann unabhängig von der äußeren Klasse verwendet werden
    class Component(val name: String, val manufacturer: String) {
        fun getInfo() = "Component: $name, Manufacturer: $manufacturer"
    }

    // Inner Class: Diese Klasse kann auf die Mitglieder der äußeren Klasse zugreifen
    inner class Processor(val coreCount: Int) {
        fun getDetails() = "Computer Model: $model, Processor Cores: $coreCount"
    }
}

fun main() {
    // Erstellen einer Nested Class-Instanz
    val component = Computer.Component("RAM", "Kingston")
    println(component.getInfo())  // Ausgabe: "Component: RAM, Manufacturer: Kingston"

    // Erstellen eines Computer-Objekts und einer Inner Class-Instanz
    val myComputer = Computer("UltraPC 3000")
    val processor = myComputer.Processor(8)
    println(processor.getDetails())  // Ausgabe: "Computer Model: UltraPC 3000, Processor Cores: 8"
}