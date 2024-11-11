package com.example.kotlin_classes.abschluss_abgabe

// Hauptklasse für die Bibliothek
class Library {
    private val books = mutableListOf<Book>()

    // Nested Class für die Bibliotheksadresse
    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun printAddress() {
            println("Library Address: $street, $city, $zipCode")
        }
    }

    // Inner Class für ein Bibliotheksmitglied
    inner class LibraryMember(val name: String, val memberID: Int) {
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out '${book.title}' until $dueDate")
            } else {
                println("Cannot checkout '${book.title}': ${book.status.printStatus()}")
            }
        }

        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved '${book.title}'")
            } else {
                println("Cannot reserve '${book.title}': ${book.status.printStatus()}")
            }
        }
    }

    // Methoden für Bibliotheksmanagement
    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchBooksByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, ignoreCase = true) }
    }

    fun searchBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author.contains(author, ignoreCase = true) }
    }

    fun displayBookStatuses() {
        for (book in books) {
            println("Book: '${book.title}' by ${book.author} - ${book.status.printStatus()}")
        }
    }
}



