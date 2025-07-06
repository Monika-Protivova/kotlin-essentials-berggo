package com.motycka.edu.lesson02

const val ESPRESSO_PRICE        = 2.5
const val DOUBLE_ESPRESSO_PRICE = 3.0
const val CAPPUCCINO_PRICE      = 3.0
const val LATTE_PRICE           = 3.5
const val AMERICANO_PRICE       = 2.0
const val FLAT_WHITE_PRICE      = 3.2

fun getPrice(item: String): Double = when (item) {
    ESPRESSO        -> ESPRESSO_PRICE
    DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
    CAPPUCCINO      -> CAPPUCCINO_PRICE
    LATTE           -> LATTE_PRICE
    AMERICANO       -> AMERICANO_PRICE
    FLAT_WHITE      -> FLAT_WHITE_PRICE
    else            -> error("Unknown coffee type: $item")
}

private fun totalFor(items: List<String>): Double {
    val prices = items.map(::getPrice)
    val discount = if (items.size >= 3) prices.minOrNull() ?: 0.0 else 0.0
    return prices.sum() - discount
}

fun conditionals() {
    val coffeeOrders = mapOf(
        1 to listOf(ESPRESSO, CAPPUCCINO, LATTE, AMERICANO),
        2 to listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)
    )

    coffeeOrders.forEach { orderId, items ->
        println("Processing Order ID: $orderId")
        println("Items: $items")

        if (items.size >= 3) {
            println("You ordered 3 or more coffees, you get 1 for free!")
        }

        val total = totalFor(items)
        println("Total price for Order ID $orderId: %.1f".format(total))
    }
}

fun main() = conditionals()
