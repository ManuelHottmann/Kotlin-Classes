package com.example.kotlin_classes.abschluss_abgabe

class LibraryHandler {

    // Instanz der Bibliothek und des Mitglieds
    private val library = Library()

    // Funktion zum Einrichten der Bibliothek und zum Starten des Systems
    fun setupLibrary() {
        // Adresse der Bibliothek
        val address = Library.LibraryAddress("Main St 123", "Booktown", "12345")
        address.printAddress()

        // Bücher hinzufügen
        library.addBook(Book("The Hobbit", "J.R.R. Tolkien", Genre.FICTION, BookStatus.Available))
        library.addBook(Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, BookStatus.Available))
        library.addBook(Book("The Art of War", "Sun Tzu", Genre.HISTORY, BookStatus.Available))

        // Status der Bücher anzeigen
        println("Initial book statuses:")
        library.displayBookStatuses()
    }

    // Funktion zum Simulieren von Mitgliederaktionen
    fun simulateLibraryMemberActions() {
        // Ein Bibliotheksmitglied erstellen
        val member = library.LibraryMember("Alice", 1)

        // Ein Buch ausleihen und ein anderes reservieren
        val bookToCheckout = library.searchBooksByTitle("The Hobbit").first()
        member.checkoutBook(bookToCheckout, "2023-12-31")

        val bookToReserve = library.searchBooksByTitle("A Brief History of Time").first()
        member.reserveBook(bookToReserve)

        // Aktualisierter Status aller Bücher anzeigen
        println("\nUpdated book statuses after member actions:")
        library.displayBookStatuses()
    }
}

fun main() {
    val libraryHandler = LibraryHandler()
    libraryHandler.setupLibrary()          // Initialisiert die Bibliothek und fügt Bücher hinzu
    libraryHandler.simulateLibraryMemberActions()  // Führt Aktionen von Bibliotheksmitgliedern aus
}