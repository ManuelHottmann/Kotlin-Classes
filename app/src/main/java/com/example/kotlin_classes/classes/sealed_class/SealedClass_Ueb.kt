package com.example.kotlin_classes.classes.sealed_class

/**
 * 1.
 * Definiere eine Sealed Class OrderStatus, die die verschiedenen Status einer Bestellung darstellt. Jedes Stadium des Versandprozesses soll durch eine spezifische Klasse innerhalb der OrderStatus-Sealed Class dargestellt werden. Es gibt folgende Status:
 *
 * Pending                                               Die Bestellung wurde aufgegeben, aber noch nicht bearbeitet.
 * Processing(estimatedProcessingTime: Int)              Die Bestellung wird derzeit bearbeitet.
 * Shipped(trackingNumber: String, shippedDate: String)  Die Bestellung wurde versendet.
 * Delivered(deliveryDate: String, recipient: String)    Die Bestellung wurde zugestellt.
 * Cancelled(reason: String)                             Die Bestellung wurde storniert.
 */

sealed class OrderStatus

object Pending : OrderStatus()
data class Processing(val estimatedProcessingTime: Int) : OrderStatus()
data class Shipped(val trackingNumber: String, val shippedDate: String) : OrderStatus()
data class Delivered(val deliveryDate: String, val recipient: String) : OrderStatus()
data class Cancelled(val reason: String) : OrderStatus()

/**
 * 2.
 * Erstelle eine Funktion printOrderStatus(status: OrderStatus),
 * die je nach OrderStatus-Typ den Status der Bestellung auf der Konsole ausgibt.
 * Die Ausgabe sollte spezifische Informationen für jeden Status anzeigen.
 */
fun printOrderStatus(status: OrderStatus) {
    when (status) {
        is Pending -> println("Die Bestellung wartet auf Bearbeitung.\n")
        is Processing -> println("Die Bestellung wird bearbeitet. Verbleibende Bearbeitungszeit: ${status.estimatedProcessingTime} Stunden.\n")
        is Shipped -> println("Die Bestellung wurde versendet. Sendungsnummer: ${status.trackingNumber}. Versanddatum: ${status.shippedDate}.\n")
        is Delivered -> println("Die Bestellung wurde zugestellt an ${status.recipient} am ${status.deliveryDate}.\n")
        is Cancelled -> println("Die Bestellung wurde storniert. Grund: ${status.reason}.\n")
    }
}

/**
 * 3.
 * Implementiere eine Data-Klasse Order(orderId:String, status:OrderStatus)
 * Die Klasse soll eine Methode updateStatus(newStatus: OrderStatus) enthalten, um den Bestellstatus zu ändern.
 */
data class Order(val orderId: String, var status: OrderStatus) {
    fun updateStatus(newStatus: OrderStatus) {
        status = newStatus
    }

    /**
     * 4.
     * Erstelle eine Methode estimateDeliveryTime() in der Order-Klasse.
     * Berechne eine geschätzte Lieferzeit in Tagen, basierend auf dem Status
     * Du kannst folgende Annahmen treffen:
     * Processing: 7  Für Bearbeitung und Versand
     * Shipped:    5  Für Versand
     * Delivered:  0
     * Cancelled: -1  Es findet keine Lieferung statt
     */

    fun estimateDeliveryTime(): Int {
        return when (status) {
            is Pending -> 7
            is Processing -> 7
            is Shipped -> 5
            is Delivered -> 0
            is Cancelled -> -1
        }
    }
}

/**
 * 5.
 * Erstelle ein paar Bestellungen, aktualisiere deren Status, und teste die printOrderStatus()- und estimateDeliveryTime()-Methoden.
 */
fun main() {
    val order = Order("ORD123", Pending)
    printOrderStatus(order.status)

    order.updateStatus(Processing(estimatedProcessingTime = 4 ))
    printOrderStatus(order.status)

    order.updateStatus(Shipped(trackingNumber = "TRACK12345", shippedDate = "2024-11-15"))
    printOrderStatus(order.status)

    order.updateStatus(Delivered(deliveryDate = "2024-11-20", recipient = "John Doe"))
    printOrderStatus(order.status)

    println("Voraussichtliche Lieferzeit in Tagen: ${order.estimateDeliveryTime()}")
}
