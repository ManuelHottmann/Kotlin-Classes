package com.example.kotlin_classes.classes.data


/**
 *    Erstelle folgende Data-Class:   Product(name, category, price, inStock)
 */
data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val inStock: Boolean
) {
    /**
     *    Implementiere eine Rabattfunktion applyDiscount(discount). 
     *    Diese Methode soll einen Rabatt auf den Preis anwenden und eine neue Instanz des Produkts mit einem reduzierten Preis zurückgeben. 
     *    Verwende hierfür die copy() Methode.​
     */
    fun applyDiscount(discount: Double): Product {
        return this.copy(price = price * (1 - discount))
    }
}

/**
 *    Erstelle eine weitere Data-Class: Order(orderNumber, products, customer).
 *    Dazu eine Methode welche die Gesamtsumme der Bestellung berechnen soll, indem sie die Preise aller Product-Objekte in der products-Liste summiert.
 */
data class Order(val orderNumber: String, val products: List<Product>, val customer: String) {
    fun calculateTotal(): Double {
        var total = 0.0
        for (product in products) {
            total += product.price
        }
        return total
    }
    /**
     * Alternativ
        fun calculateTotal(): Double {
            return products.sumOf { it.price }
        }
     */


     
    /**
     *    Füge der Order-Klasse eine Methode filterInStockProducts():Order hinzu, die eine neue Bestellung nur mit den Produkten erstellt, die auf Lager sind.
     *    Verwende auch hier die copy()-Funktion von data-Klassen, um eine abgewandelte Kopie der Bestellung zu erstellen​
     */
    fun filterInStockProducts(): Order {
        val inStockProducts = products.filter { it.inStock }
        return this.copy(products = inStockProducts)
    }

}

fun main() {
    /**
     * Hier werden 3 Product-Klassen angelegt mit welchen die Funktionen getestet werden
     */
    val product1 = Product("Laptop", "Elektronik", 999.99, true)
    val product2 = Product("Kaffeemaschine", "Haushaltsgeräte", 79.99, false)
    val product3 = Product("Smartphone", "Elektronik", 499.99, true)

    val discountedProduct1 = product1.applyDiscount(0.5)
    println("Rabattierter Laptop: $discountedProduct1\n")

    val order = Order("12345", listOf(product1, product2, product3), "Alice")
    println("Gesamtsumme der Bestellung: ${order.calculateTotal()}\n")

    val inStockOrder = order.filterInStockProducts()
    println("Bestellung mit vorrätigen Produkten: $inStockOrder\n")
}
