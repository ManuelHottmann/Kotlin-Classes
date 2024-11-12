package com.example.kotlin_classes.classes.sealed_class

/**
 * Zahlungsmethoden für einen Onlineshop
 */
sealed class PaymentMethod

data class CreditCard(val cardNumber: String, val expiryDate: String): PaymentMethod()
data class Paypal(val email:String): PaymentMethod()
object CashOnDelivery: PaymentMethod()

fun processPayment(paymentMethod: PaymentMethod){
    when (paymentMethod) {
        is CreditCard -> println("Zahlung mit Kreditkarte: Karte endet auf ${paymentMethod.cardNumber.takeLast(4)}.\n")
        is Paypal -> println("Zahlung mit Paypal mit der Mail ${paymentMethod.email}.\n")
        CashOnDelivery -> println("Zahlung per Name.")
    }
}
fun main() {
    val creditCardPayment = CreditCard("1234567812345678", "12/25")
    val paypalPayment = Paypal("customer@example.com")
    val cashPayment = CashOnDelivery

    processPayment(creditCardPayment)
    processPayment(paypalPayment)
    processPayment(cashPayment)
}