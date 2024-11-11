package com.example.kotlin_classes.classes.data

    data class Book(
        var title: String,
        var author: String,
        var price: Double,
        var inStock: Boolean
    )

fun main() {
    val book1 = Book("Der Hobbit", "Herr der Ringe Guy", 12.99, true)
    val book2 = Book("Der Hobbit", "Herr der Ringe Guy", 12.99, true)
    val book3 = Book("Der Witcher", "Geralt", 10.99, false)



    // Vergleich der beiden Bücher mit equals()
    println(".equals() Methoden:\n${book1 == book2}\n${book1 == book3} \n")

    // Ausgabe mit toString()
    println(".toString() Methode\n"+book1+"\n")

    // Das Kopieren und Ändern eines Buches und seine Parameter mit copy()
    val book1Copy = book1.copy(title="Der Bobbit", author="Jo", inStock = false)
    println(".copy() Methode:\n$book1\n$book1Copy \n")

    // Componenten mit componentN() anzeigen
    println("Book1 Komponente 1: ${book1.component1()}\nBook1 Komponente 2: ${book1.component2()} \n")

    //Hash der das Objekt repräsentiert mit hashCode() anzeigen
    println("Hash-Code von book1: ${book1.hashCode()}")
    println("Hash-Code von book2: ${book2.hashCode()}")
}