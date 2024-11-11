package com.example.kotlin_classes.classes.nested_inner

/**
 * 1.)-> Erstelle eine Klasse Library, die Informationen über eine Bibliothek enthält.
 *
 * 2.)-> Erstelle eine nested class Book, die Informationen über ein Buch speichert (z.B. Titel und Autor).
 *
 * 3.)-> Erstelle eine inner class Librarian, die auf den Namen der Bibliothek zugreifen und einen Satz ausgeben kann,
 *       der den Bibliotheksnamen und den Namen des Bibliothekars enthält.
 *
 * 4.)->     Teste im main-Bereich die Funktionalität, indem du ein Buch und einen Bibliothekar erstellst und ihre Informationen ausgibst.
 */

// Äußere Klasse für eine Bibliothek
class Library(val libraryName: String) {

    // Nested Class: Kann unabhängig von Library verwendet werden
    class Book(val title: String, val author: String) {
        fun getBookInfo() = "Book Title: $title, Author: $author"
    }

    // Inner Class: Hat Zugriff auf die Mitglieder der äußeren Klasse Library
    inner class Librarian(val name: String) {
        fun getLibrarianInfo() = "Librarian: $name, Library: $libraryName"
    }
}

fun main() {
    // Erstellen einer Nested Class-Instanz
    val book = Library.Book("Kotlin Programming", "John Doe")
    println(book.getBookInfo())  // Ausgabe: "Book Title: Kotlin Programming, Author: John Doe"

    // Erstellen einer Library-Instanz und einer Inner Class-Instanz
    val myLibrary = Library("City Library")
    val librarian = myLibrary.Librarian("Alice Smith")
    println(librarian.getLibrarianInfo())  // Ausgabe: "Librarian: Alice Smith, Library: City Library"
}