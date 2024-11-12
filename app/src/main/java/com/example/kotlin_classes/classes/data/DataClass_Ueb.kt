package com.example.kotlin_classes.classes.data

data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val inStock: Boolean
) {
    fun applyDiscount(discount: Double): Product {
        return this.copy(price = price * (1 - discount))
    }
}

data class Order(val orderNumber: String, val products: List<Product>, val customer: String) {
    fun calculateTotal(): Double {
        return products.sumOf { it.price }
    }

    fun filterInStockProducts(): Order {
        val inStockProducts = products.filter { it.inStock }
        return this.copy(products = inStockProducts)
    }
    /*
    //Alternative
    fun calculateTotal(): Double {
        var total = 0.0
        for (product in products) {
            total += product.price
        }
        return total
    }
     */


}

fun main() {

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