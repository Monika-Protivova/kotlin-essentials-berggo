package com.motycka.edu.lesson02

val coffeeOrders = mutableMapOf<Int, List<String>>()
private var nextOrderId = 1

fun main() {
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    // processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0)
}

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)
    if (payment < totalToPay) {
        throw IllegalArgumentException("Insufficient payment: $$payment for order total $$totalToPay")
    }
    println("Payment of $$payment accepted for order $orderId")
    val change = payment - totalToPay
    completeOrder(orderId)
    return change
}

fun placerOrder(items: List<String>): Int {
    val orderId = nextOrderId++
    coffeeOrders[orderId] = items
    println("Placed order $orderId: $items")
    return orderId
}

fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId]
        ?: throw IllegalArgumentException("Order ID $orderId not found")
    val prices = items.map { getPrice(it) }          // calls public getPrice from Conditionals.kt
    val discount = if (items.size > 3) prices.minOrNull()!! else 0.0
    val total = prices.sum() - discount
    println("Order $orderId total: $total")
    return total
}

fun completeOrder(orderId: Int) {
    if (!coffeeOrders.containsKey(orderId)) {
        throw IllegalArgumentException("Order ID $orderId not found")
    }
    coffeeOrders.remove(orderId)
    println("Order $orderId completed")
}
