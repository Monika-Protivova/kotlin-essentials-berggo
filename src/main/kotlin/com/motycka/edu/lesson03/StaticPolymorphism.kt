package com.motycka.edu.lesson03

import kotlin.math.PI

object AreaCalculator {
    fun calculateRectangleArea(a: Double, b: Double): Double =
        a * b

    fun calculateRectangleArea(a: Int, b: Int): Double =
        calculateRectangleArea(a.toDouble(), b.toDouble())

    fun calculateCircleArea(r: Double): Double =
        PI * r * r

    fun calculateCircleArea(r: Int): Double =
        calculateCircleArea(r.toDouble())

    fun calculateTriangleArea(a: Double, b: Double): Double =
        a * b / 2.0

    fun calculateTriangleArea(a: Int, b: Int): Double =
        calculateTriangleArea(a.toDouble(), b.toDouble())
}


fun main() {
    println(AreaCalculator.calculateRectangleArea(5, 10))    // 50.0
    println(AreaCalculator.calculateRectangleArea(5.0, 10.0))// 50.0
    println(AreaCalculator.calculateCircleArea(3))           // ~28.274
    println(AreaCalculator.calculateTriangleArea(4, 6))      // 12.0
}

