package com.motycka.edu.lesson02

const val ESPRESSO = "Espresso"
const val DOUBLE_ESPRESSO = "Double Espresso"
const val CAPPUCCINO = "Cappuccino"
const val LATTE = "Latte"
const val MACCHIATO = "Macchiato"
const val MOCHA = "Mocha"
const val FLAT_WHITE = "Flat White"
const val AMERICANO = "Americano"

val coffeeMenu: List<String> = listOf(
    ESPRESSO,
    DOUBLE_ESPRESSO,
    CAPPUCCINO,
    LATTE,
    MACCHIATO,
    MOCHA,
    FLAT_WHITE,
    AMERICANO
)

fun collections() {
    val orders: MutableMap<Int, List<String>> = mutableMapOf()

    println("Welcome to the Coffee Shop! Here is our menu:")
    coffeeMenu.forEach { println(it) }

    val order1 = listOf(
        ESPRESSO,
        CAPPUCCINO, CAPPUCCINO,
        AMERICANO
    )
    orders[1] = order1

    val order2 = listOf(
        ESPRESSO,
        DOUBLE_ESPRESSO,
        FLAT_WHITE
    )
    orders[2] = order2

    println()
    println("Orders placed:")
    orders.forEach { (id, items) ->
        println("Order ID: $id, Items: $items")
    }
}

fun main() {
    collections()
}
